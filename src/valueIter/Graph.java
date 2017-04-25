package valueIter;

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
}
