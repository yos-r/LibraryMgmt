
package emprunts;

import authentication.User;
import authentication.UsersDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import livres.LivresGestion;
import livres.Livre;
import authentication.initdb;
/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class EmpruntsGestion {
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
    public static List<Emprunt> getEmprunts() //return array list of all emprunts
    {
        List<Emprunt> list = new ArrayList<Emprunt>(); //the list to return
        try
        {
            String req = "select * from emprunts;"; 
            //Connection con = EmpruntsGestion.getConnection();
            Connection con=authentication.initdb.obj.getConnection(); //get the static attribute known as connection
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            Emprunt emprunt = new Emprunt();
            while(resultSet.next())
                {
                    emprunt.setCin(resultSet.getString(1));  
                    emprunt.setIsbn(resultSet.getString(2));
                    emprunt.setDateemprunt(resultSet.getString(3));
                    emprunt.setDateretour(resultSet.getString(4));
                    emprunt.setRetour(resultSet.getInt(5));
                   
                    list.add(emprunt); 
                }
            con.close();
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return list; //get an array list of all user instances that were created 
    }
    public static int RendreLivre(String cin, String isbn,String date){
        int st=0; int sd=0;
        try {
            String req = "UPDATE livres SET dispo=1 where isbn=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareCall(req);

            preparedStatement.setString(1, isbn);
            st = preparedStatement.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String req = "UPDATE emprunts SET retour=1,dateretour=? where cin=? and isbn=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareCall(req);

            preparedStatement.setString(1, date);
            preparedStatement.setString(2, cin);
            preparedStatement.setString(3, isbn);
            
            sd = preparedStatement.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st*sd;
    }
    public static Emprunt getEmpruntCourantByCin(String cin){
        Emprunt emprunt = new Emprunt();
         try
            {
            String req = "SELECT * FROM emprunts WHERE cin=? and retour=0";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            
            preparedStatement.setString(1, cin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
            emprunt.setCin(resultSet.getString(1));
            emprunt.setIsbn(resultSet.getString(2));
            emprunt.setDateemprunt(resultSet.getString(3));
            emprunt.setDateretour(resultSet.getString(4));
            emprunt.setRetour(resultSet.getInt(5));
            }  
            con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        return emprunt;
       }
    public static List<Emprunt> getEmpruntsByCin(String cin){
        List<Emprunt> list= new ArrayList<Emprunt>();
        try {
            String req = "SELECT * FROM emprunts WHERE cin=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareCall(req);
            preparedStatement.setString(1, cin);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Emprunt(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5)));

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<Emprunt> getEmpruntsByIsbn(String isbn){
        List<Emprunt> list= new ArrayList<Emprunt>();
        try {
            String req = "SELECT * FROM emprunts WHERE isbn=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareCall(req);
            preparedStatement.setString(1, isbn);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(new Emprunt(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5)));

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int ajouterEmprunt(String cin,String isbn){
        int st=0; int sd=0; 
        try{
            String req="INSERT INTO emprunts values (?,?,current_date(),ADDDATE(dateemprunt, INTERVAL 15 DAY),0)";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1, cin);
            preparedStatement.setString(2, isbn);
            st=preparedStatement.executeUpdate();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        try{
            String req="UPDATE livres set dispo=0 where isbn=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1, isbn);
            //preparedStatement.setString(2, isbn);
            sd=preparedStatement.executeUpdate();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        return st*sd;
    }
    public static String datedeadline(){
        String result="";
        try{
            String req="Select adddate(current_date() , interval 15 day)";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result= resultSet.getString(1);
            }
           con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String datedujour(){
        String result="";
        try{
            String req="Select current_date()";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result= resultSet.getString(1);
            }
           con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    
}
