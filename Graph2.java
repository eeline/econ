import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Graph2 extends JComponent implements Econ_Constants{
	private static final long serialVersionUID = 1L;
	
	private int w = getWidth();
	private int h = getHeight();
	private int imageWidth = GRAPH_WIDTH;
	private int imageHeight = GRAPH_HEIGHT;
	
	private ArrayList<Rectangle> rectangles;
	private ArrayList<Ellipse> ellipses;
	private ArrayList<Line> lines;
	
	/**Constructor*/
	public Graph2(){
		super();
		rectangles = new ArrayList<Rectangle>();
		ellipses = new ArrayList<Ellipse>();
		lines = new ArrayList<Line>();
	}
	
	/**Constructor*/
	public Graph2(int width, int height){
		this();
		imageWidth = width;
		imageHeight = height;
	}
	
	/**Method: adds a rectangle to the Graph's array list of rectangles.
	 * will be used later for handling extended form games.*/
	public void addRectangle(Rectangle r){
		rectangles.add(r);
	}

	/**Method: adds an ellipse to the Graph's array list of lines*/
	public void addEllipse(Ellipse e){
		ellipses.add(e);
	}

	/**Method: Adds a line to the Graph's array list of lines*/
	public void addLine(Line l){
		lines.add(l);
	}
	
	/**Method: Overrides paint component all the object to be painted*/
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		//fill background
		g2.setColor(Color.white);
		g2.fillRect(0, 0, imageWidth, imageHeight);
		
		Rectangle r;
		for(int i = 0; i<rectangles.size(); i++){
			r = rectangles.get(i);
			g2.setColor(r.color);
			g2.fill(r);
		}
		
		Ellipse e;
		for(int i = 0; i<ellipses.size(); i++){
			e = ellipses.get(i);
			g2.setColor(e.color);
			g2.fill(e);
		}
		
		Line l;
		for(int i = 0; i<lines.size(); i++){
			l = lines.get(i);
			g2.setColor(l.color);
			g2.draw(l);
		}
		
		g2.setColor(Color.BLACK);			//reset the color for g2 to black
		
		//draw the X and Y axis's
		g2.drawLine(X_ZERO, Y_ZERO, X_MAX, Y_ZERO);	//x axis's, left to right
		g2.drawLine(X_ZERO, Y_MAX, X_ZERO, Y_ZERO);	//y axis's, top to bottom

		//draw x axis's arrow
		g2.drawLine(X_MAX, Y_ZERO, X_MAX-10, Y_ZERO-10);
		g2.drawLine(X_MAX, Y_ZERO, X_MAX-10, Y_ZERO+10);
		//Draw x (quantity) axis's labels
		g2.drawString("Quantity", X_MAX, Y_ZERO+25);

		//Draw the y (price) axis's arrow
		g2.drawLine(X_ZERO, Y_MAX, X_ZERO-10, Y_MAX+10);
		g2.drawLine(X_ZERO, Y_MAX, X_ZERO+10, Y_MAX+10);			//Draw y (Price) axis's labels
		g2.drawString("Price", X_ZERO-40, Y_MAX+10);

		//label the initial intercept
		g2.drawString("0,0", X_ZERO-10, Y_ZERO+15);
	}

	/**Method*/
	public void display(){
		JFrame frame = new JFrame();
		//adjust height for toolbar.
		frame.setSize(imageWidth+22, imageHeight+22);
		frame.setTitle("Graph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);
	}
}
