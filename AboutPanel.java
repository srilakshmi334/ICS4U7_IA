// Import the following packages:
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The following class is for the about frame of the program
 * @author Sri
 *
 */
public class AboutPanel extends JPanel {
	
	private JLabel abHeader, crLbl;
	private String file, line, copyright;
	private JTextArea aboutApp;
	private JButton back;
	
	public AboutPanel() {
		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));
		
		abHeader = GUIComp.setLabel("your one stop lab planner", 150, 23, 400, 40, Font.BOLD, 35, 255, 255, 255);
		this.add(abHeader);
		
		file = "./aboutDBI.txt";
		
		aboutApp = new JTextArea();
		aboutApp.setBounds(50, 80, 600, 380);
		aboutApp.setFont(new Font("Ink Free", Font.BOLD, 16));
		aboutApp.setForeground(new Color(19, 52, 92));
		aboutApp.setOpaque(false); // make JTextArea transparent

		aboutApp.setEditable(false);
		aboutApp.setLineWrap(true);
		aboutApp.setWrapStyleWord(true);
		
		this.add(aboutApp);
		
		// Try reading in the about file and add each line to the JTextArea
		try {
			BufferedReader readInLine = new BufferedReader(new FileReader(file));

			while((line = readInLine.readLine()) != null) {
				aboutApp.read(readInLine, "aboutApp");
			}
		}

		// If file doesn't exist, catch exception and print an error message to the console
		catch (IOException iox) {
			System.out.println("Problem reading " + file);
		}
		
		copyright = "Copyright don't bomb it 2023. All Rights Reserved. CompSciIA2024";
		crLbl = GUIComp.setLabel(copyright, 120, 480, 430, 20, Font.PLAIN, 14, 255, 255, 255);
		this.add(crLbl);
		
		back = GUIComp.setButton("back", 580, 445, 80, 35, 20);
		this.add(back);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "welcomePage");
			}
			
		});
	}
}
