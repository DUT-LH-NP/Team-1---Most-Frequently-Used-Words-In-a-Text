package abc;


import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.filechooser.FileSystemView;


public class MenuBar extends JFrame implements ActionListener {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JFrame mainFrame;
		private JButton New, Save, Exit, btnHelp;
		private String filePath = "";
		private JLabel labelInput;
		private JLabel labelOutput;
		private JButton btnBrowse,btnStart,btnAbout,btnHistory,btnPreview,btnEdit;
		private JButton btnMode;
		private JTextArea textAreaInput;
		private JTextArea textAreaOutput;
		private int save = 0;
		private static String mode = "getLink";
		static BufferedReader reader = null;
		public static String path,inputdata = "";
	    public static void outputPath(String filePath) {
	    	path = filePath;
	    }
		public MenuBar() {
			prepareGUI();
		}
		public static void main(String[] args){
				new MenuBar();    
		      
		}

		private void prepareGUI(){
		      mainFrame = new JFrame("Most frequently used words in a text");
		      mainFrame.setSize(800,632);
		      
		      final JMenuBar menuBar = new JMenuBar();
		      JMenu fileMenu = new JMenu("File");
		      
		      New = new JButton("New");
		      New.setFocusPainted(false);
		      New.setBackground(Color.WHITE);
		      New.setForeground(Color.black);
		      
		      Save = new JButton("Save");
		      Save.setBackground(Color.WHITE);
		      Save.setForeground(Color.BLACK);
		      Save.setFocusPainted(false);
		      
		      Exit = new JButton("Exit");
		      Exit.setBackground(Color.white);
		      Exit.setForeground(Color.BLACK);
		      Exit.setFocusPainted(false);

		      menuBar.add(New);	
		      menuBar.add(Save);
		      menuBar.add(Exit);

		     // menuBar.add(testButton);
		      
		      fileMenu.setMnemonic(KeyEvent.VK_F);
		      	      	      
		      mainFrame.setJMenuBar(menuBar);
		      mainFrame.setLocationRelativeTo(null);
		      mainFrame.getContentPane().setLayout(null);
		      
		      btnAbout = new JButton("ABOUT");

		      btnAbout.setFont(new Font("Arial", Font.PLAIN, 11));
		      btnAbout.setBounds(655, 27, 88, 26);
		      mainFrame.getContentPane().add(btnAbout);
		      
		      btnHistory = new JButton("HISTORY");
		      btnHistory.setFont(new Font("Arial", Font.PLAIN, 11));
		      btnHistory.setBounds(655, 62, 88, 26);
		      mainFrame.getContentPane().add(btnHistory);
		      
		      btnHelp = new JButton("HELP");
		      btnHelp.setFont(new Font("Arial", Font.PLAIN, 11));
		      btnHelp.setBounds(655, 99, 88, 26);
		      mainFrame.getContentPane().add(btnHelp);
		      
		      JLabel mainLabel = new JLabel("MOST FREQUENTLY USED WORDS IN A TEXT");
		      mainLabel.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 25));
		      mainLabel.setBounds(128, 182, 549, 16);
		      mainFrame.getContentPane().add(mainLabel);
		      
		      JLabel labelWordsIcon = new JLabel("New label");
		      labelWordsIcon.setIcon(new ImageIcon("src\\Resources\\word_final - Copy.jpg"));
		      labelWordsIcon.setBounds(218, 13, 330, 150);
		      mainFrame.getContentPane().add(labelWordsIcon);
		      
		      labelInput = new JLabel("INPUT");
		      labelInput.setFont(new Font("Arial Black", Font.PLAIN, 18));
		      labelInput.setBounds(154, 229, 75, 16);
		      mainFrame.getContentPane().add(labelInput);
		      
		      labelOutput = new JLabel("OUTPUT");
		      labelOutput.setFont(new Font("Arial Black", Font.PLAIN, 18));
		      labelOutput.setBounds(553, 229, 97, 16);
		      mainFrame.getContentPane().add(labelOutput);
		      
		      textAreaInput = new JTextArea();
		      textAreaInput.setBounds(48, 258, 286, 244);
		      mainFrame.getContentPane().add(textAreaInput);
		      textAreaInput.setWrapStyleWord(true);
		      textAreaInput.setLineWrap(true);
		      textAreaInput.setBorder(BorderFactory.createLineBorder(Color.black));
		      
		      btnBrowse = new JButton("BROWSE",new ImageIcon("src/Resources/Magnifying glass.png"));
		      btnBrowse.setBounds(348, 339, 97, 30);
		      btnBrowse.setBorder(BorderFactory.createEmptyBorder(2, 5, 0, 0));
		      btnBrowse.setHorizontalAlignment(SwingConstants.LEFT);
		      mainFrame.getContentPane().add(btnBrowse);
		      
		      btnStart = new JButton("START",new ImageIcon("src/Resources/StartFinal.png"));
		      btnStart.setBounds(348, 399, 97, 30);
		      btnStart.setHorizontalAlignment(SwingConstants.LEFT);
		      btnStart.setBorder(BorderFactory.createEmptyBorder(2, 5, 0, 0));
		      mainFrame.getContentPane().add(btnStart);
		      
		      JLabel label_ITIcon = new JLabel("");
		      label_ITIcon.setIcon(new ImageIcon("src\\Resources\\IT.jpg"));
		      label_ITIcon.setBounds(50, 28, 81, 91);
		      mainFrame.getContentPane().add(label_ITIcon);
		      
		      btnPreview = new JButton("PREVIEW");
		      btnPreview.setFont(new Font("Arial",Font.PLAIN,12));
		      btnPreview.setBounds(556, 515, 90, 26);
		      mainFrame.getContentPane().add(btnPreview);
		      
		      btnMode = new JButton("MODE");
		      btnMode.setFont(new Font("Arial",Font.PLAIN,12));
		      btnMode.setBounds(349, 515, 90, 26);
		      mainFrame.getContentPane().add(btnMode);
		      
		      btnEdit = new JButton("EDIT");
		      btnEdit.setFont(new Font("Arial", Font.PLAIN, 12));
		      btnEdit.setBounds(140, 515, 90, 26);
		      mainFrame.getContentPane().add(btnEdit);
		      
		      textAreaOutput = new JTextArea();
		      textAreaOutput.setWrapStyleWord(true);
		      textAreaOutput.setLineWrap(true);
		      textAreaOutput.setBounds(457, 258, 286, 244);
		      textAreaOutput.setBorder(BorderFactory.createLineBorder(Color.black));
		      mainFrame.getContentPane().add(textAreaOutput);
		     		      
		      btnAbout.addActionListener(this);
		      btnPreview.addActionListener(this);
		      btnHistory.addActionListener(this);
		      btnBrowse.addActionListener(this);
		      btnHelp.addActionListener(this);
		      btnStart.addActionListener(this);
		      btnEdit.addActionListener(this);
		      btnMode.addActionListener(this);
		      New.addActionListener(this);
		      Exit.addActionListener(this);
		      Save.addActionListener(this);
		      mainFrame.setResizable(false);
		      mainFrame.setVisible(true);  
		}
		
}