package valueIter;

import java.util.ArrayList;
import java.util.HashMap;

public class Node
{
	public int id;
	public Double reward, util;
	public ArrayList<Action> act;
	
	public Node()
	{
		id = 0;
		this.reward = 0d;
		this.util = 0d;
		this.act = new ArrayList<Action>();
	}
	public Node(Double reward, Double util)
	{
		id = 0;
		this.reward = reward;
		this.util = util;
		this.act = new ArrayList<Action>();
	}
	public Node(int id, Double reward, Double util)
	{
		this.id = id;
		this.reward = reward;
		this.util = util;
		this.act = new ArrayList<Action>();
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
		act.add(tmp);
	}
}
