/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class LivresGestion {
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
    public static int modifierLivre(String isbn,String auteur,String titre){
        int st=0;
        try
        {
            String req = "UPDATE livres SET auteur=?,titre=? where isbn=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1,auteur);
            preparedStatement.setString(2, titre);
            preparedStatement.setString(3, isbn);

            st = preparedStatement.executeUpdate();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return st;
    }
    public static int ajouterLivre(Livre livre){
        int st=0;
        try
        {
            String req = "INSERT INTO livres(isbn, titre, auteur, dispo)VALUES(?,?,?,?)";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            preparedStatement.setString(1,livre.getIsbn());
            preparedStatement.setString(2, livre.getTitre());
            preparedStatement.setString(3, livre.getAuteur());
            preparedStatement.setInt(4, livre.getDispo());

            st = preparedStatement.executeUpdate();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return st;
    }
    public static int supprimerLivre(String isbn){
        int st=0;
        try {
            String req = "DELETE FROM livres WHERE isbn=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareCall(req);

            preparedStatement.setString(1, isbn);

            st = preparedStatement.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
    public static List<Livre> getLivres() //return array list of all emprunts
    {
        List<Livre> list = new ArrayList<Livre>(); //the list to return
        try {
            String req = "select * from livres;";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                list.add(new Livre(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list; //get an array list of all user instances that were created 
    }
    public static Livre getLivreByISBN(String isbn)
    {
        Livre livre = new Livre();
        try
        {
            String req = "SELECT * FROM livres WHERE isbn=?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            
            preparedStatement.setString(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                livre.setIsbn(resultSet.getString(1));
                livre.setTitre(resultSet.getString(2));
                livre.setAuteur(resultSet.getString(3));
                livre.setDispo(resultSet.getInt(4));

                }
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return livre;
        
    }
    public static Livre getLivreByTitre(String titre)
    {
        Livre livre = new Livre();
        try
        {
            String req = "SELECT * FROM livres WHERE titre like ?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            
            preparedStatement.setString(1, titre);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                livre.setIsbn(resultSet.getString(1));
                livre.setTitre(resultSet.getString(2));
                livre.setAuteur(resultSet.getString(3));
                livre.setDispo(resultSet.getInt(4));

       }
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return livre;
        
    }
    public static List<Livre> getLivreByAuteur(String auteur)
    {
        List<Livre> liste = new ArrayList<Livre>();
        try
        {
            String req = "SELECT * FROM livres where auteur = ?";
            Connection con=authentication.initdb.obj.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareCall(req);
            
            preparedStatement.setString(1, auteur);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                liste.add(new Livre(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));

            }
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return liste;
        
    }
}
