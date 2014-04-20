import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.GregorianCalendar;
import java.util.Random;
import java.nio.ByteBuffer;
import java.io.*;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


public class DataWriter2 {
	
    private final int ROW_COUNT = 1000;
    private final int ITERATIONS = 1;

    private Random rand = new Random();

    private Map<String, Integer> cityMap = new HashMap<String, Integer>();
    private Map<String, Integer> cfcMap = new HashMap<String, Integer>();


    private final String DATE_VALUE = randDate();
    private final String PHONE_NUMBER = randPhoneNumber();

    private final String LAST_LONGITUDE = String.valueOf(randLongitude(179, 180));
    private final String LAST_LATITUDE = String.valueOf(randLatitude(0, 90));
    private final String INT_VALUE = String.valueOf(randInt(1000000, 3000000));


    private String filePath1;
    private String filePath2;
    private String filePath3;
    private String filePath4;
    private String filePath5;
    private String filePath6;
    private String filePath7;
    private String filePath8;
    private String Q3_1Path;
    private String Q3_2Path;
    private String cfcDataPath;
    private String cityDataPath;

    private String cpyPath1;
    private String cpyPath2;
    private String cpyPath3;
    private String cpyPath4;
    private String cpyPath5;
    private String cpyPath6;
    private String cpyPath7;
    private String cpyPath8;
    private String Q3_1CpyPath;
    private String Q3_2CpyPath;
    private String cfcPath;
    private String cityPath;


    
    //try {
    //	private static FileWriter seizFileWriter = new FileWriter(seizFile);
    //	private static FileWriter cfcFileWriter = new FileWriter(cfcFile);
    //} catch (Exception e) {
    //	e.printStackTrace();
    //}
    


    
    public DataWriter2(int id) throws Exception {

	filePath1 = "part1-" + String.valueOf(id) + ".csv";
	filePath2 = "part2-" + String.valueOf(id) + ".csv";
	filePath3 = "part3-" + String.valueOf(id) + ".csv";
	filePath4 = "part4-" + String.valueOf(id) + ".csv";
	filePath5 = "part5-" + String.valueOf(id) + ".csv";
	filePath6 = "part6-" + String.valueOf(id) + ".csv";
	filePath7 = "part7-" + String.valueOf(id) + ".csv";
	filePath8 = "part8-" + String.valueOf(id) + ".csv";
	Q3_1Path = "Q3_1Path-" + String.valueOf(id) + ".csv";
	Q3_2Path = "Q3_2Path-" + String.valueOf(id) + ".csv";
	cfcDataPath = "cfc-" + String.valueOf(id) + ".csv";
	cityDataPath = "city-" + String.valueOf(id) + ".csv";

	cpyPath1 = "cpy1-" + String.valueOf(id) + ".txt";
	cpyPath2 = "cpy2-" + String.valueOf(id) + ".txt";
	cpyPath3 = "cpy3-" + String.valueOf(id) + ".txt";
	cpyPath4 = "cpy4-" + String.valueOf(id) + ".txt";
	cpyPath5 = "cpy5-" + String.valueOf(id) + ".txt";
	cpyPath6 = "cpy6-" + String.valueOf(id) + ".txt";
	cpyPath7 = "cpy7-" + String.valueOf(id) + ".txt";
	cpyPath8 = "cpy8-" + String.valueOf(id) + ".txt";
	Q3_1CpyPath = "Q3_1CpyPath-" + String.valueOf(id) + ".txt";
	Q3_2CpyPath = "Q3_2CpyPath-" + String.valueOf(id) + ".txt";
	cfcPath = "cfc-" + String.valueOf(id) + ".txt";
	cityPath = "city-" + String.valueOf(id) + ".txt";

	FileWriter out1 = new FileWriter(new File(cpyPath1));
	out1.write("copy part1 from " + "'" + "~/" + filePath1 + "';");
	out1.close();
	FileWriter out2 = new FileWriter(new File(cpyPath2));
	out2.write("copy part2 from " + "'" + "~/" + filePath2 + "';");
	out2.close();
	FileWriter out3 = new FileWriter(new File(cpyPath3));
	out3.write("copy part3 from " + "'" + "~/" + filePath3 + "';");
	out3.close();
	FileWriter out4 = new FileWriter(new File(cpyPath4));
	out4.write("copy part4 from " + "'" + "~/" + filePath4 + "';");
	out4.close();
	FileWriter out5 = new FileWriter(new File (cpyPath5));
	out5.write("copy part5 from " + "'" + "~/" + filePath5 + "';");
	out5.close();
	FileWriter out6 = new FileWriter(new File (cpyPath6));
	out6.write("copy part6 from " + "'" + "~/" + filePath6 + "';");
	out6.close();
	FileWriter out7 = new FileWriter(new File (cpyPath7));
	out7.write("copy part7 from " + "'" + "~/" + filePath7 + "';");
	out7.close();
	FileWriter out8 = new FileWriter(new File (cpyPath8));
	out8.write("copy part8 from " + "'" + "~/" + filePath8 + "';");
	out8.close();
	FileWriter out9 = new FileWriter(new File (cfcPath));
	out9.write("copy cfc_grouping from " + "'" + "~/" + cfcDataPath + "';");
	out9.close();
	FileWriter out10 = new FileWriter(new File (cityPath));
	out10.write("copy city_grouping from " + "'" + "~/" + cityDataPath + "';");
	out10.close();
	FileWriter out11 = new FileWriter(new File(Q3_1CpyPath));
	out11.write("copy query3_table1 from " + "'" + "~/" + Q3_1Path + "';");
	out11.close();
	FileWriter out12 = new FileWriter(new File(Q3_2CpyPath));
	out12.write("copy query3_table2 from " + "'" + "~/" + Q3_2Path + "';");
	out12.close();


	run();

    }
	
	
	
	

