"""
Imports

"""
import numpy as np

class DataPrediction:
    inputTraining=np.array([[1,2,4],[1, 2, 3]], dtype = np.double) 
    inputTest=np.array([[1,2,4],[1, 2, 3]], dtype = np.double)
    expectedOutputs=np.array([[1,2,4],[1, 2, 3]], dtype = np.double)
    __predictions=np.array([1,2,4], dtype = np.double)
    __files=""
    __train=0
    __test=0
  
    def __init__(self,files,parameters=[]):
        self.parameters=parameters
        self.__files=files
        
        inputTraining= np.empty([parameters[3]+1,5])
        inputTest= np.empty([parameters[4]+0,5])
        train=parameters[3]
        test=parameters[4]
    
    def readDates():
        line1=""
        numcolumns=[]
        print(DataPrediction.files)

DataPrediction("helloe",[1,2,3,4,5,2,2,2,])
DataPrediction.readDates()

