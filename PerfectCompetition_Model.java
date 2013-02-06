import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

/**Name: PerfectCompetition_Model
 * Purpose: This class represents the data model for a perfectly competitive market.
 * Last Modified: 2/4/13
 **/
public class PerfectCompetition_Model extends Model implements Econ_Constants{

	/**Creates 2 Econ curves 
	 * TODO: make into arrays to handle multiple supply and demand curves, start thinking
	 * about how to implement that with a GUI 
	 * */
	private Econ_Curve demand = new Econ_Curve(true);
	private Econ_Curve supply = new Econ_Curve();

	private String model_name = new String("Perfect Competition");
	private double optimal_Price;
	private double optimal_Quantity;
	private double welfare;				//W = cs + ps
	private double cs;					//consumer surplus
	private double ps;					//producerSurplus
	private double dwl;					//dead weight loss;

	/**Method: Solve()
	 * Input: VOID
	 * Output: VOID
	 * Purpose: This method simplifies solving the Perfect Competition Model by calling
	 * all of the calcualtion methods from one method.
	 * TODO:Consider reviseing the PC data model to only have one method, as it may
	 * not be useful to call calculation models individually.
	 **/
	public void solve(){
		calcPrice();
		calcQuantity();
		calcCS();
		calcPS();
		calcW();
		calcDWL();
		demand.calcYCoordinates();
		supply.calcYCoordinates();
	}

	/**Method: calcPrice
	 * Formula:
	 * Input:
	 * Output:
	 * Purpose: Calculates price as a function of quantity, 
	 * for a Perfectly Competitive Model
	 **/
	public double calcPrice(){
		return optimal_Price = ((demand.getIntercept() * supply.getSlope()) + (demand.getSlope() * supply.getIntercept())) / (demand.getSlope() + supply.getSlope()); 
	}

	/**Method: calcQuantity
	 * Formula: q* = (intD - abs(intS))/(slopeD + slopeS)
	 * Input: null
	 * Output:
	 * Purpose: Calculates quantity as a function of price Perfectly Competitive data model
	 **/
	public double calcQuantity(){
		return optimal_Quantity = ((demand.getIntercept() - Math.abs(supply.getIntercept())) / (demand.getSlope() + supply.getSlope()));
	}

	/**Method: CalcCS
	 * Formula: 
	 * Input: null
	 * Output: double
	 * Purpose:Calculates the consumer surplus for the Perfectly Competitive data model
	 **/
	public double calcCS(){
		return cs = 0.5*(demand.getIntercept() - optimal_Price)*optimal_Quantity;
	}

	/**Method: CalcPS
	 * Formula:
	 * Input: null
	 * Output: double
	 * Purpose: Calculates the producer surplus for the Perfectly Competitive data model
	 **/
	public double calcPS(){
		return ps = 0.5*(optimal_Price - supply.getIntercept())*optimal_Quantity;
	}	

	/**Method: CalcW
	 * Formula:
	 * Input: null
	 * Output: double
	 * Purpose: Calculates the wellfare for the Perfectly Competitive data model
	 * TODO: finish this method and debug
	 **/
	public double calcW(){
		return welfare = cs + ps;
	}	

	/**Method: CalcDWL
	 * Formula:
	 * Input: null
	 * Output: double
	 * Purpose: Calculates the dead weight loss for the Perfectly Competitive data model
	 * TODO: finish this method
	 **/
	public double calcDWL(){
		return dwl = 0.5*(optimal_Price - supply.getIntercept())*optimal_Quantity;
	}	
	
	//	-----	Getters and Setters	-----
	public Econ_Curve getDemand() {
		return demand;
	}
	public void setDemand(Econ_Curve demand) {
		this.demand = demand;
	}
	public Econ_Curve getSupply() {
		return supply;
	}
	public void setSupply(Econ_Curve supply) {
		this.supply = supply;
	}
	public double getOptimalPrice() {
		return optimal_Price;
	}
	public void setOptimalPrice(double optimalPrice) {
		this.optimal_Price = optimalPrice;
	}
	public double getOptimalQuantity() {
		return optimal_Quantity;
	}
	public void setOptimalQuantity(double optimalQuantity) {
		this.optimal_Quantity = optimalQuantity;
	}
	public double getWelfare() {
		return welfare;
	}
	public void setWelfare(double welfare) {
		this.welfare = welfare;
	}
	public double getCS() {
		return cs;
	}
	public void setCS(double cs) {
		this.cs = cs;
	}
	public double getPS() {
		return ps;
	}
	public void setPS(double ps) {
		this.ps = ps;
	}
	public double getDWL() {
		return dwl;
	}
	public void setDWL(double dwl) {
		this.dwl = dwl;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
}