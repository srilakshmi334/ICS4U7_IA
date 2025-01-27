// Import the following packages:
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * The following class is for the sign-up frame of the application
 * @author Sri
 *
 */
public class SignUpPanel extends JPanel {

	private JLabel signUpHeader, createAccntLbl, userLbl, pwdLbl, minCharLbl, infoStatus;
	private JTextField userInput, pwdInput;
	private JButton signUpBtn, backToSignUpBtn, reLoginBtn;
	private String userField, pwdField;
	private HashMap<String, GeneralUser> info = new HashMap<String, GeneralUser>();
	private String accntFile = "./accounts.txt";

	public SignUpPanel() {

		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));

		signUpHeader = GUIComp.setLabel("sign-up", 280, 30, 120, 45, Font.BOLD, 35, 255, 255, 255);
		this.add(signUpHeader);

		createAccntLbl = GUIComp.setLabel("create your account here!", 235, 90, 330, 30, Font.PLAIN, 20, 245, 240, 228);
		this.add(createAccntLbl);

		userLbl = GUIComp.setLabel("username", 180, 160, 110, 30, Font.PLAIN, 20, 51, 55, 138);
		pwdLbl = GUIComp.setLabel("password", 180, 210, 110, 30, Font.PLAIN, 20, 51, 55, 138);
		minCharLbl = GUIComp.setLabel("min 8 characters", 180, 240, 180, 20, Font.PLAIN, 14, 51, 55, 138);

		this.add(userLbl);
		this.add(pwdLbl);
		this.add(minCharLbl);

		userInput = new JTextField();
		userInput.setBounds(290, 165, 200, 20);
		userInput.setFont(new Font("Ink Free", Font.PLAIN, 15));

		pwdInput = new JTextField();
		pwdInput.setBounds(290, 215, 200, 20);
		pwdInput.setFont(new Font("Ink Free", Font.PLAIN, 15));

		this.add(userInput);
		this.add(pwdInput);

		signUpBtn = new JButton("complete sign-up");
		signUpBtn.setBounds(225, 290, 230, 40);
		signUpBtn.setFont(new Font("Ink Free", Font.BOLD, 25));
		signUpBtn.setForeground(new Color(44, 79, 110));
		signUpBtn.setBackground(new Color(186, 210, 232));
		this.add(signUpBtn);

		infoStatus = new JLabel();
		infoStatus.setText("");
		infoStatus.setBounds(160, 350, 420, 40);
		infoStatus.setFont(new Font("Ink Free", Font.PLAIN, 20));
		infoStatus.setForeground(new Color(245, 240, 228));
		this.add(infoStatus);

		signUpBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				userField = userInput.getText();
				pwdField = pwdInput.getText();

				ChemPlanApp.c.repaint();

				if (userField.length() < 1 || pwdField.length() < 8) {

					infoStatus.setText("seems like your info is incorrect, try again!");
					infoStatus.setBounds(160, 350, 420, 40);
				}
				else {

					if (AppMenuPanel.sBtnPressed == true) {

						infoStatus.setText("");
						info.put(userField, new StudentUser(userField, pwdField));

						// Add info to a text file
						try {

							// Try writing user's info into the text file
							BufferedWriter bw = new BufferedWriter(new FileWriter(accntFile, true));
							bw.write(userField + " " + pwdField + " student " + "\n");

							bw.close(); // close the writer after info is added

							// Inform the user that they can now login
							infoStatus.setText("you're ready to sign-up!");
							infoStatus.setBounds(160, 370, 200, 40);

							// Direct user to login
							reLoginBtn = new JButton("login here");
							reLoginBtn.setBounds(380, 370, 150, 40);
							reLoginBtn.setFont(new Font("Ink Free", Font.BOLD, 25));
							reLoginBtn.setForeground(new Color(44, 79, 110));
							reLoginBtn.setBackground(new Color(213, 218, 237));

							reLoginBtn.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub

									// Link to the login page
									ChemPlanApp.cl.show(ChemPlanApp.c, "loginPage");
								}

							});
 
							// Add re-login button to frame
							add(reLoginBtn);
						}

						// Else, catch the exception
						catch(IOException iox) {
							System.out.println("Problem writing " + accntFile);
						}
					}
					
					else {

						infoStatus.setText("");
						info.put(userField, new TeacherUser(userField, pwdField));

						// Add info to a text file
						try {

							// Try writing user's info into the text file
							BufferedWriter bw = new BufferedWriter(new FileWriter(accntFile, true));
							bw.write(userField + " " + pwdField + " teacher " + "\n");

							bw.close(); // close the writer after info is added

							// Inform the user that they can now login
							infoStatus.setText("you're ready to sign-up!");
							infoStatus.setBounds(160, 370, 200, 40);

							// Direct user to login
							reLoginBtn = new JButton("login here");
							reLoginBtn.setBounds(380, 370, 150, 40);
							reLoginBtn.setFont(new Font("Ink Free", Font.BOLD, 25));
							reLoginBtn.setForeground(new Color(44, 79, 110));
							reLoginBtn.setBackground(new Color(213, 218, 237));

							reLoginBtn.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub

									// Link to the login page
									ChemPlanApp.cl.show(ChemPlanApp.c, "loginPage");
								}

							});
 
							// Add re-login button to frame
							add(reLoginBtn);
						}

						// Else, catch the exception
						catch(IOException iox) {
							System.out.println("Problem writing " + accntFile);
						}
					}
				}
			}

		});

		this.add(signUpBtn);

		backToSignUpBtn = GUIComp.setButton("back to sign-up menu", 440, 455, 230, 35, 20);
		this.add(backToSignUpBtn);

		backToSignUpBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				infoStatus.setText("");
				userInput.setText("");
				pwdInput.setText("");
				ChemPlanApp.cl.show(ChemPlanApp.c, "appMenuPage");
			}

		});
	}
}
