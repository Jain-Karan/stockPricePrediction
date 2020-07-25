import matplotlib.pyplot as plt
import csv

x = []
y = []
x1= []
y1= []
d=1;
with open('ResultDataPrediction2','r') as csvfile:
    plots = csv.reader(csvfile, delimiter=',')
    for row in plots:
        y.append(int(row[0]))
        x.append(d+1)
        d=d+1

d=1
with open('expoutput','r') as csvfile:
    plots = csv.reader(csvfile, delimiter=',')
    for row in plots:
        y1.append(int(row[0]))
        x1.append(d+1)
        d=d+1
        
plt.plot(x,y, label='original value')
plt.plot(x1,y1, label='predicted value')
plt.xlabel('index no')
plt.ylabel('value')

plt.title('Original vs predicted values')
plt.legend()
plt.show()


