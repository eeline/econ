import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Ellipse2D.Double{
	private static final long serialVersionUID = 1L;

	public Color color;

	public Ellipse(Point p, int w, int h, Color c){
		super(p.x,p.y,w,h);
		this.color = c;
	}
}
