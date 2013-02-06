	/**
	 * File: EconConstants.java
	 * --------------------------------
	 * This file declares several constants that are shared by the
	 * different modules in the Econ application.  Any class
	 * that implements this interface can use these constants.
	 * TODO: Move all the vars to the classes that need them and delete this class
	 * graphical vars, such as coordinates and labels, should be dynamic and its very
	 * confusing to have an entire class devoted to just vars. Plus 
	 * I may need to use the "implements interface" function of a class
	 * for other interfaces.  
	 */

import java.awt.Point;

public interface Econ_Constants{
	/**Default frame titles*/
	public static final String DEFAULT_FRAME_TITLE = "My Econ Tutor";
		
	/**Default X and Y frame sizes for the application frame window*/
	public static final int DEFAULT_MAIN_WINDOW_SIZE_X = 600;
	public static final int DEFAULT_MAIN_WINDOW_SIZE_Y = 475;

	
//----Graph----	
	/**Default sizes for the graph*/
	public static final int  GRAPH_WIDTH = 400; 
	public static final int  GRAPH_HEIGHT = 400;
	
	/**Strings for the Graph Labels
	 * TODO: REMOVE! Label data should be stored within the data model,
	 * its the most efficient way to keep the program dynamic AND to not have to
	 * initialize  extra vars*/
	public static final String SUPPLY = "Supply";
	public static final String DEMAND = "Demand";
	public static final String QUANTITY = "Quantity";
	public static final String PRICE = "Price";
	public static final String P_OPT = "P*";
	public static final String Q_OPT = "Q*";
	public static final String P1 = "P1";
	public static final String P2 = "P2";
	public static final String Q1 = "Q1";
	public static final String Q2 = "Q2";

	/**Default number of x and y coordinates for the curve Curve.XYcoordinates*/
	public static final int  ARRAY_SIZE = 150;
}
