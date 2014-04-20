import csv

cfcDict = {}
cityDict = {}

for i in range(0, 4):
	with open("cfc-" + str(i) + ".csv", "rb") as csvfile:
		reader = csv.reader(csvfile)
		for row in reader:
			try:
				cfcDict[row[0]] = str(int(cfcDict[row[0]]) + int(row[1]))
			except KeyError:
				cfcDict[row[0]] = str(int(row[1]))


for i in range(0, 4):
	with open("city-" + str(i) + ".csv", "rb") as csvfile:
		reader = csv.reader(csvfile)
		for row in reader:
			try:
				cityDict[row[0]] = str(int(cityDict[row[0]]) + int(row[1]))
			except:
				cityDict[row[0]] = str(int(row[1]))



with open("cfc-aggregate-1.csv", "wb") as csvfile:
	writer = csv.writer(csvfile)
	for i in cfcDict.keys():
		row = [i, cfcDict[i]]
		writer.writerow(row)


with open("city-aggregate-1.csv", "wb") as csvfile:
	writer = csv.writer(csvfile)
	for i in cityDict.keys():
		row = [i, cityDict[i]]
		writer.writerow(row)






