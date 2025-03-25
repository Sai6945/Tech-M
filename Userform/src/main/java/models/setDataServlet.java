import java.io.IOException;
 
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
 
@WebServlet("/setdata")
public class setDataServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse  response ) 
	throws ServletException,IOException {
		//get method
		//understand how to create servlet context
		ServletContext context = getServletContext();
		context.setAttribute("globalData", "Welcome to My platform");
		response.getWriter().println("Data stored in servletContext");
	}
 
}