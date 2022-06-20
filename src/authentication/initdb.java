
package authentication;
import static authentication.init.con;
import java.sql.*;
/**
 *
 * @author yosr barghouthi / maissa dridi l2cs02 
 */
public class initdb {
    public static initdb obj = new initdb();
    public static String portnumber;
    public static String username;
    public static String password;
    public static String database;
    
    public initdb(){
        super();
    }

    public static String getPortnumber() {
        return portnumber;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setPortnumber(String portnumber) {
        initdb.portnumber = portnumber;
    }

    public static void setUsername(String username) {
        initdb.username = username;
    }

    public static void setPassword(String password) {
        initdb.password = password;
    }

    public static void setDatabase(String database) {
        initdb.database = database;
    }
    
    public initdb(String pn,String us, String pwd, String db){
        this.portnumber=pn;
        this.username=us;
        this.database=db;
        this.password=pwd;
    }
    public String toString(){
    return portnumber+"  " +username + "  " + database + "  "+ password;}
    public static Connection con=null;
    public static Connection getConnection(){
        try
        {
            System.out.println(obj);
            Class.forName("com.mysql.cj.jdbc.Driver"); //Driver class
            String url = "jdbc:mysql://localhost:"+obj.getPortnumber()+"/"+obj.getDatabase(); //jdbc: API, mysql is the database, localhost: server, 3306 port
            con = DriverManager.getConnection(url,obj.getUsername(),obj.getPassword());
            System.out.println("Connected");
            
            
            
        } catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        
        
        return con;
    }
}
