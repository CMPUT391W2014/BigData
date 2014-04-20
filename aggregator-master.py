import csv


masterCfcDict = {}
masterCityDict = {}



for i in range(1, 9):
	with open("cfc-aggregate-" + str(i) + ".csv", "rb") as csvfile:
		reader = csv.reader(csvfile)
		for row in reader:
			try:
				masterCfcDict[row[0]] = str(int(masterCfcDict[row[0]]) + int(row[1]))

			except KeyError:
				masterCfcDict[row[0]] = str(int(row[1]))


for i in range(1, 9):
	with open("city-aggregate-" + str(i) + ".csv", "rb") as csvfile:
		reader = csv.reader(csvfile)
		for row in reader:
			try:
				masterCityDict[row[0]] = str(int(masterCityDict[row[0]]) + int(row[1]))

			except KeyError:
				masterCityDict[row[0]] = str(int(row[1]))



with open("cfc-aggregate-master2.csv", "wb") as csvfile:
	writer = csv.writer(csvfile)
	for i in masterCfcDict.keys():
		row = [i, masterCfcDict[i]]
		writer.writerow(row)


with open("city-aggregate-master2.csv", "wb") as csvfile:
	writer = csv.writer(csvfile)
	for i in masterCityDict.keys():
		row = [i, masterCityDict[i]]
		writer.writerow(row)



	
