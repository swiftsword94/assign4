package valueIter;

public class Driver
{
	public void test()
	{
		Graph graph = new Graph(4);
		
		Node s1 = new Node(0, new Double(0), 0d);
		Node s2 = new Node(1, new Double(0), 0d);
		Node s3 = new Node(2, new Double(1), 1d);
		Node s4 = new Node(3, new Double(0), 0d);
		
		s1.reward = 0.0;
		s2.reward = 0.0;
		s3.reward = 1.0;
		s4.reward = 0.0;
		
		s1.addAction(new Node[]{s1, s2}, new Double[]{0.2, 0.8});
		s1.addAction(new Node[]{s1, s4}, new Double[]{0.2, 0.8});
		s2.addAction(new Node[]{s2, s3}, new Double[]{0.2, 0.8});
		s2.addAction(new Node[]{s2, s1}, new Double[]{0.2, 0.8});
		s3.addAction(new Node[]{s2}, new Double[]{1.0});
		s3.addAction(new Node[]{s4}, new Double[]{1.0});
		s4.addAction(new Node[]{s4, s3}, new Double[]{0.1, 0.9});
		s4.addAction(new Node[]{s4, s1}, new Double[]{0.2, 0.8});
		
		graph.addNode(s1);
		graph.addNode(s2);
		graph.addNode(s3);
		graph.addNode(s4);
		
		graph.initUtility(.9d, .000000000000001d);
		System.out.println("FINAL: ");
		graph.printUtil(graph.map);
	}
	public static void main(String[] args)
	{
		new Driver().test();
	}
}
