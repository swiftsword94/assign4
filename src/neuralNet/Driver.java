package neuralNet;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Driver
{
	public void testNetwork(Network net)
	{
		//make nodes
		//the structure will be 2 input perceptrons on the 0th layer
		Node[] nodel0 = new Node[]{new Node(), new Node(), new Node()};
		//3 hidden perceptrons (linear separators) on the 1st layer
		Node[] nodel1 = new Node[]{new Node(), new Node(), new Node()};
		linkLayer(nodel0, nodel1);
		//1 output node on the 2nd layer getting the area in between those linear separators
		Node[] nodel2 = new Node[]{new Node()};
		linkLayer(nodel1, nodel2);
		//add nodes
		for(Node node : nodel0)
		{
			net.addNode(node, 0);
		}
		for(Node node : nodel1)
		{
			net.addNode(node, 1);
		}
		for(Node node : nodel2)
		{
			net.addNode(node, 2);
		}
		//Initialize data
		Coordinate[] data = new Coordinate[12];
		data[0] = new Coordinate(0.08, 0.72, 1);
		data[1] = new Coordinate(0.20, 0.50, 1);
		data[2] = new Coordinate(0.24, 0.30, 1);
		data[3] = new Coordinate(0.35, 0.35, 1);
		data[4] = new Coordinate(0.45, 0.50, 1);
		data[5] = new Coordinate(0.02, 0.48, -1);
		data[6] = new Coordinate(0.10, 1.00, -1);
		data[7] = new Coordinate(0.36, 0.75, -1);
		data[8] = new Coordinate(0.52, 0.24, -1);
		data[9] = new Coordinate(0.70, 0.65, -1);
		data[10] = new Coordinate(0.80, 0.26, -1);
		data[11] = new Coordinate(0.92, 0.45, -1);
		//train neural network on data
		Boolean dataCorrectlyClassified = false;
		while(!dataCorrectlyClassified)
		{
			dataCorrectlyClassified = true;
			for(Coordinate point : data)
			{
				net.train(point, point.classifier, 0.5);
			}
			//verify all points are correctly classified
			for(int i = 0; i < data.length; i++)
			{
				Coordinate [] point = new Coordinate[]{data[i]};
				net.run(point);
				//compare output to coordinate 
				if(net.layer[2][0].output != point[0].classifier)
				{
					dataCorrectlyClassified = false;
					break;
				}
			}
		}
		
		//display the weights and output for all nodes
		for(int row = 0; row < net.layer.length; row++)
		{
			for(int col = 0; col < net.layer[row].length; col++)
			{
				System.out.println("Node (" + row + ", " + col + ") Output: " + net.layer[row][col].output);
				net.layer[row][col].printWeights();
			}
		}
	}
	/**
	 * links layer 2 to layer 1 as l2 having the children l1
	 * @param l1
	 * @param l2
	 */
	public void linkLayer(Node[] l1, Node[] l2)
	{
		//for all nodes in l2
		for(int i = 0; i < l2.length; i++)
		{
			l2[i].child = new Node[l1.length];
			//assign all l1 as its children
			for(int j = 0; j < l1.length; j++)
			{
				l2[i].child[j] = l1[j];
			}
		}
	}
	public static void main(String[] args)
	{
		Network net = new Network();
		new Driver().testNetwork(net);
	}

}
