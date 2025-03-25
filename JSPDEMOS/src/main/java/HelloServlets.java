import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/") // URL mapping
public class HelloServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServlets() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Reading request and processing
        String name = request.getParameter("username");

        // Avoiding NullPointerException if "username" is not provided
        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }

        System.out.println(name);

        // Responding to the client
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
     // Object for response writer which sends the data to client
        PrintWriter out = response.getWriter();

        // Respond
        out.println("<html><head><title>Response</title></head><body>");
        out.println("<h1>Hello " + name + "!</h1>");
        out.println("<a href='index.jsp'>Go back</a>");
        out.print("</body></html>");

        out.close();
    }
}