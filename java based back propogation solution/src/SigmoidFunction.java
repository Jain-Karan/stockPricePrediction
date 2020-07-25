
import function.Function;

public class SigmoidFunction implements Function{

    public SigmoidFunction()
    {

    }

    @Override
    public double calculate(double newValue) {
        return 1/(1 + Math.exp(-newValue));
    }
}
