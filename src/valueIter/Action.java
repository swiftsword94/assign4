package valueIter;

import java.util.HashMap;

public class Action
{
	public HashMap<Node, Double> outcome = new HashMap<Node, Double>();
	public Action()
	{
		
	}
	public void addOutcome(Node node, Double prob)
	{
		outcome.put(node, prob);
	}
}
