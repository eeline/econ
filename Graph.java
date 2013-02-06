import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**Econ_Graph: Inner class of a model.
 * Purpose: Handles all of the graphical drawing of an econ model.
 * Although crude I did this as a learning experience and need 
 * to figure out a better way to implement this. 
 * Will eventually be implemented in an abstract class later*/
public class Graph extends JPanel implements Econ_Constants{

	/**Array to keep track of the Demand curves X coordinates*/
	private int demandX [] = new int [ARRAY_SIZE];
	/**Array to keep track of the Demand curves Y coordinates*/
	private int demandY [] = new int [ARRAY_SIZE];
	/**Array to keep track of the Supply curves X coordinates*/
	private int supplyX [] = new int [ARRAY_SIZE];
	/**Array to keep track of the Supply curves y coordinates*/
	private int supplyY [] = new int [ARRAY_SIZE];
	/**haveModel, boolean var that determines whether the graph class has a model or not*/
	private boolean haveModel = false;
	
	//----	Constructors	----
	
	/**This constructor creates a graph object within the JPanel
	 * and then initializes vars and various other components.
	 * TODO:add constructors and nest action Listeners within the constructors
	 * that respond to changes within the model.*/
	public Graph(){
		setBorder(BorderFactory.createLineBorder(Color.black));
		super.paint(getGraphics());

		/*Not sure what the purpose of this dead code was. Consider removing
		 * as it does not add anything to the program.*/
		 /*ActionListener(new ActionListner() {
	            public void modelChanged(ActionEvent e) {
	                //calls methods that handle the changes within the graph
	            	//moveSquare(e.getX(),e.getY());
	            }
	        });*/
	}
	
	/**This is a messy way of creating a model with the graph class. It is
	 * also not dynamic and confusing. It may be better to further develop
	 * the Graph class so that it can be pass the line data models and 
	 * then extract the data it needs from them instead of creating two
	 * data models to hold the same things.
	 * TODO: Figure out a better way to get the data from the data model
	 * to the visual model.
	 * old TODO:Flesh out this constructor and try and remove getModel method*/
	public Graph(PerfectCompetition_Model pc){
		this.haveModel = true;
		this.demandY = pc.getDemand().getY_Coordinates();
		this.supplyY = pc.getSupply().getY_Coordinates();
	}
	
	//----	Methods		----
	
	/**Gets the model's data for the graph to paint
	 * Inputs: A Perfect Competition Model
	 * Outputs: Void
	 * Purpose: This method extracts the Y coordinates from a PC 
	 * data model in order to process the y data points graphically*/
	public void getModel(PerfectCompetition_Model pc){
		this.haveModel = true;
		this.demandY = pc.getDemand().getY_Coordinates();
		this.supplyY = pc.getSupply().getY_Coordinates();
	}
	
	
	//----	Painting Methods	----
	
	/**Input: A graphics object g
	 * Output: Graphical representation of the Econ Model Data
	 * Purpose: Overides inherited paintComponent method in
	 * order to paint the graph on the JPanel*/
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		/**int: when x = 0, point where the x and y axis intersect*/
		int X_ZERO = (int) (getWidth()*0.25);			
		
		/**int: right most x value of the x axis*/
		int X_MAX = (int) (getWidth()*0.8);
		
		/**int: when Y=0, point where the x and y axis intersect*/
		int Y_ZERO = (int) (getHeight()*0.8);
		
		/**int: top most y value of the Y axis*/
		int Y_MAX = (int) (getHeight()*0.25);
		
		
		//draw the X and Y axis's
		g.drawLine(X_ZERO, Y_ZERO, X_MAX, Y_ZERO);	//x axis's, left to right
		g.drawLine(X_ZERO, Y_MAX, X_ZERO, Y_ZERO);	//y axis's, top to bottom

		//draw x axis's arrow
		g.drawLine(X_MAX, Y_ZERO, X_MAX-10, Y_ZERO-10);
		g.drawLine(X_MAX, Y_ZERO, X_MAX-10, Y_ZERO+10);
		//Draw x (quantity) axis's labels
		g.drawString("Quantity", X_MAX, Y_ZERO+25);

		//Draw the y (price) axis's arrow
		g.drawLine(X_ZERO, Y_MAX, X_ZERO-10, Y_MAX+10);
		g.drawLine(X_ZERO, Y_MAX, X_ZERO+10, Y_MAX+10);
		//Draw y (Price) axis's labels
		g.drawString("Price", X_ZERO-40, Y_MAX+10);

		//label the initial intercept
		g.drawString("0,0", X_ZERO-10, Y_ZERO+15);

		if(haveModel==true){
			Polygon d = new Polygon();
			Polygon s = new Polygon();
			
		/**all calculations here are relative to CONS_x AND CONS_Y
		 * as I am using those as starting point for the graph, 
		 * ie I want to calculate the distance from the axis's*/
			for(int i = 0 ; i < demandX.length; i++){
				supplyX[i] = X_ZERO + i;
				demandX[i] = X_ZERO + i;
				
				if(i > Y_ZERO){
					supplyY[i] = Y_ZERO - supplyY[i];
					demandY[i] = Y_ZERO - demandY[i];
				}
				/*else if( i < (4/3) * Y_MAX){ 
					break;
					supplyY[i] = supplyY[i-1];
					demandY[i] = Y_ZERO;
				}*/
			}
			
			/*Draws the Demand curve using a polygon*/
			d = new Polygon(demandX, demandY, demandX.length);
			g.setColor(Color.BLUE);
			g.drawPolygon(d);
			d.reset();

			/*Draws the Supply curve using a polygon*/
			s = new Polygon(supplyX, supplyY, supplyX.length);
			g.setColor(Color.RED);
			g.drawPolygon(s);
			s.reset();
		}
	}

	//override the preferred dimensions method 
	public Dimension getPreferredSize(){
		return new Dimension(350, 350);
	}
}