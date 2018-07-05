

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJDBC {

    public static final String CREATE_SCHEMA1 = "CREATE TABLE `NewTable` (\n" +
"`ID`  numeric NOT NULL ,\n" +
"`FNAME`  varchar(100) NULL ,\n" +
"`LNAME`  varchar(100) NULL \n" +
")\n" +
";";

 public static final String ADD = "INSERT INTO newtable (FNAME, LNAME) VALUES ('qwe','qwe');";
 public static final String Select = "SELECT * FROM NewTable;";
    
    
    
    

 //public static final String DELETE_SCHEMA_SQL = "DROP TABLE CUSTOMERS";

    public static void main(String[] args) throws SQLException {
       
        
        String driver = "com.mysql.jdbc.Driver";
  // Create the ConnectionPool:
  JDBCConnectionPool pool = new JDBCConnectionPool(
    driver,"jdbc:mysql://localhost:3306/test","root", "");

  // Create the ConnectionPool:
//  pool = new JDBCConnectionPool(
//    driver,"jdbc:mysql://localhost:3306/test","root", "");

  // Get a connection:
  final Connection connection = pool.checkOut();
  System.out.println(connection);
  // Use the connection
//  while(true){
  Statement statement = connection.createStatement();
  //statement.execute(ADD);
  System.out.println(statement.execute(Select));
  // Return the connection:
  pool.checkIn(connection);

        
  }    
        
        
//    }
    
}
