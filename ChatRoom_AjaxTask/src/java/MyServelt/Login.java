/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServelt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WIN 7
 */
public class Login extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        User user=new User(null, password, name);
        
        if(Storage.isUser(user)){
            user=Storage.getUser(user);
         Storage.onlineUsers.add(user);
        HttpSession session=request.getSession(true);
        session.setAttribute("email",name);
        session.setAttribute("password", password);
        response.sendRedirect("index.html");
        }
        else{
           out.print("Wrong userName or Password");
           response.sendRedirect("login.html");
        }
    }
    
  @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
 
       HttpSession session = request.getSession(false);

         String email=request.getParameter("email");
        String password=request.getParameter("password");
     
        User user=new User(null, password, email);
        Storage.logOut(user);
        response.sendRedirect("login.html");
    }
 
 
 
 
 
 
 
 
 
 }  
    
    
    




