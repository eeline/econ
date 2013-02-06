/**This class is the parent class to all models with the Econ_App.
 * It will define a standard set of variables, methods, getters, and setters
 * for each model. Every model will then override these its parents
 * component parts to supply the calculations for the specific model.
 * THIS IS THE DATA MODEL AND SHOULD NOT HAVE ANY REFERENCE TO EITHER THE VIEW
 * OR CONTROLLER*/

public class Model {
	
	//VARIABLES
	private double optimal_Price;
	private double optimal_Quantity;
	private double welfare;				// W = cs + ps
	private double cs;					//consumer surplus
	private double ps;					//producerSurplus
	private double dwl;					//dead weight loss;
	
	/**All models should have an identifier string*/
	private String model_name;

	//constructors
	
	//methods

	/**Method: Solve - calls all of the calculation methods for a models variables*/
	public void solve(){
	}
	
	//getters and setters
	public double getOptimal_Price() {
		return optimal_Price;
	}
	public void setOptimal_Price(double optimal_Price) {
		this.optimal_Price = optimal_Price;
	}
	public double getOptimal_Quantity() {
		return optimal_Quantity;
	}
	public void setOptimal_Quantity(double optimal_Quantity) {
		this.optimal_Quantity = optimal_Quantity;
	}
	public double getWelfare() {
		return welfare;
	}
	public void setWelfare(double welfare) {
		this.welfare = welfare;
	}
	public double getCs() {
		return cs;
	}
	public void setCs(double cs) {
		this.cs = cs;
	}
	public double getPs() {
		return ps;
	}
	public void setPs(double ps) {
		this.ps = ps;
	}
	public double getDwl() {
		return dwl;
	}
	public void setDwl(double dwl) {
		this.dwl = dwl;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	
}
