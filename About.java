package abc;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class About {

    private JFrame frame;
    public About() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setBounds(100, 100, 777, 522);
        frame.getContentPane().setLayout(null);
			
        JTextArea text = new JTextArea();
        text.setBounds(15, 20, 771, 235);
        text.setLineWrap(true);
        frame.getContentPane().add(text);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setLineWrap(true);
        text.setText("Application Programming project \nTopic : Most frequently used words in a text\n2nd semester of 2019 - 2020 academic year\nClass: 18TCLC_NHAT\nTeam 1\nLê Thị Lưu Hiếu\nLê Tấn Nhật Phong\nLink github: https://github.com/DUT-LH-NP/MMost-frequently-used-words-in-a-text-source\n");
        text.setEditable(false);
	
        JLabel labelMain = new JLabel("New label");
        labelMain.setIcon(new ImageIcon("src\\Resources\\resize.gif"));
        labelMain.setBounds(500, 250, 224, 210);
        frame.getContentPane().add(labelMain);
        frame.setTitle("About");
		
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
