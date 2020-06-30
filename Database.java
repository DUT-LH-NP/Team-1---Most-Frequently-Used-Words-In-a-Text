package abc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Database {
    Connection conn;

    public void Insert(String s, String x) {
        PreparedStatement stmt = null;
        try {
            Connect();
            String showCalendar = calendar();
            String sql = "INSERT INTO Information(InputData,OutputData,InputTime) VALUES(?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, s);
            stmt.setString(2, x);
            stmt.setString(3, showCalendar);
            stmt.executeUpdate();
        } 
        catch (SQLException ex) {
            System.err.println("Cannot insert database, " + ex);
        }
    }

    public void Connect() {
       try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=Thesis;user=sa;password=12";
            conn = DriverManager.getConnection(dbURL);
       } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
       }
    }

    public void Show() throws SQLException {
        Connect();
        Statement sm = conn.createStatement();
        ResultSet rs = sm.executeQuery("Select * from Information");
        // Lay thong tin
        ResultSetMetaData rsm = rs.getMetaData();
        int cn = rsm.getColumnCount();
        while (rs.next()) {
           for (int i = 1; i <= cn; i++)
               System.out.print(rs.getString(i) + "\t");
           System.out.println("");
        }
    }

    public String calendar() {
        Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        String showCalendar = " " + year + "-" + (month + 1) + "-" + day + " " + hour + ":" + minute + ":" + second;
        return showCalendar;
    }
}