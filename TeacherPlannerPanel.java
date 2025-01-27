// Import the following packages:
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The following class is for the teacher's planning page
 * @author Sri
 *
 */
public class TeacherPlannerPanel extends JPanel {
	
	private JLabel planHeader, usernameLbl, welcomeH, instructionH, stdNmLbl, stdNumberLbl, andLbl, errorLbl;
	private String chkUser, chkNum, line;
	private JTextField stdNameField, stdNumField;
	private JButton viewIABtn, logoutBtn;
	private BufferedReader br;
	private boolean found;
	
	static String userNm;
	static String IAFileInfo;
	 
	public TeacherPlannerPanel(String username) {
		
		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));
		
		planHeader = GUIComp.setLabel("your planner", 240, 50, 240, 45, Font.BOLD, 35, 255, 255, 255);
		this.add(planHeader);
		
		userNm = LoginPanel.userInfo.getText();
		usernameLbl = GUIComp.setLabel("hello, " + userNm, 20, 20, 200, 30, Font.PLAIN, 20, 255, 255, 255);
		this.add(usernameLbl);
		
		welcomeH = GUIComp.setLabel("welcome, this is your page to review your students' IAs", 70, 130, 520, 30, Font.PLAIN, 22, 51, 55, 138);
		this.add(welcomeH);
		
		instructionH = GUIComp.setLabel("enter student username and email to view", 165, 180, 330, 20, Font.PLAIN, 18, 245, 240, 228);
		this.add(instructionH);
		
		// Create JLabels & JTextFields for the following info
		stdNmLbl = GUIComp.setLabel("student name:", 160, 230, 200, 30, Font.PLAIN, 20, 245, 241, 240);
		this.add(stdNmLbl);
		
		stdNameField = new JTextField();
		stdNameField.setBounds(295, 235, 200, 20);
		stdNameField.setFont(new Font("Ink Free", Font.PLAIN, 15));
		this.add(stdNameField);
		
		andLbl = GUIComp.setLabel("AND", 320, 275, 50, 30, Font.PLAIN, 21, 51, 55, 138);
		this.add(andLbl);
		
		stdNumberLbl = GUIComp.setLabel("student number:", 143, 320, 200, 30, Font.PLAIN, 20, 245, 241, 240);
		this.add(stdNumberLbl);
		
		stdNumField = new JTextField();
		stdNumField.setBounds(295, 325, 200, 20);
		stdNumField.setFont(new Font("Ink Free", Font.PLAIN, 15));
		this.add(stdNumField);
		
		// Logout JButton
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
		
		// Leads to the student's IA page
		viewIABtn = new JButton("view IA");
		viewIABtn.setBounds(260, 380, 140, 45);
		viewIABtn.setFont(new Font("Ink Free", Font.BOLD, 23));
		viewIABtn.setForeground(new Color(51, 55, 138));
		viewIABtn.setBackground(new Color(200, 195, 212));
		this.add(viewIABtn);
		
		viewIABtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				chkUser = stdNameField.getText();
				chkNum = stdNumField.getText();
				
				IAFileInfo = "./IAInfo/" + chkUser + "IAinfo.txt";
				
				try {
					br = new BufferedReader(new FileReader(IAFileInfo));
					
					while ((line = br.readLine()) != null) {
						String check = chkNum;
						if (line.contains(check)) {
							found = true;
						}
					}
				}
				catch(IOException iox) {
					System.out.println("Problem reading " + IAFileInfo);
				}
				
				if (found == true) {
					
					// Link to student's IA page
					ReviewIAPanel reviewIAP = new ReviewIAPanel(IAFileInfo, chkUser);
					ChemPlanApp.c.add("reviewIAPage", reviewIAP);
					ChemPlanApp.cl.show(ChemPlanApp.c, "reviewIAPage");
				}
				
				else {
					errorLbl = GUIComp.setLabel("sorry, wrong user or email, please try again", 155, 400, 400, 20, Font.PLAIN, 20, 245, 240, 228);
					add(errorLbl);
				}
			}
			
		});
		
	}
}
