/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework10;

/**
 *
 * @author Arjun
 */
import java.sql.*;

public class Homework10 {

    static final String USER = "root";
    static final String PASS = "toor";
    Statement stmt = null;
    Connection conn = null;

    private Connection conn() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yachts?useSSL=false", "root", "pass123"); //database name is yachts which contains table called movies
            //Class.forName("com.mysql.jdbc.Driver");

        } catch (SQLException se) {

            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {

    }

    public void get() throws SQLException {

        this.stmt = this.conn.createStatement();
        String sql;
        sql = "SELECT * from MOVIES";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int year = rs.getInt("Year");
            String name = rs.getString("Name");
           

            System.out.print("Name: "+ name);
            System.out.print(", Year: " + year);
        }

        rs.close();
        stmt.close();
        conn.close();

    }

    public void insert(String name, int year) throws SQLException {
        String sql = "INSERT INTO warehouses(Name,Year) VALUES(?,?)";
        conn.createStatement();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try{
            pstmt.setString(1, name);
            pstmt.setDouble(2, year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
