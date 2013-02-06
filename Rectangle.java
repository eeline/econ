import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.Color;

public class Rectangle extends java.awt.Rectangle{
	private static final long serialVersionUID = 1L;

	public Color color;

	public Rectangle(Point p, int w, int h, Color c){
		super(p.x,p.y,w,h);
		this.color = c;
	}
}
