package utils;
import java.sql.*;
public class DButils {
private static Connection connection;

public static Connection fetchDBConnection() throws ClassNotFoundException,SQLException {
	if(connection==null) {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/adjava?useSSL=false&allowPublicKeyRetireval=true";
	connection= DriverManager.getConnection(url, "root", "anandr@7020");
	}
	return connection;
}

}
