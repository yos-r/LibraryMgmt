
package authentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class UsersDB {
    static Connection con = null; //connection config for each class connecting with the database
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Driver class
            String url = "jdbc:mysql://localhost:3306/libmgmt"; //jdbc: API, mysql is the database, localhost: server, 3306 port
            con = DriverManager.getConnection(url,"root","manager");
            System.out.println("Connected");
            
        }catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        
        return con;
    }
    
    public static int addUser(User user){
        int st=0;
        try
        {
            String req = "INSERT INTO users VALUES(?,?,?,?,?,?)";
            //Connection con = UsersDB.getConnection();
            Connection con= initdb.obj.getConnection();
            
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1, user.getCin());
            preparedStatement.setString(2, user.getNom());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getStatut());
            preparedStatement.setString(6, user.getPassword());

            st = preparedStatement.executeUpdate();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return st;
    
    }
    
    public static String getUserFullname(String cin){
        String st=" ";
        try
        {
            String req = "SELECT nom,prenom FROM users WHERE cin=?";
            //Connection con = UsersDB.getConnection();
            Connection con= initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1, cin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                st= resultSet.getString(1)+" "+resultSet.getString(2);
            }
            
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return st;
    }
    public static int removeUser(String cin){
        int st=0;
        try
        {
            String req = "Delete from users where cin=?";
            //Connection con = UsersDB.getConnection();
            Connection con= initdb.obj.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1, cin);
       
            st = preparedStatement.executeUpdate();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return st;
    }
 
   public static int updateUser(User user) 
    {
        int st = 0;
        try
        {
            String req = "UPDATE users SET cin=?,nom=?,prenom=?,email=?,statut=?,password=? WHERE cin=?";
            //Connection con = UsersDB.getConnection();
            Connection con= initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1, user.getCin());
            preparedStatement.setString(2, user.getNom());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getStatut());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getCin());

            st = preparedStatement.executeUpdate();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return st;
    }
    public static User getUser(String c){
        User user = new User();
        try
        {
            String req = "SELECT * FROM users WHERE cin=?";
            //Connection con = UsersDB.getConnection();
            Connection con= initdb.obj.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1, c);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                user.setCin(resultSet.getString(1));
                user.setNom(resultSet.getString(2));
                user.setPrenom(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setStatut(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
            }
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
    public static List<User> getUsers() //return array list of registered users
    {
        List<User> list = new ArrayList<User>(); //the list to return
        try
        {
            String req = "select * from users;"; 
            //Connection con = UsersDB.getConnection(); //get the static attribute known as connection
            Connection con= initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            //User user = new User();
            while(resultSet.next())
                {
                
                    //user.setCin(resultSet.getString(1));  
                    //user.setNom(resultSet.getString(2));
                   // user.setPrenom(resultSet.getString(3));
                    //user.setEmail(resultSet.getString(4));
                    //user.setStatut(resultSet.getString(5));
                    //user.setPassword(resultSet.getString(6));
                    
                    list.add(new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6))); 
                }
            con.close();
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return list; //get an array list of all user instances that were created 
    }
    
}
