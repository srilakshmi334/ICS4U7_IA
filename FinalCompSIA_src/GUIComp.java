// Import the following packages:
import java.awt.*;
import javax.swing.*;

/**
 * The following class contains methods for all the main GUI components of the program
 * @author lakhs
 *
 */
public class GUIComp {

	/**
	 * The following method creates JLabels
	 * @param n
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param fontType
	 * @param fontSize
	 * @param r
	 * @param g
	 * @param b
	 * @return JLabel
	 */
	public static JLabel setLabel(String n, int x, int y, int w, int h, int fontType, int fontSize, int r, int g, int b) {

		// Set design of JLabels
		JLabel l = new JLabel(n);
		l.setBounds(x, y, w, h);
		l.setFont(new Font("Ink Free", fontType, fontSize));
		l.setForeground(new Color(r, g, b));

		return l; // add JLabel to the frame
	}
	
	/**
	 * The following method creates JButtons
	 * @param n
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param fontSize
	 * @param frame
	 * @return JButton
	 */
	public static JButton setButton(String n, int x, int y, int w, int h, int fontSize) {

		// Set design of JButtons
		JButton b = new JButton(n);
		b.setBounds(x, y, w, h);
		b.setFont(new Font("Ink Free", Font.BOLD, fontSize));
		b.setForeground(new Color(44, 79, 110));
		b.setBackground(new Color(186, 210, 232));
		
		return b;
	}
	
	/**
	 * The following method creates JButtons with images
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param r
	 * @param g
	 * @param bl
	 * @param ic
	 * @return JButton
	 */
	public static JButton setButton(int x, int y, int w, int h, int r, int g, int bl, ImageIcon ic) {
		
		JButton b = new JButton();
		b.setBounds(x, y, w, h);
		b.setBackground(new Color(r, g, bl));
		b.setIcon(ic);
		
		return b;
	}
	
	/**
	 * The following method creates JRadioButtons
	 * @param n
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param bg
	 * @return JRadioButton
	 */
	public static JRadioButton setRadioButton(String n, int x, int y, int w, int h, ButtonGroup bg) {
		
		JRadioButton rb = new JRadioButton(n);
		rb.setBounds(x, y, w, h);
		rb.setFont(new Font("Ink Free", Font.PLAIN, 18));
		rb.setBackground(null);
		rb.setForeground(new Color(245, 240, 228));
		
		bg.add(rb); // Add the radio buttons to the button group
		return rb;
	}
	
	/**
	 * The following method creates JTextFields for the IA page
	 * @param sp
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @return JTextField
	 */
	public static JTextField setTextField(int x, int y, int w, int h) {
		
		JTextField tf = new JTextField();
		tf.setFont(new Font("Ink Free", Font.PLAIN, 15));
		
//		sp = new JScrollPane(tf, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tf.setBounds(x, y, w, h);
		
		return tf;
	}
	
	public static JCheckBox setCheckBox(JCheckBox cb, String n, int x, int y, int w, int h) {		
		cb = new JCheckBox(n);
		cb.setBounds(x, y, w, h);
		cb.setFont(new Font("Ink Free", Font.PLAIN, 19));
		cb.setBackground(null);

//		for (int i = 0; i < s.size(); i++) {
//			s.add(i, s.get(i));
//		}
		
		return cb;
	}
}
