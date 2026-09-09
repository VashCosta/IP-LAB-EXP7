import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/URLRewritingServlet")
public class URLRewritingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username =
                request.getParameter("user");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>URL Rewriting</title>");

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

        out.println("<h1>URL Rewriting</h1>");

        if (username == null ||
                username.trim().isEmpty()) {

            out.println("<p>Enter username to attach it to the URL.</p>");

            out.println("<form method='get' action='URLRewritingServlet'>");

            out.println("<input type='text' name='user' "
                    + "placeholder='Enter username' required>");

            out.println("<br>");

            out.println("<button type='submit'>Continue</button>");

            out.println("</form>");

        } else {

            out.println("<h2>URL Rewriting Successful</h2>");

            out.println("<p>Username: <b>"
                    + username + "</b></p>");

            String encodedURL =
                    response.encodeURL(
                            "URLRewritingServlet?user="
                            + URLEncoder.encode(username, "UTF-8"));

            out.println("<p>The username is being carried through the URL.</p>");

            out.println("<p><b>Current URL:</b></p>");

            out.println("<p>" + request.getRequestURL()
                    + "?user=" + username + "</p>");

            out.println("<br>");

            out.println("<a href='" + encodedURL
                    + "'>Continue With Rewritten URL</a>");
        }

        out.println("<br>");
        out.println("<a href='index.html'>Back to Home</a>");

        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}