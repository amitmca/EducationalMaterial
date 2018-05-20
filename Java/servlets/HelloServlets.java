import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlets extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello from servlet!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello from servlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}