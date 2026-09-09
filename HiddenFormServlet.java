import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HiddenFormServlet")
public class HiddenFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username =
                request.getParameter("username");

        String hiddenUsername =
                request.getParameter("hiddenUsername");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hidden Form Field</title>");

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

        out.println("<h1>Hidden Form Field</h1>");

        if (hiddenUsername != null &&
                !hiddenUsername.trim().isEmpty()) {

            out.println("<h2>Hidden Data Retrieved</h2>");

            out.println("<p>Username:</p>");

            out.println("<h2>" + hiddenUsername + "</h2>");

            out.println("<p>The value was transferred using a hidden form field.</p>");

        } else if (username != null &&
                !username.trim().isEmpty()) {

            out.println("<h2>Hidden Field Created</h2>");

            out.println("<p>Username: <b>"
                    + username + "</b></p>");

            out.println("<form method='get' action='HiddenFormServlet'>");

            out.println("<input type='hidden' "
                    + "name='hiddenUsername' "
                    + "value='" + username + "'>");

            out.println("<p>The username is now stored inside a hidden field.</p>");

            out.println("<button type='submit'>Submit Hidden Data</button>");

            out.println("</form>");

        } else {

            out.println("<p>Enter username to create a hidden form field.</p>");

            out.println("<form method='get' action='HiddenFormServlet'>");

            out.println("<input type='text' name='username' "
                    + "placeholder='Enter username' required>");

            out.println("<br>");

            out.println("<button type='submit'>Continue</button>");

            out.println("</form>");
        }

        out.println("<br>");
        out.println("<a href='index.html'>Back to Home</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}