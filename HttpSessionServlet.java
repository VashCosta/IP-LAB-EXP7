import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HttpSessionServlet")
public class HttpSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username =
                request.getParameter("username");

        String logout =
                request.getParameter("logout");

        HttpSession session =
                request.getSession(false);

        if ("true".equals(logout)) {

            if (session != null) {

                session.invalidate();
            }

            session = null;
        }

        if (username != null &&
                !username.trim().isEmpty()) {

            session = request.getSession();

            session.setAttribute(
                    "username",
                    username);
        }

        String storedUsername = null;

        if (session != null) {

            storedUsername =
                    (String) session.getAttribute("username");
        }

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HttpSession</title>");

        out.println("<style>");

        out.println("body{");
        out.println("margin:0;");
        out.println("min-height:100vh;");
        out.println("font-family:Arial;");
        out.println("background:#eef2f7;");
        out.println("display:flex;");
        out.println("justify-content:center;");
        out.println("align-items:center;");
        out.println("}");

        out.println(".box{");
        out.println("width:520px;");
        out.println("background:white;");
        out.println("padding:40px;");
        out.println("border-radius:14px;");
        out.println("box-shadow:0 8px 25px rgba(0,0,0,0.15);");
        out.println("text-align:center;");
        out.println("}");

        out.println("input{");
        out.println("padding:11px;");
        out.println("width:250px;");
        out.println("}");

        out.println("button{");
        out.println("padding:11px 22px;");
        out.println("margin-top:15px;");
        out.println("cursor:pointer;");
        out.println("}");

        out.println("a{");
        out.println("display:inline-block;");
        out.println("margin-top:20px;");
        out.println("text-decoration:none;");
        out.println("}");

        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='box'>");

        out.println("<h1>HttpSession</h1>");

        if (storedUsername == null) {

            out.println("<p>Create a server-side session.</p>");

            out.println("<form method='get' "
                    + "action='HttpSessionServlet'>");

            out.println("<input type='text' "
                    + "name='username' "
                    + "placeholder='Enter username' required>");

            out.println("<br>");

            out.println("<button type='submit'>Create Session</button>");

            out.println("</form>");

        } else {

            out.println("<h2>Session Active</h2>");

            out.println("<p>Stored Username:</p>");

            out.println("<h2>" + storedUsername + "</h2>");

            out.println("<p>Username retrieved successfully from HttpSession.</p>");

            out.println("<br>");

            out.println("<a href='HttpSessionServlet?logout=true'>"
                    + "Invalidate Session</a>");
        }

        out.println("<br>");
        out.println("<a href='index.html'>Back to Home</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}