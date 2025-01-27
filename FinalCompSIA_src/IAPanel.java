// Import the following packages:
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The following class is for the frame where student's can enter their IA info
 * @author Sri
 *
 */
public class IAPanel extends JPanel {
	
	private JLabel iaHeader, topicLbl, rsQstnLbl, hypLbl, matLbl, varLbl;
	private JTextField topicF, rsQstnF, hypF, varF;
	private JButton saveInfoBtn, materialsBtn, backToPlannerBtn;
	private String topicInfo, rsQstnInfo, hypInfo, varInfo;
	
	static String IAFileInfo;
	
	public IAPanel(String IAInfo) {
		
		this.setLayout(null);
		this.setBackground(new Color(245, 240, 228));
		
		iaHeader = GUIComp.setLabel("the IA", 270, 50, 200, 45, Font.BOLD, 35, 44, 79, 110);
		this.add(iaHeader);
		
		// Add appropriate JLabel and JTextField for each piece of info
		topicLbl = GUIComp.setLabel("topic:", 20, 130, 150, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(topicLbl);
		
		topicF = GUIComp.setTextField(80, 125, 360, 40);
		this.add(topicF);
		
		// ***************
		
		rsQstnLbl = GUIComp.setLabel("research question:", 20, 180, 270, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(rsQstnLbl);
		
		rsQstnF = GUIComp.setTextField(200, 175, 360, 40);
		this.add(rsQstnF);
		
		// ***************
		
		hypLbl = GUIComp.setLabel("hypothesis:", 20, 230, 220, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(hypLbl);
		
		hypF = GUIComp.setTextField(140, 225, 360, 40);
		this.add(hypF);
		
		// ***************
		
		varLbl = GUIComp.setLabel("variables:", 20, 330, 220, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(varLbl);
		
		varF = GUIComp.setTextField(130, 325, 360, 40);
		this.add(varF);
		
		// ***************
		
		matLbl = GUIComp.setLabel("materials:", 20, 280, 220, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(matLbl);
		
		materialsBtn = new JButton("add here");
		materialsBtn.setBounds(130, 275, 120, 40);
		materialsBtn.setFont(new Font("Ink Free", Font.BOLD, 20));
		materialsBtn.setForeground(new Color(255, 255, 255));
		materialsBtn.setBackground(new Color(167, 178, 194));
		this.add(materialsBtn);
		
		materialsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// Link to the materials page
				MaterialsPanel matP = new MaterialsPanel(IAFileInfo);
				ChemPlanApp.c.add("materialsPage", matP);
				ChemPlanApp.cl.show(ChemPlanApp.c, "materialsPage");
			}
			
		});
		
		IAFileInfo = IAInfo; // change input source
		
		// Create a save info button for the IA content
		saveInfoBtn = new JButton("save info");
		saveInfoBtn.setBounds(30, 450, 120, 40);
		saveInfoBtn.setFont(new Font("Ink Free", Font.BOLD, 20));
		saveInfoBtn.setForeground(new Color(44, 79, 110));
		saveInfoBtn.setBackground(new Color(225, 218, 237));
		this.add(saveInfoBtn);
		
		saveInfoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				topicInfo = topicF.getText();
				rsQstnInfo = rsQstnF.getText();
				hypInfo = hypF.getText();
				varInfo = varF.getText();
				
				try {
					FileWriter fw = new FileWriter(IAFileInfo, true);
					fw.write("Topic: " + topicInfo + "\n");
					fw.write("Research Question: " + rsQstnInfo + "\n");
					fw.write("Hypothesis: " + hypInfo + "\n");
					fw.write("Variables: " + varInfo + "\n");
					fw.write("*******************" + "\n"); // break b/w the different versions
					
					fw.close();
				}
				catch(IOException iox) {
					System.out.println("Problem writing " + IAFileInfo);
				}
			}
			
		});
		
		// Create a back button to the planner page
		backToPlannerBtn = GUIComp.setButton("back to planner", 452, 450, 200, 40, 22);
		this.add(backToPlannerBtn);
		
		backToPlannerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "studentPlannerPage");
			}
			
		});
	}
}
