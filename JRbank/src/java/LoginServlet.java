/**************************************************************
   Juan Rodriguez
      Lab #7 
   I wrote this code myself...
 **************************************************************/

import Business.Customer;
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
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             //get input from loginForm 
        String id, pw;
        id = request.getParameter("id");
        pw = request.getParameter("password");
        
       // create customer object pass through selectDB method
        Customer c5;
        c5 = new Customer();
        c5.selectDB(id);
      
              // Put customer object in session
        HttpSession ses1;
        ses1 = request.getSession();
        ses1.setAttribute("c5",c5);
        System.out.println("Customer session");
        
        // if database password matches client password run the following code if not run else
        if(c5.getCustPassword().equals(pw)){
              RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccounts.jsp");
             rd.forward(request, response);  
        }else{
         RequestDispatcher rd = request.getRequestDispatcher("/ErrorPage.jsp");
             rd.forward(request, response);  
        }
        
  


       }finally{
          
        
        }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
