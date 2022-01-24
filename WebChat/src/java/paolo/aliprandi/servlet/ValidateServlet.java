/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paolo.aliprandi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paoloaliprandi
 */
public class ValidateServlet extends HttpServlet {

    String dbURL = "jdbc:derby://localhost:1527/WebChatDB"; 
    String dbUser = "WEBENGINE";
    String dbPassword = "WEBENGINE";
    Connection conn = null;
    
     @Override
    public void init() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
     @Override
    public void destroy() {
        try {
            conn.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        } 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        
        System.out.println(username+" prova ad autenticarsi");
        
        if (validate(username, password)) {
            
            request.getSession().setAttribute("username",username);
            RequestDispatcher rd =request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("alert","Credenziali non valide, Riprova");
            RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
    
    boolean validate(String usr, String psw) {
        boolean condition=false;
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            
            String query= "SELECT * FROM WEBENGINE.Utente WHERE USERNAME='"+usr+"'";
            
            System.out.println("--------ValidateServlet--------");
            System.out.println(query);
            
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            if (res.next()) {
                condition = (usr.equals(res.getString("USERNAME")) && (psw.equals(res.getString("PASSWORD"))));
                System.out.println("Autenticazione: "+condition);
            }
                    
        } catch (ClassNotFoundException | SQLException x) {
            x.printStackTrace();
        }
        
        return condition;
    }

}
