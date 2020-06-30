package abc;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;

public class HelpFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public HelpFrame() {
		setBounds(100, 100, 478, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("HelpFrame");
		
		JTextArea txtMain = new JTextArea();
		txtMain.setFont(new Font("Sitka Heading", Font.ITALIC, 16));
		txtMain.setText( "Click 'Browse' button to start choosing .txt file that you want to perform"
				+ "\nThen click 'Start' to execute the file chosen"
				+ "\nYou can completely the input text (or output result) by clicking 'Edit'/ 'Preview'"
				+ "\nDon't forget to save your current result to database"
				+ "\nClick 'New' button before creating a new one"
				+ "\nNotice: Switch executing method by clicking 'Mode' button"
				+ "\n\nCheck out the 'About' button for more details");
		
		txtMain.setWrapStyleWord(true);
	    txtMain.setLineWrap(true);
		txtMain.setBounds(0, 55, 452, 255);
		txtMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));
		txtMain.setEditable(false);
		contentPane.add(txtMain);
		
		JLabel mainLabel = new JLabel("_________Most Frequently Words Used In A Text__________");
		mainLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
		mainLabel.setBounds(10, 11, 442, 33);
		contentPane.add(mainLabel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
