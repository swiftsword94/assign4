package valueIter;

import java.util.ArrayList;
import java.util.HashMap;

public class Node
{
	public Double reward, util;
	public ArrayList<Action> act;
	
	public Node()
	{
		
	}
	public Node(Double reward, Double util)
	{
		this.reward = reward;
		this.util = util;
	}
	public void addAction(Node[] dest,  Double[] prob)
	{
		if(dest.length != prob.length || dest.length == 0)
		{
			System.out.println("Error: malformed action");
		}
		Action tmp = new Action();
		for(int i = 0; i < dest.length; i++)
		{
			tmp.addOutcome(dest[i], prob[i]);
		}
	}
}
