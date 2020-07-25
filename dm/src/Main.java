import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//starts here
        String file = "data/a.txt";
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number of hidden layers");
        int nhl=s.nextInt();
        int[] nodes=new int[nhl+2];
        nodes[0] = 4;
        nodes[nhl+1]=1;
        System.out.println("Enter number of nodes in each layer(hidden)");
        int x=1;
        while(nhl>0){
         nodes[x]=s.nextInt(); 
         nhl--;
         x++;
        }
        System.out.println("Enter number of epochs");
        int epochs = s.nextInt();
        System.out.println("Enter learning rate");
        double rateLearning = s.nextDouble();
        int dataTrain = 180;
        int dataTest =60;
        double[] parameters = new double[5];

        parameters[0] = rateLearning;
        parameters[1] = 0;
        parameters[2] = epochs;
        parameters[3] = dataTrain;
        parameters[4] = dataTest;
        NeuralNetwork net = new NeuralNetwork(nodes,parameters, file);
        net.neuralNetwork();
    }
}
