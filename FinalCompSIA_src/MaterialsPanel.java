// Import the following packages:
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The following class is for the inventory frame that appears for students' planning their IA
 * @author Sri
 *
 */
public class MaterialsPanel extends JPanel {
	
	private JPanel jp;
	private JLabel inventoryH;
	private String inventoryFile = "./inventory.txt", line;
	private ArrayList<String> tools = new ArrayList<String>();
	private ArrayList<JCheckBox> cb = new ArrayList<JCheckBox>();
	private JButton backToIABtn, saveInvBtn;
	
	public MaterialsPanel(String IAInfo) {
		
		this.setLayout(null);
		this.setBackground(new Color(119, 158, 186));
		
		inventoryH = GUIComp.setLabel("inventory", 270, 30, 240, 45, Font.BOLD, 35, 255, 255, 255);
		this.add(inventoryH);
		
		jp = new JPanel();
		jp.setBackground(new Color(119, 158, 186));
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		
		JScrollPane matList = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		matList.setBounds(20, 80, 650, 350);
		matList.setBorder(null);
		this.add(matList);
		
		String IAFileInfo = IAInfo; // change input source
		
		// Read in the lines from the text file and add it to the array list
		try {
			BufferedReader r = new BufferedReader(new FileReader(inventoryFile));
			while ((line = r.readLine()) != null) {
				tools.add(line);
			}
			
			r.close();
		}
		catch(IOException iox) {
			System.out.println("Problem reading " + inventoryFile);
		}
		
		
		// Loop through the array list and display the inventory checkboxes on the frame
		for (int i = 0; i < tools.size(); i++) {
			JCheckBox materials = new JCheckBox();
			materials = GUIComp.setCheckBox(materials, tools.get(i), 0, 0, 0, 0);
			
			jp.add(materials);
			cb.add(materials);
		}
		
		// Create save inventory button
		saveInvBtn = new JButton("save inventory");
		saveInvBtn.setBounds(40, 450, 170, 40);
		saveInvBtn.setFont(new Font("Ink Free", Font.BOLD, 20));
		saveInvBtn.setForeground(new Color(44, 79, 110));
		saveInvBtn.setBackground(new Color(225, 218, 237));
		this.add(saveInvBtn);
		
		saveInvBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					FileWriter fw = new FileWriter(IAFileInfo, true);
					fw.write("Materials: " + "\n");

					for (int j = 0; j < tools.size(); j++) {
						if (cb.get(j).isSelected()) {
							fw.write("- " + cb.get(j).getText() + "\n");
						}
					}
					
					fw.close();
				}
				catch(IOException iox) {
					System.out.println("Problem writing " + IAFileInfo);
				}

			}
			
		});
		
		
		// Create back to IA button
		backToIABtn = GUIComp.setButton("back to IA", 475, 450, 170, 40, 22);
		this.add(backToIABtn);
		
		backToIABtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ChemPlanApp.cl.show(ChemPlanApp.c, "IAPage");
			}
			
		});
		
	}
}
