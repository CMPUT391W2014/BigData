import os, sys

command1 = "~/cassandra/apache-cassandra-2.0.6/bin/cqlsh 10.1.0.105 9132 -k bigdata -f cfc-grouping.txt"
command2 = "~/cassandra/apache-cassandra-2.0.6/bin/cqlsh 10.1.0.105 9132 -k bigdata -f city-grouping.txt"

os.system(command1)
os.system(command2)
