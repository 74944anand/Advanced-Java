package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Invoked by init"+Thread.currentThread());
	}

	@Override
	public void destroy() {
		System.out.println("Invoked by destroy"+Thread.currentThread());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Invoked by do get"+Thread.currentThread());
	resp.setContentType("text/html");
	
	try(PrintWriter pw =resp.getWriter()){
		pw.print("<h2>Hello welcome to servlet..."+LocalDateTime.now()+"</h2>");
	}
	}

	
	
}
