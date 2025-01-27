/**
 * ICS4U7 IA: Chemistry IA Planner
 * Author: Srilakshmi Akhilan
 * Date: 04/03/2024
 */

// Import the following packages:
import java.awt.*;

import javax.swing.*;

/**
 * The following class helps run the main program
 * @author Sri
 *
 */
public class ChemPlanApp extends JFrame {
	
	static CardLayout cl;
	static Container c;
	
	WelcomePanel welcomeP;
	AboutPanel aboutP;
	AppMenuPanel appMenuP;
	SignUpPanel signUpP;
	LoginPanel loginP;
	StudentPlannerPanel studentPlanP;
	IAPanel iaP;
	MaterialsPanel matP;
	TeacherPlannerPanel teacherPlanP;
	LogoutPanel logoutP;
	ReviewIAPanel reviewIAP;
	
	public ChemPlanApp() {

		this.setTitle("don't bomb it");
		this.setVisible(true);
		this.setResizable(false);
//		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c = getContentPane();
		cl = new CardLayout();
		c.setLayout(cl);
		
		this.setSize(700, 550);
		c.setBackground(new Color(119, 158, 186));
		
		welcomeP = new WelcomePanel();
		c.add("welcomePage", welcomeP);
		
		aboutP = new AboutPanel();
		c.add("aboutPage", aboutP);
		
		appMenuP = new AppMenuPanel();
		c.add("appMenuPage", appMenuP);
		
		signUpP = new SignUpPanel();
		c.add("signUpPage", signUpP);
		
		loginP = new LoginPanel();
		c.add("loginPage", loginP);
		
		logoutP = new LogoutPanel();
		c.add("logoutPage", logoutP);
		
	}
	
	public static void main(String[] args) {
		new ChemPlanApp();
	}
}
