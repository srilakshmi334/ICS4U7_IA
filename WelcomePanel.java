// Import the following packages:
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The following class is for the welcome frame of the application
 * @author Sri
 *
 */
public class WelcomePanel extends JPanel {
	
	private JLabel title, subTitle;
	private JButton about, mainMenu;
	
	public WelcomePanel() {
		
		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));
		
		// Initialize label titles for the welcome page
		String header = "don't bomb it";
		String subHeader = "the chem IA planner you didn't know you needed";
		
		title = GUIComp.setLabel(header, 135, 100, 600, 80, Font.BOLD, 67, 255, 255, 255);
		this.add(title);
		
		subTitle = GUIComp.setLabel(subHeader, 50, 200, 630, 40, Font.PLAIN, 28, 51, 55, 138);
		this.add(subTitle);
		
		about = GUIComp.setButton("about", 150, 270, 145, 45, 30);
		this.add(about);
		
		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "aboutPage");
			}
			
		});
		
		mainMenu = GUIComp.setButton("main menu", 325, 270, 190, 45, 30);
		this.add(mainMenu);
		
		mainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "appMenuPage");
			}
			
		});
	}
}
