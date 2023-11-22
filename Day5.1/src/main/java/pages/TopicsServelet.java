package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

/**
 * Servlet implementation class TopicsServelet
 */
@WebServlet("/topics")
public class TopicsServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
try(PrintWriter pw= response.getWriter()){
	
	HttpSession session=request.getSession();
	User user=(User)session.getAttribute("user_dtls");
	
	if(user!=null) {
		pw.print("<h5>User Details: "+ user+"</h5>");
	}
	else {
		pw.print("<h5>Session Expired<a href='logout'> Login Again</a></h5>");
	}
}
	}

}
