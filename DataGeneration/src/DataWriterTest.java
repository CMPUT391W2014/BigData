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
//import static org.apache.cassandra.utils.UUIDGen.decompose;
import org.apache.cassandra.dht.IPartitioner;
import org.apache.cassandra.dht.RandomPartitioner;


public class DataWriterTest {

    public static void main(String[] args) {
	IPartitioner partitioner = new RandomPartitioner();
	System.out.println("Hello World!");
    }

}
