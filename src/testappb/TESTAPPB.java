
package testappb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TESTAPPB {
//Connection Method to SQLITE
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:testappb.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    public static void main(String[] args) {
          connectDB();
          Scanner sc = new Scanner (System.in);
          
         
          System.out.println("First Name: ");
          String fname = sc.next();
          System.out.println("Last Name: ");
          String lname = sc.next();
          System.out.println("Email: ");
          String email  = sc.next();
          System.out.println("Status: ");
          String stat = sc.next();
          
          String sql = "INSERT INTO  tbl_students (s_fname, s_lastname, s_email, s_status)VALUES (?, ?, ?, ?)";
          
          
          try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement(sql);        
            pst.setString(1, fname);             
            pst.setString(2, lname);             
            pst.setString(3, email);
            pst.setString(4, stat);
            pst.executeUpdate();
            
            System.out.println("Inserted Successfully");

            
          }catch (SQLException ex){
              System.out.println("Connection Error: +ex.getMessage()");
          };
    }
    
}
