// Import the following packages:
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The following class is for the student's planning page
 * @author Sri
 *
 */
public class StudentPlannerPanel extends JPanel {
	
	private JLabel planHeader, usernameLbl, stdNumLbl, stdEmailLbl, stdLevelLbl, iaCreationH;
	private String userNm, studentNum, studentEmail;
	private JTextField stdNum, stdEmail;
	private JRadioButton sl, hl;
	private JButton createIABtn, logoutBtn, saveBtn;
	
	static String IAFileInfo;

	public StudentPlannerPanel(String username) {
		
		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));
		
		planHeader = GUIComp.setLabel("your planner", 240, 50, 240, 45, Font.BOLD, 35, 255, 255, 255);
		this.add(planHeader); 
		
		userNm = username;
		
		usernameLbl = GUIComp.setLabel("hello, " + userNm, 20, 20, 200, 30, Font.PLAIN, 20, 255, 255, 255);
		this.add(usernameLbl);
		
		stdNumLbl = GUIComp.setLabel("student #: ", 20, 130, 200, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(stdNumLbl);
		
		stdEmailLbl = GUIComp.setLabel("student email: ", 20, 180, 200, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(stdEmailLbl);
		
		stdLevelLbl = GUIComp.setLabel("select level: ", 20, 230, 200, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(stdLevelLbl);
		
		iaCreationH = GUIComp.setLabel("create your IA here:", 20, 320, 200, 30, Font.PLAIN, 22, 245, 240, 228);
		this.add(iaCreationH);
		
		// JTextFields/JRadioButtons for the above info
		stdNum = new JTextField();
		stdNum.setBounds(130, 135, 200, 20);
		stdNum.setFont(new Font("Ink Free", Font.PLAIN, 15));
		this.add(stdNum);
		
		stdEmail = new JTextField();
		stdEmail.setBounds(165, 185, 200, 20);
		stdEmail.setFont(new Font("Ink Free", Font.PLAIN, 15));
		this.add(stdEmail);
		
		// Select only one radio button at a time
		ButtonGroup level = new ButtonGroup();

		// Customize radio buttons
		sl = GUIComp.setRadioButton("SL", 145, 235, 55, 25, level);
		this.add(sl);
		
		hl = GUIComp.setRadioButton("HL", 205, 235, 55, 25, level);
		this.add(hl);
		
		logoutBtn = GUIComp.setButton("logout", 510, 450, 140, 40, 22);
		this.add(logoutBtn);
		
		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// Link to logout page
				ChemPlanApp.cl.show(ChemPlanApp.c, "logoutPage");
			}
			
		});
		
		saveBtn = new JButton("save");
		saveBtn.setBounds(35, 450, 80, 40);
		saveBtn.setFont(new Font("Ink Free", Font.BOLD, 20));
		saveBtn.setForeground(new Color(44, 79, 110));
		saveBtn.setBackground(new Color(225, 218, 237));
		this.add(saveBtn);
		
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				studentNum = stdNum.getText();
				studentEmail = stdEmail.getText();
				
				stdNum.setEditable(false);
				stdEmail.setEditable(false);
				sl.setEnabled(false);
				hl.setEnabled(false);
				
				IAFileInfo = "./" + "IAinfo.txt";
				
				try {
					
					// Add student's basic info to their text file
					FileWriter fw = new FileWriter(IAFileInfo, true);
					fw.write("Student: " + userNm + "\n");
					fw.write("Student #: " + studentNum + "\n");
					fw.write("Email: " + studentEmail + "\n");
					
					if (sl.isSelected()) {
						fw.write("Level: SL" + "\n");
					}
					else if (hl.isSelected()) {
						fw.write("Level: HL" + "\n");
					}
					else {
						fw.write("Level: N/A" + "\n");
					}
					
					fw.close();
				}
				catch(IOException iox) {
					System.out.println("Problem writing " + IAFileInfo);
				}
				
			}
			
		});
		
		createIABtn = new JButton("create IA");
		createIABtn.setBounds(250, 390, 150, 50);
		createIABtn.setFont(new Font("Ink Free", Font.BOLD, 23));
		createIABtn.setForeground(new Color(44, 79, 110));
		createIABtn.setBackground(new Color(218, 235, 209));
		this.add(createIABtn);
		
		createIABtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				studentNum = stdNum.getText();
				studentEmail = stdEmail.getText();
				
				IAFileInfo = "./IAInfo/" + userNm + "IAinfo.txt";
				
				try {

					// Add student's basic info to their text file
					FileWriter fw = new FileWriter(IAFileInfo, true);
					fw.write("Student: " + userNm + "\n");
					fw.write("Student #: " + studentNum + "\n");
					fw.write("Email: " + studentEmail + "\n");

					if (sl.isSelected()) {
						fw.write("Level: SL" + "\n");
					}
					else if (hl.isSelected()) {
						fw.write("Level: HL" + "\n");
					}
					else {
						fw.write("Level: N/A" + "\n");
					}

					fw.close();
				}
				catch(IOException iox) {
					System.out.println("Problem writing " + IAFileInfo);
				}

				// Link to IA page
				IAPanel iaP = new IAPanel(IAFileInfo);
				ChemPlanApp.c.add("IAPage", iaP);
				ChemPlanApp.cl.show(ChemPlanApp.c, "IAPage");
			}
			
		});
		
	}
	
}
