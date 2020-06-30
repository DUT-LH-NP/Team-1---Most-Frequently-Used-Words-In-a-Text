package abc;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;

public class HistoryFrame extends JFrame {
    private Vector vtRow;
    Vector vtData = new Vector();
    private JPanel contentPane;
    private JTable table;
    Connection conn;
	
    public HistoryFrame() {
        setBounds(100, 100, 900, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setTitle("History");
		
        String[] names = {"InputData", "OutputData", "Time"};
        String[][] body = {};
        Vector vtColumn=new Vector(); 
        vtColumn.add("InputData");
        vtColumn.add("OutputData");
        vtColumn.add("Time");
        Database dtb = new Database();

        table = new JTable(body,names);
        try {
            Connect();
            String sql = "select * from Information";
            Statement statement= conn.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()) {
                vtRow = new Vector();
                vtRow.add(rs.getString(1));
                vtRow.add(rs.getString(2));
                vtRow.add(rs.getString(3));
                vtData.add(vtRow); 
                }
            table.setModel(new DefaultTableModel(vtData, vtColumn));
            }
        catch (Exception ex) {
        	System.out.println(ex);
        }
		
        table.setBounds(44, 221, 336, -142);
        table.setBackground(Color.white);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(table.getTableHeader(),BorderLayout.PAGE_START);
        contentPane.add(table,BorderLayout.CENTER);
        table.setFillsViewportHeight(true);
		
        table.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
	
    public void Connect() {
        try {
        	String dbURL = "jdbc:sqlserver://localhost;databaseName=Thesis;user=sa;password=12";
        	conn = DriverManager.getConnection(dbURL);
        } 
        catch (SQLException ex) {
        	System.err.println("Cannot connect database, " + ex);
        }
    }
}
