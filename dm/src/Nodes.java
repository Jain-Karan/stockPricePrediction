
public class Nodes {

    //Parameters
    public double deltaWeight[];
    public double weight[];
    public double deltaError;
    public double h;
    public double g;
    public double out;

    public Nodes(int numNodes)
    {
        weight = new double[numNodes];
        deltaWeight = weight.clone();
        deltaError = 0;
        h = 0;
        g = 0;
        out = 0;
        startWeight();
    }

    public void startWeight()
    {
        //Assigment random each weight for each node
        for(int i = 0; i < weight.length;  i++)
        {
            weight[i] = Math.random();
            deltaWeight[i] = 0;
        }
       
    }
}
