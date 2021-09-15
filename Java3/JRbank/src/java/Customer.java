
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
Juan Rodriguez
9/13/2021
Java 3 - Lab 3
This is my code
 */

public class Customer {
    
    private String CustFirstName, CustLastName, CustAddress, CustEmail,CustID, CustPassword;
  
    
    public Customer(){
        CustFirstName = "";
        CustLastName = "";
        CustAddress = "";
        CustEmail = "";
        CustID = "";
        CustPassword = "";
    }

    public Customer(String CustFirstName, String CustLastName, String CustAddress, String CustEmail, String CustID, String CustPassword) {
        this.CustFirstName = CustFirstName;
        this.CustLastName = CustLastName;
        this.CustAddress = CustAddress;
        this.CustEmail = CustEmail;
        this.CustID = CustID;
        this.CustPassword = CustPassword;
    }

    public String getCustFirstName() {
        return CustFirstName;
    }

    public void setCustFirstName(String CustFirstName) {
        this.CustFirstName = CustFirstName;
    }

    public String getCustLastName() {
        return CustLastName;
    }

    public void setCustLastName(String CustLastName) {
        this.CustLastName = CustLastName;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String CustAddress) {
        this.CustAddress = CustAddress;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String CustEmail) {
        this.CustEmail = CustEmail;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }

    public String getCustPassword() {
        return CustPassword;
    }

    public void setCustPassword(String CustPassword) {
        this.CustPassword = CustPassword;
    }
    
    
    public void selectDB(String CustID){
   
    try {
         String id;
         id = CustID;

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/Java project/Java3/JRbank/ChattBankMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              PreparedStatement ps=con.prepareStatement("Select * from Customers where CustID=?");
           ps.setString(1,id);
         
           ResultSet rs=ps.executeQuery();
            
           boolean status = rs.next();
          
           con.close();
         if(status) {
            setCustID(rs.getString(1));
            setCustPassword(rs.getString(2));
            setCustFirstName(rs.getString(3));
            setCustLastName(rs.getString(4));
            setCustAddress(rs.getString(5));
            setCustEmail(rs.getString(6));
            
           }else {
           System.out.println("Customer not found!");
           
           }
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
    }
    
    public void insertDB(String FirstName, String LastName, String Address, String Email, String ID, String Password){
        setCustID(ID);
        setCustPassword(Password);
        setCustFirstName(FirstName);
        setCustLastName(LastName);
        setCustAddress(Address);
        setCustEmail(Email);
        try {
         String id;
         id = CustID;

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/Java project/Java3/JRbank/ChattBankMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              Statement stmt = con.createStatement();
            String sql ="Insert into Customers values ('"+getCustID()+"',"+"'"+getCustPassword()+"',"+"'"+getCustFirstName()+"',"+"'"+getCustLastName()+"',"+"'"+getCustAddress()+"',"+"'"+getCustEmail()+"')";
           System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            con.close();

          
           con.close();
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
    
    }
    
    public void deleteDB(){
    try{

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/Java project/Java3/JRbank/ChattBankMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              Statement stmt = con.createStatement();
            String sql = "Delete from Customers where CustID='"+getCustID()+"'";

          System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("DELETE Successful!!!");
            else
                System.out.println("DELETE FAILED***********");

         
          
           con.close();
         
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
    }

    private void display() {
        System.out.println("ID = " + CustID );
        System.out.println("Password = " + CustPassword );
        System.out.println("First Name = " + CustFirstName );
        System.out.println("Last Name = " + CustLastName );
        System.out.println("Address = " + CustAddress );
        System.out.println("Email = " + CustEmail );

    }
        public static void main(String args[]){
        Customer c1 = new Customer();
        c1.selectDB("3001");
        c1.display();
        
        Customer c2 = new Customer();
        c2.insertDB("Juan","Rodriguez","123 street","email@gmail.com","123456","78910");
        
        Customer c3 = new Customer();
        c3.selectDB("123456");
        c3.deleteDB();
    }

 
    
}
