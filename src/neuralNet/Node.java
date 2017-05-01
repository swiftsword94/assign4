package neuralNet;

public class Node
{
	public Node[] child;
	public Double[] weights;
	public Double output;
	public Node()
	{
		initWeights();
		output = 0d;
	}
	public Double inputCompute(Double[] input)
	{
		
		if(input.length != weights.length)
		{
			System.out.println("Different size arrays");
		}
		Double sum = new Double(0d);
		for(int i = 0; i < input.length; i++)
		{
			sum += weights[i]*input[i];
		}
		if(sum > 0)
		{
			return 1d;
		}
		else
		{
			return 0d;
		}
	}
	public Double thresholdCompute()
	{
		Double[] input = new Double[child.length];
		for(int i = 0; i < child.length; i++)
		{
			input[i] = child[i].output;
		}
		if(input.length != weights.length)
		{
			System.out.println("Different size arrays");
		}
		Double sum = new Double(0d);
		for(int i = 0; i < input.length; i++)
		{
			sum += weights[i]*input[i];
		}
		if(sum > 0)
		{
			this.output = 1d;
			return 1d;
		}
		else
		{
			this.output = 0d;
			return 0d;
		}
	}
	public void printWeights()
	{
		for(int i = 0; i < weights.length; i++)
		{
			System.out.println("Weight " + i + ": " + weights[i]);
		}
	}
	public void initWeights(Double[] weights)
	{
		this.weights = new Double[weights.length];
		for(int i = 0; i < weights.length; i++)
		{
			this.weights[i] = weights[i];
		}
	}
	public void initWeights()
	{
		this.weights = new Double[]{1d, 0d, 0d};
	}
}
