package tester;
import static utils.DButils.fetchDBConnection;
import java.sql.Connection;

public class TestDBconnection {
public static void main(String[] args) {
	
	try(Connection cn= fetchDBConnection()){
		System.out.println("Connected"+ cn);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
