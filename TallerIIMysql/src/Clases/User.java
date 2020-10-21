
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class User {
    Conectar con;
    private boolean admin;
    public User(){
        this.admin=false;
    }
    public boolean getAdmin(){
        return admin;
    }
    public String BuscarUser(String username, String password) {
        
       Connection conn=null;
        con=new Conectar();
        String user="";
        
        try {
            conn=con.getConnection();
            PreparedStatement ps = conn.prepareStatement("select *from usertable where username = ? and password=?");
            //System.out.println(txtusername);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user=rs.getString("username");
                admin=rs.getBoolean("admin");
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        return user;
        
    }
}
