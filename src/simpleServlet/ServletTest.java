package simpleServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletTest", urlPatterns = {"/serveMe"})
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head></head><body>"); //Start of the HTML
        String login = request.getParameter("login"); //get the parameter that you set in the login.html file. input name was = login
        String password = request.getParameter("password"); //get value for the password from the login.html file name was = password
        out.println("<h1>Super Secret Information</h1>");
        out.println("<p>Login: " + login + "</p>"); //display the login to the user
        out.println("<p>Password" + password + "</p>"); //display the password to the user
        out.println("</body></html>"); //end of the HTML
        out.println();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //even if you are using a POST, you need to have something here
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This resource is not available directly");
    }
}
