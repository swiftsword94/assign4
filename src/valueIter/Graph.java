package valueIter;

import java.util.Iterator;

public class Graph
{
	public Node[] map;
	public int size;
	public Graph()
	{
		map = new Node[0];
		size = 0;
	}
	public Graph(int size)
	{
		map = new Node[size];
		size = 0;
	}
	public void addNode(Node node)
	{
		if(size<map.length)
		{
			map[size++] = node;
		}
	}
	public Double getUtility(Node current, Double discount, int depth)
	{
		if(depth <= 0)
		{
			return current.reward;
		}
		Double tmp = 0.0;
		Action action = null;
		//for all the actions available to nextNode
		for(int actionIndex = 0; actionIndex < current.act.size(); actionIndex++)
		{
			Double tmp2 = 0.0;
			action = current.act.get(actionIndex);
			Iterator<Node> outcomeIter = action.outcome.keySet().iterator();
			//for all the outcomes of an action available to nextNode
			while(outcomeIter.hasNext())
			{
				Node destination = outcomeIter.next();
				tmp2 += action.outcome.get(destination) * getUtility(destination, discount, --depth);
				if(tmp < tmp2)
				{
					tmp = tmp2;
				}
			}
		}
		//store the maximum utility
		return current.reward + tmp;
	}
	/**
	 * gets the utility of all nodes by the Bellman Equation (value iteration)
	 * if the depth is set to a negative number then it will compute until all routes to a terminating state is reached 
	 * @param discount
	 * @param maxError
	 * @param depth
	 * @return Double[] containing an array of utilities
	 */
	public Double[] initUtility(Double discount, Double maxError, int depth)
	{
		Double maxChange = 0.0;
		Double[] utility = new Double[map.length];
		int iteration = 0;
		for(int i = 0; i < utility.length; i++)
		{
			utility[i] = 0d;
		}
		//until the maximum change in training is less than a percentage of the maximum error
		do
		{
			System.out.println("Iteration: " + iteration++);
			printUtil(utility);
			//for all the nodes in the graph
			for(int nodeIndex = 0; nodeIndex < map.length; nodeIndex++)
			{
				Node nextNode = map[nodeIndex];
				Double tmp = 0.0;
				Action action = null;
				//for all the actions available to nextNode
				for(int actionIndex = 0; actionIndex < nextNode.act.size(); actionIndex++)
				{
					Double tmp2 = 0.0;
					action = nextNode.act.get(actionIndex);
					Iterator<Node> outcomeIter = action.outcome.keySet().iterator();
					//for all the outcomes of an action available to nextNode
					while(outcomeIter.hasNext())
					{
						Node destination = outcomeIter.next();
						tmp2 += action.outcome.get(destination) * utility[destination.id];
						if(tmp < tmp2)
						{
							tmp = tmp2;
						}
					}
				}
				//store the maximum utility
				utility[nodeIndex] = nextNode.reward + tmp;
				//find the maximum
				if(Math.abs(tmp - utility[nodeIndex]) > maxChange)
				{
					maxChange = tmp;
				}
			}
		}
		while(maxChange < maxError * (1-discount)/discount );
		
		for(int i = 0; i < this.map.length; i++)
		{
			map[i].util = utility[i]; 
		}
		
		return utility;
	}
	
	public void printUtil(Node[] map)
	{
		for(Node node : map)
		{
			System.out.println("Node: " + node.id + " Utility: " + node.util);
		}
	}
	public void printUtil(Double[] map)
	{
		for(int i = 0; i < map.length; i++)
		{
			System.out.println("Node: " + i + " Utility: " + map[i]);
		}
	}
}
