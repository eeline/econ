/**File:	Econ_Canvas_Controller.java
 * ---------------------------------------
 * This class is the main JFrame onto which the models will be draw,
 * it will also handle user inputs and select the correct model to display
 * */

import javax.swing.*;

import com.sun.org.apache.xml.internal.utils.StopParseException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class CanvasController extends JFrame implements Econ_Constants{

	private String[] modelStrings = {"Please Select a Model", "Bertrand", "Cournot", "Monopoly", "Perfect Competition", "Stackelburg"};
	private JComboBox modelList = new JComboBox(modelStrings);
	private Graph graph = new Graph();

	/**Constructor: Shows the a default graph and the Combo box to choose the model*/
	public CanvasController(){
		setLayout(new BorderLayout());

		//add action listeners to the combo box
		modelList.setSelectedIndex(0);
		modelList.addActionListener(new ComboBoxListener());

		this.add(modelList, BorderLayout.NORTH);	//add the modeList jcombobox to the JFrame
		this.add(graph, BorderLayout.CENTER);		//add the graph to the JFrame
		this.pack();
		pack();

	}

/*TODO:Add action listeners for combo box*/
	class ComboBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			//user selects the model from the combo box
			//removes the default graph\model
			//clears the previous model data
			//create and instantiate the selected model

			JComboBox cb = (JComboBox)e.getSource();
			String modelName = (String)cb.getSelectedItem();
			int graph;
			switch(modelName){
				case "Bertrand": 
				case "Cournot":
				case "Monopoly":
				case "Stackleburg":
					remove(graph);
					repaint();
					break;
				case "Perfect Competition":
					remove(graph);
					PerfectCompetiton_GUI pcgui = new PerfectCompetition_GUI();
					add(pcgui, BorderLayout.CENTER);
					revalidate();
					validate();
					break;'
			}
		}
	}

	//main method that starts the app
	public static void main(String [] args){
		CanvasController frame = new CanvasController();			//creates a Supply and Demand Frame
		frame.setTitle(DEFAULT_FRAME_TITLE);									//sets the frames title
		frame.setSize(DEFAULT_MAIN_WINDOW_SIZE_X, DEFAULT_MAIN_WINDOW_SIZE_Y);	//set default size of the frame
		frame.setLocationRelativeTo(null);										//sets the relative location of the frame to the center of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
