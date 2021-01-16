
package resort.management.system;
import java.sql.*;

public class com {
    Connection c;
    Statement s;
    public com()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/resortProject?useTimezone=true&serverTimezone=UTC", "root", "sagar1404");
            s=c.createStatement();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

public static void main (String [] args)
	{
		
	}
}
