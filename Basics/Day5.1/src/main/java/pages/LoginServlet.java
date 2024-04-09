package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDaoImpl;
import pojos.User;
import utils.DButils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/validate",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl userDao;
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			userDao=new UserDaoImpl();
		} catch (Exception e) {
		throw new ServletException("Error in init"+getClass().getName(), e);
		} 
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			DButils.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in destroy"+getClass().getName()+" "+e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter pw= response.getWriter()){
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			
		User user=	userDao.validateUser(email, password);
		if(user==null) {
			pw.print("<h5>Invalid Login, Please Retry <a href='login.html'>Retry</a></h5>");
		}else {
			pw.print("<h5>Login Sucessfull</h5>");
			pw.print("<h5>Login Sucessfull"+user+"</h5>");
			HttpSession session= request.getSession();
			session.setAttribute("user_dtls",user);
			response.sendRedirect("topics");
		}
		}catch (Exception e) {
			throw new ServletException("Error in do post"+ getClass().getName(), e);
		}
	}

}
