/** File: CurveFunction.java
 * Last Updated: 9/17/12
 * -----------------------------
 * This class keeps track of all the data for a linear function for
 * a curve function within the scope of economics 
 * IMPLEMENTS: basic characteristics of a linear function
 * METHODS: for getting and setting a Linear Function Object
 * THIS CLASS IS PART OF THE DATA MODEL AND SHOULD HAVE NO REFERENCE TO
 * ANY PART OF THE VIEW OR CONTROLLER*/

public class Econ_Curve implements Econ_Constants{

	/**CurveFunction variables: Y=M*X+B, P=M*Q+b, price = slope*quantity + intercept*/
	/**keeps track of the x and y coordinates of a line, to be passed to drawPolyline*/
	private int [] Y_Coordinates = new int [ARRAY_SIZE];
	private double slope;					//slope: m
	private double intercept;				//intercept: b
	private boolean isDemand;				//boolean to distinguish if a curve is a supply or demand curve

	public Econ_Curve() {
		this.slope = 0;							//slope = 0
		this.intercept = 0;						//intercept = 0
		this.Y_Coordinates = new int[ARRAY_SIZE];
		this.isDemand = false;				//boolean to distinguish if a curve is a supply or demand curve
	}
	
	/**constructor for curves, must specify if its a demand curve or not*/
	Econ_Curve(boolean demand){
		this.slope = 0;								//slope = 0
		this.intercept = 0;							//intercept = 0
		this.Y_Coordinates = new int[ARRAY_SIZE];
		this.isDemand = demand;				//boolean to distinguish if a curve is a supply or demand curve
	}

	//---- Methods ----
	/**isSupply: keeps track of whether a curve is a supply curve or not*/
	public boolean isSupply() {
		return isDemand;
	}

	/**Keep*/
	/**Method: Solve()
	 * Input: VOID
	 * Output: VOID
	 * Purpose: calculates Y coordinates.*/
	public void calcYCoordinates(){

		if(isDemand == true){
			for(int i = 0; i < ARRAY_SIZE; i++){
				Y_Coordinates[i] = (int) (intercept - slope*i); //p=a-bq, for demand
			}
		}else
			for(int i = 0; i < ARRAY_SIZE; i++){
				Y_Coordinates[i] = (int)(intercept + slope*i); //p=a+bq, for supply
			}
	}

	//Getters and setters for slope, and intercept
	public void setSupply(boolean isSupply) {
		this.isDemand = isSupply;
	}
	public double getSlope() {
		return slope;
	}
	public void setSlope(double slope) {
		this.slope = slope;
	}
	public double getIntercept() {
		return intercept;
	}
	public void setIntercept(double intercept) {
		this.intercept = intercept;
	}
	public int[] getY_Coordinates() {
		return Y_Coordinates;
	}
	public void setY_Coordinates(int[] y_Coordinates) {
		Y_Coordinates = y_Coordinates;
	}
}