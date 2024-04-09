package tester;

import java.util.List;
import java.util.Scanner;

import dao.IUsersDao;
import dao.UsersDaoImpl;
import pojos.Users;

public class getUserTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner sc= new Scanner(System.in);){
			UsersDaoImpl usersDao= new UsersDaoImpl();
			System.out.println("Enter Start Date and End Date (yyyy-mm-dd)");
			List<Users> userList= usersDao.getSelectetUsers(sc.next(), sc.next());
			System.out.println("User List");
			userList.forEach(System.out::println);
			usersDao.cleanUp();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
