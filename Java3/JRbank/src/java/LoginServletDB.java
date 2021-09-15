/**
 * Juan Rodriguez
 * Java 3 lab 2
 * this is my code
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Juan
 */
@WebServlet(urlPatterns = {"/LoginServletDB"})
public class LoginServletDB extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
        
        try {
             //get input from Form 
        String id, pw;
        id = request.getParameter("id");
        pw = request.getParameter("password");
        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/Java project/Java3/JRbank/ChattBankMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              PreparedStatement ps=con.prepareStatement("Select CustID,CustPassword from Customers where CustID=? and CustPassword=?");
           ps.setString(1,id);
           ps.setString(2,pw);
         
           ResultSet rs=ps.executeQuery();
           boolean status = rs.next();
           con.close();
          // return html page
          if(status) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Valid Login</h1>");
            out.println("</body>");
            out.println("</html>");
           }else {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Invalid</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Invalid Login</h1>");
            out.println("</body>");
            out.println("</html>");

           }
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
        
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }

   