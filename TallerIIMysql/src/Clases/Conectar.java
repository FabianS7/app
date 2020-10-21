/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Conectar {
    
    private static Connection conn;
    
    private static final String driver="com.mysql.jdbc.Driver";
 
    private static final String user="root";
    
    private static final String password="";
    
    private static final String url="jdbc:mysql://localhost:3306/prueba";
    
    public Conectar(){
        
        conn=null;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            if(conn!=null){
                System.out.println("Conexion exitosa....");
            }
        } catch (Exception e) {
            System.out.println("error al conectar");
        }
    }
    public Connection getConnection(){
        return conn;
    }
    public void desconectar(){
        
        if(conn!=null){
            conn=null;
            System.out.println("coneccion terminada");
        }
    }
    
}
