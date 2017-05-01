package neuralNet;

public class Coordinate
{
	public Double x, y;
	public int classifier;
	public Coordinate(Double x, Double y, int classifier)
	{
		this.x = x;
		this.y = y;
		this.classifier = classifier;
	}
	public String toString()
	{
		return "("+x+", "+y+", "+classifier+")";
	}
}
