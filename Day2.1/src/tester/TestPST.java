package tester;
import static utils.DButils.fetchDBConnection;

import java.sql.*;
import java.util.Scanner;


public class TestPST {
public static void main(String[] args) {
	
	String sql="select id,first_name,last_name,email,dob from users where dob between ?and?";
	try(Connection cn= fetchDBConnection();
			PreparedStatement pst=cn.prepareStatement(sql);
			
			Scanner sc=new Scanner(System.in);
			){
		System.out.println("start date and end date");
		Date d1= Date.valueOf(sc.next());
		Date d2= Date.valueOf(sc.next());
		pst.setDate(1, d1);
		pst.setDate(2, d2);
		try(ResultSet rst= pst.executeQuery();){
			while(rst.next()) {
				System.out.println(rst.getInt(1)+" "+ rst.getString(2)+" "+rst.getString(3)+" "+rst.getString(4)+" "+ rst.getDate(5));
			}
		}
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}
