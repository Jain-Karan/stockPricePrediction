import function.Function;


public class Layers {

    //Parameters
    public double[] input;
    public Nodes[] nodes;
    private double Zinj;
    Function function;

    public Layers (int numNodes, int numInputs) {

        function = new SigmoidFunction();
        nodes = new Nodes[numNodes];
        //assign all inputs each node in the layer
        for (int i = 0; i < numNodes; i++) {
            nodes[i] = new Nodes(numInputs);
        }

        input = new double[numInputs];
        Zinj = 0;
    }

    public void feedForwardActivation()
    {
        //Activation for each node  feed forward
        for(int pNode = 0; pNode < nodes.length; pNode++)
        {
            Zinj = 0;
            for(int pWeight = 0;pWeight < nodes[pNode].weight.length; pWeight++)
            {
                Zinj = Zinj + input[pWeight] * nodes[pNode].weight[pWeight];
            }
           
            nodes[pNode].g =function.calculate(Zinj);
            nodes[pNode].out = nodes[pNode].g;
        }
    }

    public double[] getOutputsLayer()
    {
        //get all outputs of the layer
        double[] outputsLayer = new double[nodes.length];
        for(int pNode = 0; pNode < nodes.length; pNode++)
        {
            outputsLayer[pNode] = nodes[pNode].out;
        }
        return (outputsLayer);

    }
}
