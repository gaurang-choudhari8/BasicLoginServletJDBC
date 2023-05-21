package com.basicLogin.controller;

import com.basicLogin.model.User;
import com.basicLogin.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/viewAllUsers")
public class ViewAllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        UserService userService=new UserService();
        List<User> users=userService.getAllUsers();
        out.println("<html><head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>UsersInc</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\n" +
                "</head><body>");
        out.println("<div class='container-fluid'>");
        out.println("<table>");
        out.println("<tr>" +
                "<th>Name</th>" +
                "<th>Phone</th>" +
                "<th>Email</th>" +
                "<th>City</th>" +
                "</tr>");
        for(User ind_user:users){
            out.println("<tr>");
            out.println("<td>"+ind_user.getName()+"</td>");
            out.println("<td>"+ind_user.getPhone()+"</td>");
            out.println("<td>"+ind_user.getEmail()+"</td>");
            out.println("<td>"+ind_user.getCity()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>");
        out.println("</body></html>");
        //req.setAttribute("users",users);
        //RequestDispatcher disp=req.getRequestDispatcher("viewAll.jsp");
        //disp.forward(req,resp);

    }
}
