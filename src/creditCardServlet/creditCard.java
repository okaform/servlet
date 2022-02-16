package creditCardServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "creditCard", urlPatterns = {"/submitCredit"}) //This url patterns is for the form. It takes the form from form action
public class creditCard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter(); //This basically builds the page
        response.setContentType("text/html");
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <meta name=\"description\" content=\"A Work in Progress for Servlet\">\n" +
                "  <link rel=\"stylesheet\" href=\"css/correct.css\">\n" +
                "  <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "  <link href=\"https://fonts.googleapis.com/css2?family=Comic+Neue:wght@300&family=Ubuntu&display=swap\" rel=\"stylesheet\">\n" +
                "  <title>Welcome to Marvel's Servlet Page. </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"stickyContainer\">\n" +
                "\n" +
                "<h2>Thank you for visiting</h2>\n" +
                "\n" +
                "</div>\n" +
                "<picture>\n" +
                "  <img src=\"images/star-wars-galaxy-crop.jpg\" alt=\"banner image\" />\n" +
                "</picture>\n" +
                "<main>"); //Start of the HTML

        //Processing in here
        out.println("<h1>Thanks!</h1>");

        //get the user's full name
        String fullName = request.getParameter("fullname");
        //get the user's credit card information
        String cardNo = request.getParameter("cardNo");
        //do some nice formatting for the credit card number
        String newCardNo="";
        for (int i =0; i < cardNo.length(); i++) {
            if (i == 3 || i == 7 || i == 11 || i == 15) {
                newCardNo+= cardNo.charAt(i)+ " ";
            }
            else {
                newCardNo += cardNo.charAt(i);
            }

        }


        //empty string for exception handling
        String pMonth ="";
        String pYear ="";

        //get the card's exp month info
        String month = request.getParameter("month");
        int counter = 0; //have a counter for not printing the same value twice in the catch block
        //Exception handling if the user did not select a valid month
        try {
            Integer.parseInt(month);
        }
        catch (NumberFormatException nfe) {
            pMonth = "<p>You did not enter a month for your credit card. Please <a href=\"javascript:history.go(-1)\" >click here</a> to go back.</p>";
            counter++;
        }


        //get the card's exp year info
        String year = request.getParameter("year");

        //Exception handling if the user did not select a valid year
        try {
            Integer.parseInt(year);
        }
        catch (NumberFormatException nfe) {
            pYear = "<p>You did not enter a year for your credit card. Please <a href=\"javascript:history.go(-1)\" >click here</a> to go back.</p>";
            counter++;
        }

        if (counter ==2) {
            out.println("<p>You did not enter a month and year for your credit card. Please <a href=\"javascript:history.go(-1)\" >click here</a> to go back.</p>");
        }
        else if (counter ==1 && month.isEmpty()) {
            out.println(pMonth);
        }
        else if (counter ==1 && year.isEmpty()) {
             out.println(pYear);
        }

        if (month.isEmpty() || year.isEmpty()) {//This makes sure that the exception call print empty values
            out.println();
        }
        else {
            out.println("<div class=\"cardPrinted\">" +
                    "<h3> This is your information:</h3>" +
                    "<p>Full name: " + fullName + "</p>" +
                    "<p>Card Number: " + newCardNo + "</p>" +
                    "<p>Month of Expiration: " + month + "</p>" +
                    "<p>Year of Expiration: " + year + "</p>" +
                    "<p>Please <a href=\"index.jsp\" >click here</a> to Try Another Credit Card</p>" +
                    "</div>");

        }


        out.println("</main>\n" +
                "\n" +
                "\n" +
                "<footer>\n" +
                "      <p>&copy; Simple Servlet - Marvellous Okafor\n" +
                "        <span>CIT 360 BYU - I</span>\n" +
                "</footer>\n" +
                "</body>\n" +
                "</html>"); //end of the HTML
        out.println();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //even if you are using a POST, you need to have something here
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); //This basically builds the page
        out.println("This resource is not available directly");
    }
}
