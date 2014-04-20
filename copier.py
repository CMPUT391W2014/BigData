import os

comm1 = "scp group2@10.1.0.107:\"~/city-aggregate-2.csv ~/cfc-aggregate-2.csv\" ~/"
comm2 = "scp group2@10.1.0.104:\"~/city-aggregate-3.csv ~/cfc-aggregate-3.csv\" ~/"
comm3 = "scp group2@10.1.0.108:\"~/city-aggregate-4.csv ~/cfc-aggregate-4.csv\" ~/"
comm4 = "scp group2@10.1.0.109:\"~/city-aggregate-5.csv ~/cfc-aggregate-5.csv\" ~/"
comm5 = "scp group2@10.1.0.110:\"~/city-aggregate-6.csv ~/cfc-aggregate-6.csv\" ~/"
comm6 = "scp group2@10.1.0.111:\"~/city-aggregate-7.csv ~/cfc-aggregate-7.csv\" ~/"
comm7 = "scp group2@10.1.0.112:\"~/city-aggregate-8.csv ~/cfc-aggregate-8.csv\" ~/"
os.system(comm1)
os.system(comm2)
os.system(comm3)
os.system(comm4)
os.system(comm5)
os.system(comm6)
os.system(comm7)



