package MyServelt;


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

@WebServlet(name = "ChatCon", urlPatterns = {"/ChatCon"})

public class ChatCon extends HttpServlet {

    String name, message;
    public static Vector<Message> vector = new Vector<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
         HttpSession session = request.getSession(true);
         session.getAttribute("name");
        message = request.getParameter("myMessage");

        response.setContentType("application/json");
        Message mymessage = new Message() ;
        mymessage.setName(name);
        mymessage.setMessage(message);

        vector.add(mymessage);

        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        response.getWriter().write(gson.toJson(vector));
        response.getWriter().close();
    }

}