    public void run() throws Exception {


	//FileWriter seizFileWriter = new FileWriter(seizFile);
    	FileWriter cfcFileWriter = new FileWriter(new File(cfcDataPath)); 
	FileWriter cityFileWriter = new FileWriter(new File(cityDataPath));

	//File seizFile = new File(seizGroupFile);
	//File cfcFile = new File(cfcGroupFile);
	//	File file1 = new File(filePath1);
	//File file2 = new File(filePath2);
	//File file3 = new File(filePath3);
	//File file4 = new File(filePath4);
	//File file5 = new File(filePath5);
	//File file6 = new File(filePath6);
	//File file7 = new File(filePath7);
	//File file8 = new File(filePath8);
	//FileWriter writer1 = new FileWriter(file1);
	//FileWriter writer2 = new FileWriter(file2);
	//FileWriter writer3 = new FileWriter(file3);
	//FileWriter writer4 = new FileWriter(file4);
	//FileWriter writer5 = new FileWriter(file5);
	//FileWriter writer6 = new FileWriter(file6);
	//FileWriter writer7 = new FileWriter(file7);
	//FileWriter writer8 = new FileWriter(file8);
	for (int j = 0; j < ITERATIONS; j++) {
	    //System.out.println("Iteration");
	    File file1 = new File(filePath1);
	    File file2 = new File(filePath2);
	    File file3 = new File(filePath3);
	    File file4 = new File(filePath4);
	    File file5 = new File(filePath5);
	    File file6 = new File(filePath6);
	    File file7 = new File(filePath7);
	    File file8 = new File(filePath8);
	    File file9 = new File(Q3_1Path);
	    File file10 = new File(Q3_2Path);

	    FileWriter writer1 = new FileWriter(file1);
	    FileWriter writer2 = new FileWriter(file2);
	    FileWriter writer3 = new FileWriter(file3);
	    FileWriter writer4 = new FileWriter(file4);
	    FileWriter writer5 = new FileWriter(file5);
	    FileWriter writer6 = new FileWriter(file6);
	    FileWriter writer7 = new FileWriter(file7);
	    FileWriter writer8 = new FileWriter(file8);
	    FileWriter writer9 = new FileWriter(file9);
	    FileWriter writer10 = new FileWriter(file10);
	
	    
	    writePart1(writer1);
	    writer1.close();
	    writePart2(writer2);
	    writer2.close();
	    writePart3(writer3);
	    writer3.close();
	    writePart4(writer4);
	    writer4.close();
	    writePart5(writer5);
	    writer5.close();
	    writePart6(writer6);
	    writer6.close();
	    writePart7(writer7);
	    writer7.close();
	    writePart8(writer8);
	    writer8.close();
	    writeQuery3_table1(writer9);
	    writer9.close();
	    writeQuery3_table2(writer10);
	    writer10.close();
	    

	    //writePart2(writer2);
	    //writer2.close();
	    copyPart1();
	    copyPart2();
	    copyPart3();
	    copyPart4();
	    copyPart5();
	    copyPart6();
	    copyPart7();
	    copyPart8();
	    copyQuery3_table1();
	    copyQuery3_table2();


	}

	writeMaps(cfcFileWriter, cityFileWriter);
	//seizFileWriter.close();
	cfcFileWriter.close();
	cityFileWriter.close();
	//copyCity();
	//copyCfc();
	System.out.println("Done");
	//writer1.close();
	//writer2.close();
	//writer3.close();
	//writer4.close();
	//writer5.close();
	//writer6.close();
	//writer7.close();
	//writer8.close();

    }



