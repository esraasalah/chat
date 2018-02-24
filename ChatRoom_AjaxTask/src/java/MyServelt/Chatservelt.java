package MyServelt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eman
 */
import com.google.gson.Gson;
import com.sun.javafx.geom.Vec2d;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.jgss.spi.MechanismFactory;

@WebServlet(name = "Chatservelt", urlPatterns = {"/Chatservelt"})

public class Chatservelt extends HttpServlet {

    String name, message;
    public static Vector<Message> vector = new Vector<>();
     public Vector<Message>messages; 
     public Vector<User> user;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
         String key=request.getParameter("key");
        
          HttpSession session = request.getSession(false);
        
        String email = (String) session.getAttribute("email");
        String passowrd = (String) session.getAttribute("password");
        
        
         if(key==null){
        if (passowrd != null && email != null) {
            User user = new User(null, passowrd, email);
            user = Storage.getUser(user);
            String name = user.getName();
            String content = request.getParameter("message");
            Message message = new Message(name, content);
            messages.add(message);
            out.print(createJson());
        }}
        else{
            response.sendRedirect("Login?email="+email+"&password="+passowrd);
        }

        
    }
    
    private String createJson() {
        Gson gson = new Gson();
        JsonRetObj obj=new JsonRetObj();
        obj.messages=messages;
        obj.users=user;
        obj.onlineUsers= Storage.getOnlineUser();
        return gson.toJson(obj);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out = response.getWriter();

           out.print(createJson());
    }

}
