package MyServelt;
import MyServelt.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;


public class Storage {
    public static Vector <User>registerationVector=new Vector<>();
    public static Vector <User>onlineUsers=new Vector<>();
    
    
    
   
         public static boolean isAlreadyMember(User user){
          boolean flag=false;
        for (User itruser : registerationVector) {
            if(itruser.getEmail().equals(user.getEmail())){
                flag=true;
            }
        }
        return flag;
    }
         
         
    public static boolean isUser(User user){
    boolean flag=false;
        for (User itrUser : registerationVector) {
            if(itrUser.getPassword().equals(user.getPassword())&&itrUser.getEmail().equals(itrUser.getEmail())){
                flag=true;
            }
        }
        return flag;
    }

    
     public static User getUser(User user){
         User returnUser=null;
        for (User itrUser : registerationVector) {
            if(itrUser.getPassword().equals(user.getPassword())&&itrUser.getEmail().equals(user.getEmail())){
               returnUser=itrUser;
            }
        }
        return returnUser;
    }
     
    public static Vector<User> getOnlineUser(){
        return onlineUsers;
   }
      public static void logOut(User user){
       Iterator<User> it = onlineUsers.iterator();
        while (it.hasNext()) {
            User itUser=(User)it.next();
            if(user.getPassword().equals(itUser.getPassword())&&user.getEmail().equals(itUser.getEmail())){
            
                it.remove();
            }
            
        }
    }
}


