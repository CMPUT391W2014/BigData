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
  
import org.apache.cassandra.db.marshal.*;
import org.apache.cassandra.io.sstable.SSTableSimpleUnsortedWriter;
import static org.apache.cassandra.utils.ByteBufferUtil.bytes;
import static org.apache.cassandra.utils.UUIDGen.decompose;
import org.apache.cassandra.dht.IPartitioner;
import org.apache.cassandra.dht.RandomPartitioner;

public class DataWriter {
	
	private static final int COLUMN_COUNT = 475;
	private static final int ROW_COUNT = 200000;
	
	private String filePath;
	private String logFile = "log.csv";
	
	private static Random rand = new Random();
	
	public DataWriter(int id) {
		filePath = "data" + String.valueOf(id) + ".csv";
		//filePath = "data1.csv";
		try {
			execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void execute() throws Exception {
		//System.out.println("Starting");
		long start = System.currentTimeMillis();
                File file = new File(filePath);
                FileWriter writer = new FileWriter(file);
                FileWriter logger = new FileWriter(logFile, true);
		int max = 3000000;
		int min = 1000000;
		float longMin = 179;
		float longMax = 180;
		float latMin = 90;
		float latMax = 90;
		int intValue = rand.nextInt((max-min) + 1) + min;
		String strValue = randString();
		float floatValue = rand.nextFloat() * (0 + 90);
		String dateValue = randDate();
		String data[] = new String[COLUMN_COUNT];
		for (int j = 0; j < ROW_COUNT; j++) {
			for (int i = 0; i < COLUMN_COUNT; i++) {
				if ((i == 0) || (i == 39) || (i == 40)) {
					data[i] = String.valueOf(randInt(min, max));
				} else if ((i == 11)) {
					data[i] = String.valueOf(randFloat(longMin, longMax));
				} else if ((i == 12)) {
					data[i] = String.valueOf(randFloat(latMin, latMax));
				} else if ((i == 2) || (i == 3)) {
					data[i] = randDate();
				} else if ((i == 3) || (i == 4)) {
					data[i] = dateValue;
				} else if ((i == 5) || (i == 6) || (i == 7)) {
					data[i] = randString();
				} else if (((i >= 8) && (i <= 10)) || (i == 17) || (i == 18) || ((i >= 24) && (i <= 26))
						|| (i == 29) || (i == 46) || (i == 47) || (i == 79) || (i == 87) || (i == 162)
						|| (i == 163)) {
					data[i] = strValue;
				} else if ((i == 15) || (i == 16)) {
					data[i] = String.valueOf(floatValue);
				} else {
					data[i] = String.valueOf(intValue);
				}
				//records.add(RECORD);
				//size += 4;
			}
	    
			//System.out.println(data.length + " 'records'");
			//System.out.println("Writing row number: " + String.valueOf(j) + "\n");
			for (int k = 0; k < COLUMN_COUNT; k++) {
				writer.write(String.valueOf(data[k]));
				writer.write(",");
			}
			writer.write("\n");
			//System.out.println(size / MEG + " MB");
			//writeRaw(data, f);
				//writeBuffered(records, 8192);
				//writeBuffered(records, (int) MEG);
				//writeBuffered(records, 4 * (int) MEG);
		}
		writer.close();
		long end = System.currentTimeMillis();
		//System.out.println("Done");
		System.out.println((end - start) / 1000f + " seconds");
		logger.append(String.valueOf((end-start) / 1000f));
		logger.append(",");
		logger.close();
	}
	
	
	private String randDate() {
		GregorianCalendar gc = new GregorianCalendar();
		int year = randInt(2008, 2013);

		gc.set(gc.YEAR, year);

		int dayOfYear = randInt(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

		gc.set(gc.DAY_OF_YEAR, dayOfYear);

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
	
	private float randFloat(float min, float max) {
		return rand.nextFloat() * (min + max) - max;
	}
	
	
	static class Entry {
		
		int constInt = getRandomInt();
		float constFloat = getRandomFloat();
		String constStr = getRandomString();
		String constDate = getRandomDate();
		
		int randIntLower = 1000000;
		int randIntUpper = 3000000;
		
		float randFloatLower = 0;
		float randFloatUpper = 90;
		
		
		
		int getRandomInt() {
			return rand.nextInt((randIntUpper-randIntLower) + 1) + randIntLower;
		}
		
		float getRandomFloat() {
			return rand.nextFloat() * (randFloatLower + randFloatUpper);
		}
		
		String getRandomString() {
			char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < 20; i++) {
					char c = chars[random.nextInt(chars.length)];
					sb.append(c);
				}
			return sb.toString();
		}
		
		String getRandomDate() {
			GregorianCalendar gc = new GregorianCalendar();
			int year = randInt(2008, 2013);

			gc.set(gc.YEAR, year);

			int dayOfYear = randInt(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

			gc.set(gc.DAY_OF_YEAR, dayOfYear);

			int hour = randInt(1, 24);
			int minute = randInt(0, 59);
			int second = randInt(0, 59);

			gc.set(gc.HOUR_OF_DAY, hour);
			gc.set(gc.MINUTE, minute);
			gc.set(gc.SECOND, second);
			
			return gc.get(gc.YEAR) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.DAY_OF_MONTH) + " " + gc.get(gc.HOUR_OF_DAY)
					+ ":" + gc.get(gc.MINUTE) + ":" + gc.get(gc.SECOND);
		}
		
		int getConstantInt() {
			return constInt;
		}
		
		float getConstantFloat() {
			return constFloat;
		}
		
		String getConstantString() {
			return constStr;
		}
		
		String getConstantDate() {
			return constDate;
		}
		
		private int randInt(int start, int end) {
			return rand.nextInt((end-start) + 1) + start;
		}
		
	}



}
