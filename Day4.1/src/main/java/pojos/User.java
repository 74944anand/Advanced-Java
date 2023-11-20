package pojos;

import java.sql.Date;

public class User {
// id | first_name | last_name | email | password   | dob| status | role
	
	private int userID;
	private String fname;
	private String lname;
	private String email;
	private String pass;
	private Date dob;
	private int status;
	private String role;
	
	
	public User(int userID, String fname, String lname, String email, String pass, Date dob, int status, String role) {
		super();
		this.userID = userID;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.dob = dob;
		this.status = status;
		this.role = role;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pass="
				+ pass + ", dob=" + dob + ", status=" + status + ", role=" + role + "]";
	}
	
	
	
	
}


