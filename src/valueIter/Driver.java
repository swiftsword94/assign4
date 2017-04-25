package valueIter;

public class Driver
{
	public void test()
	{
		Graph graph = new Graph(4);
		
		Node s1 = new Node(new Double(0), 0d);
		Node s2 = new Node(new Double(0), 0d);
		Node s3 = new Node(new Double(1), 0d);
		Node s4 = new Node(new Double(0), 0d);
		
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
	}
	public static void main(String[] args)
	{
		new Driver().test();
	}
}
