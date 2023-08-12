import java.sql.*;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws SQLException {
    deleteDemo();
    selectDemo();
    updateDemo();


    }

    public  static void  deleteDemo() throws SQLException {
        Connection connection = null;
        PreparedStatement statement=null;
        ResultSet resultSet;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbHelper dbHelper= new dbHelper();
            connection=dbHelper.getConnection();
            statement=connection.prepareStatement("update CITIES SET CITYNAME='ankara' where ID=10000");
            System.out.println("kayıt güncellendi");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            Objects.requireNonNull(connection).close();
        }
    }
    public  static  void  updateDemo() throws SQLException {
        Connection connection = null;
        PreparedStatement statement=null;
        ResultSet resultSet;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbHelper dbHelper= new dbHelper();
            connection=dbHelper.getConnection();




            statement=connection.prepareStatement("insert into CITIES (ID,CITYNAME,POPULATION,POPULATIONPERCENT,RANDOMBEG,RANDOMEND,REGION) values(10000,'corum',4,5.2,5.2,4.3,'middle')");
            int result= statement.executeUpdate();
            System.out.println(result);
            System.out.println("kayıt eklendi");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            connection.close();
        }

    }
    public static void   selectDemo() throws SQLException {
        Connection connection = null;
        Statement statement=null;
        ResultSet resultSet;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbHelper dbHelper= new dbHelper();
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select*from CITIES ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("CITYNAME"));
            }
            System.out.println("bağlantı oluştu");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            Objects.requireNonNull(connection).close();
        }

    }
}