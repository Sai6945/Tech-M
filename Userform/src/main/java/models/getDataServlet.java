import java.io.IOException;
 
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
 
@WebServlet("/getdata")
public class getDataServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse  response ) 
	throws ServletException,IOException {
		//get method
		//understand how to retrive servlet context
		ServletContext context = getServletContext();
		String message= (String) context.getAttribute("globalData");
		response.getWriter().println("Data is :"+message);		
	}
 
}
\