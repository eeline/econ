import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*Class: PerfectCompetition_GUI
Purpose*/
public class PerfectCompetition_GUI extends JPanel implements Econ_Constants{

	/**initiates the model logic TODO: find a more elegant way to implement model selection*/
	private PerfectCompetition_Model pc = new PerfectCompetition_Model();
	private Graph graph = new Graph();

	//private gui buttons, fields, and areas for inputs
	private JButton jbtSolve = new JButton("Solve");							//creates the solve button
	private JLabel jlSupplySlope = new JLabel("Supply Curve Slope");			//creates Supply curve slope label
	private JTextField jtfSupplySlope = new JTextField();					//creates Supply curve slope entry area for the user
	private JLabel jlSupplyIntercept= new JLabel("Supply Curve Intercept");		//creates Supply curve intercept label
	private JTextField jtfSupplyIntercept = new JTextField();				//creates Supply curve intercept entry area for the user
	private JLabel jlDemandSlope = new JLabel("Demand Curve Slope"); 			//creates the Demand curve slope label
	private JTextField jtfDemandSlope = new JTextField();					//creates Demand curve entry area for the user
	private JLabel jlDemandIntercept= new JLabel("Demand Curve Intercept");		//creates Demand curve  intercept label
	private JTextField jtfDemandIntercept = new JTextField();				//creates Demand curve intercept entry area for the user

	//private variables for outputs
	private JLabel jlPrice = new JLabel("Equilibrium Price");
	private JTextField jtfPrice = new JTextField();
	private JLabel jlQuantity = new JLabel("Equilibrium Quantity");	
	private JTextField jtfQuantity = new JTextField();
	private JLabel jlCS = new JLabel("Consumer Surplus");
	private JTextField jtfCS = new JTextField();
	private JLabel jlPS = new JLabel("Producer Surplus");
	private JTextField jtfPS = new JTextField();
	private JLabel jlW = new JLabel("Welfare");
	private JTextField jtfW = new JTextField();
	private JLabel jlDWL = new JLabel("Dead Weight Loss");
	private JTextField jtfDWL = new JTextField();

	/**Constructor: Creates the main display for the app and all of its buttons*/
	public PerfectCompetition_GUI(){
		//create a new JPanel to place buttons into, and place the buttons in the panel 
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(0,4,5,5));
		inputPanel.add(jlSupplySlope);
		inputPanel.add(jtfSupplySlope);
		inputPanel.add(jlSupplyIntercept);
		inputPanel.add(jtfSupplyIntercept);

		inputPanel.add(jlDemandSlope);
		inputPanel.add(jtfDemandSlope);
		inputPanel.add(jlDemandIntercept);
		inputPanel.add(jtfDemandIntercept);

		inputPanel.add(jlPrice);
		inputPanel.add(jtfPrice);
		inputPanel.add(jlQuantity);
		inputPanel.add(jtfQuantity);
		inputPanel.add(jlCS);
		inputPanel.add(jtfCS);
		inputPanel.add(jlPS);
		inputPanel.add(jtfPS);
		inputPanel.add(jlW);
		inputPanel.add(jtfW);
		inputPanel.add(jlDWL);
		inputPanel.add(jtfDWL);	

		//JPanel to arrange p1 and jbtSolve button into
		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(inputPanel, BorderLayout.CENTER);
		buttonPanel.add(jbtSolve, BorderLayout.NORTH);

		//add buttonPanel and graph into the frame
		this.setLayout(new BorderLayout());
		this.add(graph, BorderLayout.CENTER);						
		this.add(buttonPanel, BorderLayout.SOUTH);
		validate();
		
		/**register actionsListeners for when the solve button is pushed
		 * TODO: when enter key is pressed solve the model*/
		jbtSolve.addActionListener(new SolveButtonListener());
	}

	class SolveButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			/**Checks if all the necessary fields are filled and then calculates the outcomes for
			 * perfect competition and then displays them!!!!*/
			if((jtfDemandSlope.getText().length()!= 0)&&(jtfDemandSlope.getText()!=""&&(jtfSupplySlope.getText()!="")&&(jtfSupplyIntercept.getText()!=""))){

				//gets the text from the gui and passes it to the model
				pc.getSupply().setSlope(Double.parseDouble(jtfSupplySlope.getText()));
				pc.getSupply().setIntercept(Double.parseDouble(jtfSupplyIntercept.getText()));
				pc.getDemand().setIntercept(Double.parseDouble(jtfDemandIntercept.getText()));
				pc.getDemand().setSlope(Double.parseDouble(jtfDemandSlope.getText()));

				//call the solve method
				pc.solve();

				//sets text on gui
				jtfPrice.setText(Double.toString(pc.getOptimalPrice()));
				jtfQuantity.setText(Double.toString(pc.getOptimalQuantity()));
				jtfCS.setText(Double.toString(pc.getCS()));
				jtfPS.setText(Double.toString(pc.getPS()));
				jtfDWL.setText(Double.toString(pc.getDWL()));
				add(graph, BorderLayout.CENTER);						//add the graph to the JFrame

				//insert call to econ_graph draw function
				graph.getModel(pc);
				graph.repaint();
			}
		}
	}
}