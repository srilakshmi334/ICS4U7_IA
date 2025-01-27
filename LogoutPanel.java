// Import the following packages:
import java.awt.*;
import javax.swing.*;

/**
 * The following class is for the logout page of the application
 * @author Sri
 *
 */
public class LogoutPanel extends JPanel {
	
	private JLabel logoutLbl;
	
	public LogoutPanel() {
		
		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));
		
		logoutLbl = GUIComp.setLabel("you've signed out successfully, see you later!", 105, 230, 470, 30, Font.PLAIN, 25, 51, 55, 138);
		this.add(logoutLbl);
	}
}
