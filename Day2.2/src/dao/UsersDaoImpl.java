package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DButils.fetchDBConnection;
import pojos.Users;

public class UsersDaoImpl implements IUsersDao {
private Connection cn;
private PreparedStatement pst1,pst2;
	
public UsersDaoImpl() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated constructor stub
cn=fetchDBConnection();
String sql="select id,first_name,last_name,email,dob from users where dob between ?and?";
String sql1="insert into users (first_name,last_name, email, password, dob,status, role) values (?,?,?,?,?,?,?)";
pst1= cn.prepareStatement(sql);
pst2= cn.prepareStatement(sql1);
}
@Override
	public List<Users> getSelectetUsers(String start, String end) throws SQLException {
	List<Users> list= new ArrayList();
	pst1.setDate(1, Date.valueOf(start));
	pst1.setDate(2,Date.valueOf(end));
	
	try(ResultSet rst= pst1.executeQuery()){
		while(rst.next()) {
	list.add(new Users(rst.getInt(1), rst.getString(2), rst.getString(3),rst.getString(4), rst.getDate(5)));
		}
	}
		return list;
	}


@Override
	public String insertUserDetails(Users user) throws SQLException {
		// TODO Auto-generated method stub
	System.out.println(user.toString());
	
	pst2.setString(1, user.getFirst_name());
	pst2.setString(2, user.getLast_name());
	pst2.setString(3, user.getEmail());
	pst2.setString(4, user.getPassword());
	pst2.setDate(5,user.getDob());
	pst2.setInt(6, user.getStatus());
	pst2.setString(7, user.getRole());

	int count= pst2.executeUpdate();
	
	if(count==1)
		return "Added User";
	return "user add failed";
	}

public void cleanUp() throws SQLException {
	if(pst1!=null) {
		pst1.close();
	}
	if(pst2!=null) {
		pst2.close();
	}
	if(cn!=null) {
		cn.close();
	}
}
}
