package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	Cookie[]c1=request.getCookies();
	if(c1!=null) {
		for(Cookie c:c1) {
			if(c.getName().equals("user_data")) {
				pw.print("<h5>Got user Dettails"+c.getValue() +"</h5>");
			}
		}
	}else {
		pw.print("<h5>Cookies not found</h5>");
	}
}
	}

}
