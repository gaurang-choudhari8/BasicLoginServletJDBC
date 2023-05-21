package com.basicLogin.controller;

import com.basicLogin.model.User;
import com.basicLogin.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterUser extends HttpServlet{
    UserService userService =new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        User user =new User();
        //HttpSession session=req.getSession();
        boolean attr1 = user.setName(req.getParameter("name"));
        //if(!attr1)
            //session.setAttribute("name","Name should be atleast 5 characters");
        boolean attr2 = user.setPhone(req.getParameter("phone"));
        //if(!attr2)
            //session.setAttribute("phone","Please enter valid phone number");
        boolean attr3 = user.setEmail(req.getParameter("email"));
      //  if(!attr3)
            //session.setAttribute("email","Please enter valid email address");
        boolean attr4 = user.setCity(req.getParameter("city"));
        //if(!attr4)
            //session.setAttribute("city","Enter a Valid city name");


        if(!(attr1&&attr2&&attr3&&attr4)){

            if(attr1==false)
                req.setAttribute("name_e","Name length should be greater than 5");
            if(attr2==false)
                req.setAttribute("phone_e","Enter valid phone number.");
            if(attr3==false)
                req.setAttribute("email_e","Enter valid email");
            if(attr4==false)
                req.setAttribute("city_e","Enter correct city");
            RequestDispatcher disp=req.getRequestDispatcher("/index.jsp");
            disp.forward(req,resp);
        }
        else{
            out.println("<html><body>");

            boolean result=userService.addUser(user);
            out.println("All inputs are correct. User has been added successfully");
            out.println("</body></html>");
        }
/*
        boolean result=userService.addUser(user);

        if(result){
            req.setAttribute("res","The user was added successfully");
            RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
            rd.forward(req,resp);
        }else{
            req.setAttribute("res","Some error while adding the user to the list.");
            RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
            rd.forward(req,resp);
        }*/
    }


}
