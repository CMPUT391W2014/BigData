#.SUFFIXES: .java .class

#.java.class:
#	javac $<

#CLASSES = DataWriter.class GeneratorThread.class Generator.class

#all: $(CLASSES)

DataWriter.class:
	javac -classpath ~/cassandra/apache-cassandra-2.0.6/lib/apache-cassandra-2.0.6.jar DataWriter.java


#GeneratorThread.class:
#	javac GeneratorThread.java

#Generator.class:
#	javac Generator.java

clean:
	$(RM) *.class