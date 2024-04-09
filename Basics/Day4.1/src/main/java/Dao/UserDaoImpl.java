package Dao;

import java.sql.*;

import pojos.User;
import static utils.DButils.fetchDBConnection;
public class UserDaoImpl implements IUserDao {
private Connection cn;
private PreparedStatement pst1;


	public UserDaoImpl() throws ClassNotFoundException, SQLException {
	cn=fetchDBConnection();
	pst1=cn.prepareStatement("select * from users where email=? and password=?");
	System.out.println("User Dao Created");
}




@Override
	public User validateUser(String email, String pass) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, pass);
		try(ResultSet rst=pst1.executeQuery()){
			if(rst.next()) {
				return new User(rst.getInt(1), rst.getString(2),rst.getString(3),rst.getString(4)
						,rst.getString(5), rst.getDate(6), rst.getInt(7),rst.getString(8));
			}
		}
		return null;
	}




public void cleanUp() throws SQLException {
	
	if(pst1!=null)
		pst1.close();
}

}
