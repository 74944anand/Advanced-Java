package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Users;

public interface IUsersDao {

List<Users> getSelectetUsers(String start, String end) throws SQLException;


String insertUserDetails(Users user) throws SQLException;
}
