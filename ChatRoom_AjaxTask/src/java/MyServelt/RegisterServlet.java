
package MyServelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
        
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
        
        User user=new User(name,email,password);
        
        if(Storage.isAlreadyMember(user)){
            
             out.print("this mail used ");
                    out.print("<a href='login.html'>login</a>"); 
        }
        else 
        {
         Storage.registerationVector.add(user);
          
         response.sendRedirect("login.html");
        
        }
        
        
    }

   
}
