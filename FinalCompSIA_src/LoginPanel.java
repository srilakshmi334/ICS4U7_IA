// Import the following packages:
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * The following class is for the login page of the application
 * @author Sri
 *
 */
public class LoginPanel extends JPanel {

	private JLabel loginHeader, instrInfo, userLbl, pwdLbl, infoStatus;
	private JButton enterBtn, backToSignUpBtn;
	private String readLine, user, pwd;
	private HashMap<String, GeneralUser> info = new HashMap<String, GeneralUser>();
	private String accntFile = "./accounts.txt";
	private JTextField pwdInfo;
	
	static JTextField userInfo = new JTextField();
	
	public LoginPanel() {

		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));

		loginHeader = GUIComp.setLabel("login", 300, 30, 120, 45, Font.BOLD, 35, 255, 255, 255);
		this.add(loginHeader);

		instrInfo = GUIComp.setLabel("enter the appropriate info", 220, 90, 330, 30, Font.PLAIN, 20, 245, 240, 228);
		this.add(instrInfo);

		userLbl = GUIComp.setLabel("username", 180, 160, 110, 30, Font.PLAIN, 20, 51, 55, 138);
		this.add(userLbl);

		pwdLbl= GUIComp.setLabel("password", 180, 210, 110, 30, Font.PLAIN, 20, 51, 55, 138);
		this.add(pwdLbl);
		
		infoStatus = new JLabel(); 
		infoStatus.setBounds(180, 320, 400, 40);
		infoStatus.setFont(new Font("Ink Free", Font.PLAIN, 20));
		infoStatus.setForeground(new Color(245, 240, 228));
		this.add(infoStatus);
		
//		JTextField userInfo = new JTextField();
		userInfo.setBounds(290, 165, 200, 20);
		userInfo.setFont(new Font("Ink Free", Font.PLAIN, 15));

		pwdInfo = new JTextField();
		pwdInfo.setBounds(290, 215, 200, 20);
		pwdInfo.setFont(new Font("Ink Free", Font.PLAIN, 15));

		this.add(userInfo);
		this.add(pwdInfo);

		// Design enter button
		enterBtn = new JButton("enter");
		enterBtn.setBounds(280, 270, 110, 40);
		enterBtn.setFont(new Font("Ink Free", Font.BOLD, 25));
		enterBtn.setForeground(new Color(44, 79, 110));
		enterBtn.setBackground(new Color(186, 210, 232));
		this.add(enterBtn);

		enterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// Try reading the accounts file and adding the info to the hash map
				try {
					BufferedReader read = new BufferedReader(new FileReader(accntFile));
					String username = "";
					String password = "";
					String userType = "";
					String[] accountInfo;

					while ((readLine = read.readLine()) != null) {
						accountInfo = readLine.split(" "); // split the info in the array w/ a space

						// Store username and password info in the array
						username = accountInfo[0];
						password = accountInfo[1];
						userType = accountInfo[2];

						// Add account information to hash map
						if (userType.equals("student") && info.get(username) == null) {
							info.put(username, new StudentUser(username, password));
						} else if (info.get(username) == null) {
							info.put(username, new TeacherUser(username, password));
						}

					}
					
					read.close();

				}

				// If the file doesn't exist, catch the exception and print an error message
				catch (IOException iox) {
					System.out.println("Problem reading " + accntFile);
				}
					
					user = userInfo.getText();
					pwd = pwdInfo.getText();

					if (info.containsKey(user)) {
						if (info.get(user).getPassword().equals(pwd)) {
							
							// Link to user's profile page
							if (info.get(user).GetIsStudent()) {
								StudentPlannerPanel studentPlanP = new StudentPlannerPanel(user);
								ChemPlanApp.c.add("studentPlannerPage", studentPlanP);
								ChemPlanApp.cl.show(ChemPlanApp.c, "studentPlannerPage");
							}
							else {
								TeacherPlannerPanel teacherPlanP = new TeacherPlannerPanel(user);
								ChemPlanApp.c.add("teacherPlannerPage", teacherPlanP);
								ChemPlanApp.cl.show(ChemPlanApp.c, "teacherPlannerPage");
							}
						}

						else {
							infoStatus.setBounds(220, 320, 400, 40);
							infoStatus.setText("wrong password, try again!");

							userInfo.setText("");
							pwdInfo.setText("");
			
						}
					}

					else {
						infoStatus.setBounds(180, 320, 400, 40);
						infoStatus.setText("this account doesn't exist, try again!");

						userInfo.setText("");
						pwdInfo.setText("");
					
					}

					userInfo.setText("");
					pwdInfo.setText("");

				}

		

		});

		backToSignUpBtn = GUIComp.setButton("back to sign-up menu", 440, 455, 230, 35, 20);
		this.add(backToSignUpBtn);

		backToSignUpBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				infoStatus.setText("");
				userInfo.setText("");
				pwdInfo.setText("");
				ChemPlanApp.cl.show(ChemPlanApp.c, "appMenuPage");
			}

		});
	}
}
