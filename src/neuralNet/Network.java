package neuralNet;

public class Network
{
	Node[][] layer;
	Integer[] size;
	public Network()
	{
		layer = new Node[3][3];
		size = new Integer[3];
	}
	
	public void train(Coordinate coord, int correctClassifier, Double learningRate)
	{
		//load coordinates into input layer
		layer[0][0].output = 1d;
		layer[0][1].output = coord.x;
		layer[0][2].output = coord.y;
		System.out.println("Coordinate: " + coord.toString());
		//for ever node in the network
		for(int row = 1; row < size.length; row++)
		{
			for(int col = 0; col < size[row]; col++)
			{
				System.out.println("\tOn Node: "+row+", "+col);
				//check if miscalculated
				Double currentOutput = layer[row][col].thresholdCompute();
				if(layer[row][col].output != coord.classifier)
				{
					//recalculate each weight
					for(int i = 0; i < layer[row][col].weights.length; i++)
					{
						System.out.println("\t\tWeight shifted by: "+learningRate *(coord.classifier - currentOutput)* layer[row][col].child[i].output);
						layer[row][col].weights[i] = layer[row][col].weights[i] + learningRate *(coord.classifier - currentOutput)* layer[row][col].child[i].output; 
					}
				}
			}
		}
		//get the previous weight
		//add it to the CORRECTclassifier * something(i assume to be the learning rate) * the input
	}
	public void addNode(Node node, int onLayer)
	{
		if(size[onLayer] == null)
		{
			size[onLayer] = 0;
		}
		layer[onLayer][size[onLayer]] = node;
		size[onLayer]++;
	}
	/**
	 * takes in a coordinate array, loads it into the input layer of the neural network,
	 * and computes the answer at the last layer
	 * @param coord
	 */
	public void run(Coordinate[] coord)
	{
		//for all the nodes in layer 0
		for(int col = 0; col < layer[0].length; col++)
		{
			//for all the coordinates
			for(int i = 0; i < coord.length ; i++)
			{
				layer[0][col].output = layer[0][col].inputCompute(new Double[] {1d, coord[i].x, coord[i].y});
			}
		}
		//for all the layers above 0 in the network
		for(int row = 1; row < size.length; row++)
		{
			for(int col = 0; col < size[row]; col++)
			{
				//for all the coordinates
				for(int i = 0; i < coord.length; i++)
				{
					layer[0][col].output = layer[row][col].thresholdCompute();
				}
			}
		}
	}
}
