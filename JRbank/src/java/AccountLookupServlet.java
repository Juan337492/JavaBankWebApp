/**************************************************************
   Juan Rodriguez
      Lab #5 - Sep 27, 2021
   I wrote this code myself...
 **************************************************************/


import Business.Account;
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
/**
 *
 * @author juan3
 */
@WebServlet(urlPatterns = {"/AccountLookupServlet"})
public class AccountLookupServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
        try {
             //get input from accountLookup form 
        String Cid,AccountNo,AcctType,Balance;
        Cid = request.getParameter("CustomerId");
        AccountNo = request.getParameter("AccountNo");
        AcctType = request.getParameter("AcctType");
        Balance = request.getParameter("Balance");
        
       // create account object pass through selectDB method
   
        Account a1 = new Account();
        a1.selectDB(AccountNo);
        a1.display();
      
        // Put account object in session
        HttpSession ses1;
        ses1 = request.getSession();
        ses1.setAttribute("a1",a1);
        System.out.println("Account session");
        
         // if database password matches client password run the following code if not run else
        if(a1.getAcctNo().equals(AccountNo)){
              RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccount.jsp");
             rd.forward(request, response);  
        }else{
         
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
