#!/bin/sh

# paths to the cassandra source tree, cassandra jar and java
CASSANDRA_HOME="~/cassandra/apache-cassandra-2.0.6
CASSANDRA_JAR="$CASSANDRA_HOME/lib/apache-cassandra-2.0.6.jar"
JAVA=`which java`

# Java classpath. Must include:
#   - directory of DataImportExample
#   - directory with cassandra/log4j config files
#   - cassandra jar
#   - cassandra depencies jar
CLASSPATH=".:$CASSANDRA_HOME/conf:$CASSANDRA_JAR"

for jar in $CASSANDRA_HOME/lib/*.jar; do
    CLASSPATH=$CLASSPATH:$jar
done

$JAVA -ea -cp $CLASSPATH -Xmx256M \
        -Dlog4j.configuration=log4j-tools.properties \
        DataWriter "$@"