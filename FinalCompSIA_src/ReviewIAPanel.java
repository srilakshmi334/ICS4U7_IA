// Import the following packages:
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The following class is for the frame that allows the teacher user to review students' IAs
 * @author Sri
 *
 */
public class ReviewIAPanel extends JPanel {
	
	private JLabel studentIAH;
	private String expLine;
	private JTextArea expInfoTA;
	private JScrollPane sp;
	private BufferedReader readExp;
	private JButton backToPlanner;
	
	public ReviewIAPanel(String IAFileInfo, String studentUserName) {
		
		this.setLayout(null);
		this.setSize(700, 580);
		this.setBackground(new Color(119, 158, 186));
		
		studentIAH = GUIComp.setLabel(studentUserName + "'s " + "IA", 270, 20, 220, 45, Font.BOLD, 35, 255, 255, 255);
		this.add(studentIAH);
		
		String expStr = ""; // initialize variable to add student's IA info
		
		// Design JTextArea and JScrollPane to have student's IA info
		expInfoTA = new JTextArea(expStr);
		expInfoTA.setBounds(50, 80, 600, 380);
		expInfoTA.setFont(new Font("Ink Free", Font.PLAIN, 18));
		expInfoTA.setForeground(new Color(51, 55, 138));
		expInfoTA.setEditable(false);
		expInfoTA.setLineWrap(true);
		expInfoTA.setWrapStyleWord(true);
		
		sp = new JScrollPane(expInfoTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(50, 80, 600, 370);
		sp.setBackground(new Color(247, 246, 235));
		
		// Read in the contents of the student's experiment file to the JTextArea
		try {
			readExp = new BufferedReader(new FileReader(IAFileInfo));
			while ((expLine = readExp.readLine()) != null) {
				expStr += expLine + "\n";
			}

			readExp.close();
		}
		catch(IOException iox) {
			System.out.println("Problem reading " + IAFileInfo);
		}
		
		expInfoTA.setText(expStr); // add string with appended info to the text area
		this.add(sp);
		
		// Add back to planner button
		backToPlanner = GUIComp.setButton("back to planner", 452, 460, 200, 40, 22);
		this.add(backToPlanner);
		
		backToPlanner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "teacherPlannerPage");
			}
			
		});
	}
}
