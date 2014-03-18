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
	fprintf(outJava, "eventWriter.newRow(uuid);");
	sql = fopen ( filename, "r" );
	while(fgets(input, 256, sql) != 0) {
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

int main() {
	validate();
	return 1;
}
