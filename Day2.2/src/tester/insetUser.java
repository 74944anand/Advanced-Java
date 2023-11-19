package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.UsersDaoImpl;
import pojos.Users;

public class insetUser {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner sc= new Scanner(System.in);){
			UsersDaoImpl usersDao= new UsersDaoImpl();
			System.out.println("Enter first_name, last_name, email, password, dob, status,role");
			String result= usersDao.insertUserDetails(
					new Users(sc.next(),sc.next(),sc.next(),sc.next(),Date.valueOf(sc.next()),sc.nextInt(),sc.next()));
			System.out.println(result);
			usersDao.cleanUp();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

