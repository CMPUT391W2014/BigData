#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

/* Ben Dubois
 * a program to generate java code for cassandra SSTable creation machine
 * I'm coding it to do an output for the following type:
 * 
 * First:
 * with key_validation_class=LexicalUUIDType
    and comparator=AsciiType
    and column_metadata=[
        { column_name: 'firstname', validation_class: AsciiType }
        { column_name: 'lastname', validation_class: AsciiType }
        { column_name: 'password', validation_class: AsciiType }
        { column_name: 'age', validation_class: LongType, index_type: KEYS }
        { column_name: 'email', validation_class: AsciiType }];
 * 
 * Then:
 * 
 * for (...each csv entry...)
 * ByteBuffer uuid = ByteBuffer.wrap(decompose(entry.key));
 * usersWriter.newRow(uuid);
 * usersWriter.addColumn(bytes("firstname"), bytes(entry.firstname), timestamp); 
 * -------
 * 
 * As per the page at: 
 * http://www.datastax.com/dev/blog/bulk-loading
*/
/*
 * TODO:: What does the "Constraint by timestamp" mean in the bottom of the sql schema?
 */

/* how many tables to make*/
int numTables;

static void usage()
{
	extern char * __progname;
	fprintf(stderr, "usage: %s number_of_tables\n", __progname);
	exit(1);
}

static void validate() {
	char *input, *saveptr1, *s;
	char *varName, *varType, *line, *ptr;
	char *varchar, *integer, *fl;
	varchar = "varchar";
	integer = "int";
	fl = "float";
	FILE *sql;
	FILE *outCode;
	FILE *outJava;
	outCode = fopen("outputCode.txt", "w");
	outJava = fopen("outputJava.txt", "w");
	static const char filename[] = "bigdata_setup1.sql";
	varName = (char*)malloc(sizeof(char)*256);
	varType = (char*)malloc(sizeof(char)*256);
	input = (char*)malloc(sizeof(char)*256);
	fprintf(outCode, "with key_validation_class=LexicalUUIDType\n and comparator=AsciiType\n and column_metadata=[\n");
	fprintf(outJava, "eventWriter.newRow(uuid);\n");
	sql = fopen ( filename, "r" );
	int counter = 0;
	int bound = (480/numTables);
	/* Start print STARTTIME and SEIZ_CELL_NUM
	 * This defines the primary keys for each group of 60 columns.
	 */
	fprintf(outCode, "\t{ column_name: 'STARTTIME', validation_class: date }\n");
	fprintf(outCode, "\t{ column_name: 'SEIZ_CELL_NUM', validation_class: varchar(20) }\n");
	fprintf(outJava, "usersWriter.addColumn(bytes(\"STARTTIME\"), bytes(entry.GETSTARTTIME), timestamp);\n");
	fprintf(outJava, "usersWriter.addColumn(bytes(\"SEIZ_CELL_NUM\"), bytes(entry.GETSOURCENUMBER), timestamp);\n");
	while(fgets(input, 256, sql) != 0) {
		if (counter >= bound) {
			counter = 0;
			fprintf(outCode, "}\nwith key_validation_class=LexicalUUIDType\n and comparator=AsciiType\n and column_metadata=[\n");
			fprintf(outCode, "\t{ column_name: 'STARTTIME', validation_class: date }\n");
			fprintf(outCode, "\t{ column_name: 'SEIZ_CELL_NUM', validation_class: varchar(20) }\n");
			fprintf(outJava, "\neventWriter.newRow(uuid);\n");
			fprintf(outJava, "usersWriter.addColumn(bytes(\"STARTTIME\"), bytes(entry.GETSTARTTIME), timestamp);\n");
			fprintf(outJava, "usersWriter.addColumn(bytes(\"SEIZ_CELL_NUM\"), bytes(entry.GETSOURCENUMBER), timestamp);\n");
		}
		else {
			counter++;
		}
		varName = strtok_r(input, " ", &saveptr1);
		//Grabs first string
		if (varName == NULL) {
			fprintf(stderr, "no variable name read\n");
		}
		//Grabs second string
		varType = strtok_r(NULL, " ", &saveptr1);
		if (varType == NULL) {
			fprintf(stderr, "no variable type read\n");
		}
		int len = strlen(varType);
		if( varType[len-1] == '\n' ) {
			varType[len-1] = 0; //remove newline
			varType[len-2] = 0; //remove ','
		}
		
		// These lines get changed to format the code output
		//***
		if (strncmp(varType, varchar, 7) > 0)
			varType = "AsciiType";
		//***
// 		if (strncmp(varType, integer, 3) > 0)
// 			varType = "LongType";
		fprintf(outCode, "\t{ column_name: '%s', validation_class: %s }\n",
						 varName, varType);
		fprintf(outJava, "usersWriter.addColumn(bytes(\"%s\"), bytes(entry.%s), timestamp);\n",
						varName, varName);
		//***
	}
}

int main(int argc, char* argv[]) {
	if (argc != 2) {
		usage();
	}
	numTables = atoi(argv[1]);
	validate();
	return 1;
}
