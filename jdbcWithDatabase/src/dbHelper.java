import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbHelper {
    private final String userName="sa";
    private final String password="1";
    private final String url="jdbc:sqlserver://DESKTOP-46LTO4H\\SQLEXPRESS;DatabaseName=ETRADE2;encrypt=true;trustServerCertificate=true;";
  public Connection getConnection(){
      try {
          return DriverManager.getConnection(url,userName,password);
      } catch (SQLException e) {
          System.out.println(e.getMessage());
      }

      return null;
  }

}
