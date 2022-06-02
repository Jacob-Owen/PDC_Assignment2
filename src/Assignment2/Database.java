/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcobm
 */
public class Database
{
    private static final String USER_NAME = "Jacob"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
    private static final String URL = "jdbc:derby://localhost:1527/PDC_Assignment2;create=true";  //url of the DB host
    private Statement statement;

    Connection conn;

    public Database() {
        establishConnection();
    }

    public static void main(String[] args) {
        Database database = new Database();
        System.out.println(database.getConnection());
    }

    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        //Establish a connection to Database
        if(conn == null)
        {
            try
            {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL+" Connected");
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void checkTables(String tableName)
    {
        try {
            this.statement = conn.createStatement();
            //if()
            this.statement.addBatch("CREATE  TABLE PLAYER (NAME VARCHAR(50), HP  INT, MP INT, ATTACK INT, DEFENCE INT, EXP INT, LEVEL INT, MAXHP INT, MAXMP INT, SCORE INT)");
            this.statement.addBatch("CREATE  TABLE ENEMY (NAME VARCHAR(50), HP  INT, MP INT, ATTACK INT, DEFENCE INT, EXPGAIN INT)");
           
            //this.statement.addBatch("INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90)");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getStats(String stat, String table, String name) 
    {
        int val = 0;
        ResultSet rs = null;
        try 
        {
            rs = this.statement.executeQuery("SELECT *"
                    + "FROM "+table
                    + "WHERE NAME = '"+name+"'");
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        try
        {
            val =  ((Number) rs.getObject(1)).intValue();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return val;

    }
}
