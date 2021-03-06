import java.io.*;
import java.util.StringTokenizer;
public class DataPrediction {

    public double[][] inputTraining;
    public double[][] inputTest;
    public double[][] expectedOutputs;
    private double[]  predictions;
    private String file;
    private int train;
    private int test;

    public DataPrediction(double[] parameters, String name)
    {
        inputTraining = new double[(int)parameters[3]+1][5];
        inputTest = new double[(int)parameters[4]][5];
        file = name;
        train = (int)parameters[3];
        test = (int)parameters[4];
    }

    public void readDates()
    {
        String line = "";
        double[] numColumns;
        try{
            File fileText = new File(file);
            FileReader fileReader = new FileReader(fileText);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            int numTrain = 0;
            int numTest = 0;
            // System.out.println("Read File x: "+file);
            while((line = bufferReader.readLine()) != null)
            {
                numColumns = tokenData(line);
               //System.out.println("numColumns:"+numColumns.length);
                if(numTrain <= train){
                    for (int pData = 0; pData < numColumns.length; pData++)
                    {
                        inputTraining[numTrain][pData] = numColumns[pData];
                         
                    }
                    numTrain += 1;
                }
                else
                {
                    if(numTrain > train)
                    {
                        for(int pData = 0; pData < numColumns.length; pData++)
                        {
                            inputTest[numTest][pData]=numColumns[pData];
                        }
                        numTest += 1;
                    }
                }
            }

        }
        catch (Exception e)
        {
            System.out.println("Read File: " + e.getMessage());
        }
    }

    private double[] tokenData(String line) {

        //Separate each columns of the line
        StringTokenizer token = new StringTokenizer(line, ",");
        int numTokens = token.countTokens();
        double[] arrayToken = new double[numTokens];
        for (int pToken = 0; pToken < numTokens; pToken++)
        {
            arrayToken[pToken] = Double.parseDouble(token.nextToken());
        }

        return(arrayToken);
    }

    public void writeDataPrediction(double[] numPredictions)
    {
        //write in file text, the prediction of set test
        predictions = numPredictions;
        File file = new File("data/ResultDataPrediction");
        File file2 = new File("data/ResultDataPrediction2");
        File file3 = new File("data/expoutput");
        try
        {
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
            PrintWriter printWrite = new PrintWriter(bufferWrite);
            printWrite.write("Original "+" predicted "+" err"+'\n');
            for(int pData = 0; pData < predictions.length; pData++)
            {
                double a=(expectedOutputs[pData][0]*1981.5)+6970.6;
                double b=(predictions[pData]*1981.5)+6970.6;
                double err=Math.abs(a-b)/a*100;
      printWrite.write(String.valueOf(Math.round(a))+"       "+String.valueOf(Math.round(b)) +"      "+err+'\n');
            }
            printWrite.close();
            bufferWrite.close();


            FileWriter fileWrite2 = new FileWriter(file2);
            BufferedWriter bufferWrite2 = new BufferedWriter(fileWrite2);
            PrintWriter printWrite2 = new PrintWriter(bufferWrite2);
            for(int pData = 0; pData < predictions.length; pData++)
            {
               // double a=(expectedOutputs[pData][0]*1981.5)+6970.6;
                double b=(predictions[pData]*1981.5)+6970.6;
               
      printWrite2.write(String.valueOf(Math.round(b))+'\n');
            }
            printWrite2.close();
            bufferWrite2.close();


            FileWriter fileWrite3 = new FileWriter(file3);
            BufferedWriter bufferWrite3 = new BufferedWriter(fileWrite3);
            PrintWriter printWrite3 = new PrintWriter(bufferWrite3);
            for(int pData = 0; pData < predictions.length; pData++)
            {
                double a=(expectedOutputs[pData][0]*1981.5)+6970.6;
                //double b=(predictions[pData]*1981.5)+6970.6;
               
      printWrite3.write(String.valueOf(Math.round(a))+'\n');
            }

            printWrite3.close();
            bufferWrite3.close();


            
        }
        catch (Exception e)
        {
            System.out.println("Write File: " + e.getMessage());
        }
    }

    public void loadDataOutputsTrain()
    {
        
        expectedOutputs = new double[inputTraining.length][1];

        
        for(int pPattern = 0; pPattern < inputTraining.length; pPattern++)
        {
            expectedOutputs[pPattern][0]=inputTraining[pPattern][4];
        }

    }

    public void loadDataOutputsTest()
    {
        
        expectedOutputs = new double[inputTest.length][1];
        for(int pPattern = 0; pPattern < inputTest.length; pPattern++)
        {
            expectedOutputs[pPattern][0]=inputTest[pPattern][4];
        }

    }

    public void calculateError()
    {
        double errorPartial = 0;
        double errorTotal = 0;
        double sumReal = 0;
        double sumErrorPartial = 0;

        for(int pData = 0; pData < test; pData++)
        {
            errorPartial = expectedOutputs[pData][0] - predictions[pData];
            sumErrorPartial +=Math.abs(errorPartial);
            sumReal += expectedOutputs[pData][0];
        }
        errorTotal = (sumErrorPartial / sumReal) * 100;
        System.out.println("The Error total of prediction is: " + errorTotal + "%");
    }

}
