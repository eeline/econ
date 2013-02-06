/**I am editing this class in order to overhaul the econ_app's drawing 
 * system to incorporate shapes in a more manageable way. This class will
 * not only support linear but also quadratic lines.
 * TODO: figure our a way to represent non-linear lines. Possible constructing 
 * an arraylist of point starting at point 0,0 to n-1,n-1. This inturn could
 * be handled by the class calling the line class.*/


import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.util.ArrayList;

public class Line extends Line2D.Double{
	private static final long serialVersionUID = 1L;

	public Color color;
	
	/**constructor that allows you to pass the line as 2 points (x,y) 
	 * and it will draw them.*/
	public Line(Point p1, Point p2, Color c){
		super(p1, p2);
		this.color = c;
	}

	/**constructor that allows you to pass the line as 2 points*/
	public Line(int x1, int y1, int x2, int y2, Color c){
		super(x1, y1, x2, y2);
		this.color = c;
	}
}