    private String randDate() {
	GregorianCalendar gc = new GregorianCalendar();
	int year = randInt(2008, 2013);

	gc.set(gc.YEAR, year);
	
	int month = randInt(1, 12);
	gc.set(gc.MONTH, month);
	while (gc.get(gc.MONTH) == 0) {
	    month = randInt(1, 12);
	    gc.set(gc.MONTH, month);
	}
	int day = randInt(1, 25);
	gc.set(gc.DAY_OF_MONTH, day);


       	int hour = randInt(1, 24);
       	int minute = randInt(0, 59);
       	int second = randInt(0, 59);

       	gc.set(gc.HOUR_OF_DAY, hour);
       	gc.set(gc.MINUTE, minute);
       	gc.set(gc.SECOND, second);
		
       	return gc.get(gc.YEAR) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.DAY_OF_MONTH) + " " + gc.get(gc.HOUR_OF_DAY)
				+ ":" + gc.get(gc.MINUTE) + ":" + gc.get(gc.SECOND);
	
    }

    private String randString() {
       	char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
       	StringBuilder sb = new StringBuilder();
       	Random random = new Random();
       	for (int i = 0; i < 20; i++) {
       	    char c = chars[random.nextInt(chars.length)];
       	    sb.append(c);
       	}
       	return sb.toString();
    }
	
    private int randInt(int start, int end) {
       	return rand.nextInt((end-start) + 1) + start;
    }
	
    private float randLatitude(float min, float max) {
       	return rand.nextFloat() * (min + max);
    }

    private float randLongitude(float min, float max) {
	return rand.nextFloat() * (min + max) - max;
    }

    private String randPhoneNumber() {
	char[] chars = "0123456789".toCharArray();
	StringBuilder sb = new StringBuilder();
       	Random random = new Random();
       	for (int i = 0; i < 10; i++) {
       	    char c = chars[random.nextInt(chars.length)];
       	    sb.append(c);
       	}
	String number = sb.toString();
	//Integer result = seizMap.get(number);
	//seizMap.put(number, (result == null) ? 1: result+1);
	
       	return number;
    }

    private int randCFC() {
	int[] vals = new int[3];
	vals[0] = 168;
	vals[1] = 408;
	vals[2] = 418;
	int cfc = vals[randInt(0, 2)];
	Integer result = cfcMap.get(String.valueOf(cfc));
	cfcMap.put(String.valueOf(cfc), (result == null) ? 1: result+1);
	return vals[randInt(0, 2)];
    }

    private int randCityId(int start, int end) {
	//System.out.println("Function called");
	int id = rand.nextInt((end-start) + 1) + start;
	Integer result = cityMap.get(String.valueOf(id));
	cityMap.put(String.valueOf(id), (result == null) ? 1: result + 1);
	//System.out.println(cityMap.get(String.valueOf(id)));
	//System.out.println("Should have been put in map");
	return id;
    }


    private void writePart1(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(String.valueOf(randCFC()));
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(String.valueOf(randCityId(0, 250)));
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(String.valueOf(randInt(0, 250)));
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(DATE_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(LAST_LATITUDE);
	    writer.write(",");
	    writer.write(LAST_LONGITUDE);
	    writer.write(",");
	    writer.write(String.valueOf(randLatitude(0, 90)));
	    writer.write(",");
	    writer.write(String.valueOf(randLongitude(179, 180)));
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(DATE_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");
	}
    }


    private void writePart2(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");

	}
    }

    private void writePart3(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(PHONE_NUMBER);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");

	}
    }

    private void writePart4(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");

	}
    }

    private void writePart5(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");

	}
    }

    private void writePart6(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");

	}
    }

    private void writePart7(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");

	}
    }

    private void writePart8(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write(",");
	    writer.write(INT_VALUE);
	    writer.write("\n");

	}
    }

    private void writeQuery3_table1(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(String.valueOf(randCFC()));
	    writer.write(",");
	    writer.write(String.valueOf(randLatitude(0, 90)));
	    writer.write(",");
	    writer.write(String.valueOf(randLongitude(179, 180)));
	    writer.write(",");
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write("\n");
	}
    }

    private void writeQuery3_table2(FileWriter writer) throws Exception {
	for (int k = 0; k < ROW_COUNT; k++) {
	    writer.write(randDate());
	    writer.write(",");
	    writer.write(String.valueOf(randCFC()));
	    writer.write(",");
	    writer.write(String.valueOf(randLatitude(0, 90)));
	    writer.write(",");
	    writer.write(String.valueOf(randLongitude(179, 180)));
	    writer.write(",");
	    writer.write(randPhoneNumber());
	    writer.write("\n");
	}
    }


    private void copyPart1() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath1);
	p.waitFor();
	//System.out.println("copied");
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/
	
	
	

    }

    private void copyPart2() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath2);
	p.waitFor();
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/
	
	

    }


    private void copyPart3() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath3);
	p.waitFor();
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/
	

    }


    private void copyPart4() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath4);
	p.waitFor();
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/
	

    }



    private void copyPart5() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath5);
	p.waitFor();
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/

    }

    private void copyPart6() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath6);
	p.waitFor();
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/
	

    }

    private void copyPart7() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath7);
	p.waitFor();
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/
	

    }

    private void copyPart8() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cpyPath8);
	p.waitFor();
	/*
	BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String s = "";
	while ((s = stdInput.readLine()) != null) {
	    System.out.println(s);
	}
	*/
	

    }


    
    private void copyCity() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cityPath);
	p.waitFor();
    }
    

    private void copyCfc() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + cfcPath);
	p.waitFor();
    }

    private void copyQuery3_table1() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + Q3_1CpyPath);
	p.waitFor();
    }


    private void copyQuery3_table2() throws IOException, InterruptedException {
	Process p = Runtime.getRuntime().exec("python shellCall.py " + Q3_2CpyPath);
	p.waitFor();
    }

 
       
	
	
    private void writeMaps(FileWriter cWriter, FileWriter cityWriter) throws IOException {
	Iterator it;
	it = cityMap.entrySet().iterator();
	while (it.hasNext()) {
	    Map.Entry pairs = (Map.Entry)it.next();
	    //System.out.println("Here");
	    cityWriter.write(pairs.getKey().toString());
	    cityWriter.write(",");
	    cityWriter.write(pairs.getValue().toString());
	    cityWriter.write("\n");
	    it.remove();
	}
      
	//System.out.println();
	it = cfcMap.entrySet().iterator();
	while (it.hasNext()) {
	    Map.Entry pairs = (Map.Entry)it.next();
	    cWriter.write(pairs.getKey().toString());
	    cWriter.write(",");
	    cWriter.write(pairs.getValue().toString());
	    cWriter.write("\n");
	    it.remove();
	}

    }


}
