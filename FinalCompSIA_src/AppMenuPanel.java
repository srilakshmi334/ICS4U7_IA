// Import the following packages:
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The following class is for the program's main menu
 * @author lakhs
 *
 */
public class AppMenuPanel extends JPanel {
	
	private JLabel signUpHeader, selection, studentLbl, teacherLbl, chkForAccnt;
	private JButton student_btn, teacher_btn, login_btn, back_btn;
	
	static boolean sBtnPressed = false;
	static boolean loginPressed = false;
	
	public AppMenuPanel() {
		
		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));
		
		signUpHeader = GUIComp.setLabel("sign-up", 280, 30, 120, 45, Font.BOLD, 35, 255, 255, 255);
		this.add(signUpHeader);
		
		selection = GUIComp.setLabel("select the appropriate profile", 210, 90, 350, 30, Font.PLAIN, 20, 245, 240, 228);
		this.add(selection);
		
		student_btn = GUIComp.setButton(170, 160, 130, 150, 186, 210, 232, new ImageIcon("student.jpg"));
		this.add(student_btn);
		
		student_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				sBtnPressed = true;
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "signUpPage");
				// create student object
			}
			
		});
		
		teacher_btn = GUIComp.setButton(340, 160, 180, 150, 186, 210, 232, new ImageIcon("teacher.jpg"));
		this.add(teacher_btn);
		
		teacher_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				sBtnPressed = false;
				ChemPlanApp.cl.show(ChemPlanApp.c, "signUpPage");
				// create teacher object
			}
			
		});
		
		studentLbl = GUIComp.setLabel("STUDENT", 187, 330, 120, 25, Font.PLAIN, 20, 245, 240, 228);
		this.add(studentLbl);
		
		teacherLbl = GUIComp.setLabel("EDUCATOR", 375, 330, 120, 25, Font.PLAIN, 20, 245, 240, 228);
		this.add(teacherLbl);
		
		chkForAccnt = GUIComp.setLabel("already have an account?", 170, 400, 250, 30, Font.PLAIN, 20, 245, 240, 228);
		this.add(chkForAccnt);
		
		login_btn = GUIComp.setButton("login", 410, 393, 110, 42, 25);
		this.add(login_btn);
		
		login_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				loginPressed = true;
				ChemPlanApp.cl.show(ChemPlanApp.c, "loginPage");
			}
			
		});
		
		back_btn = GUIComp.setButton("back", 580, 455, 80, 35, 20);
		this.add(back_btn);
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "welcomePage");
			}
			
		});
	}
}
