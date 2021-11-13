package Business;

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
public class Account {
     public String AcctNo, Cid, Type, Balance;
     
     public Account(){
     AcctNo = "";
     Cid = "";
     Type = "";
     Balance="";
     }
     
     public Account(String AcctNo, String Cid, String Type, String Balance) {
         this.AcctNo = AcctNo;
         this.Cid = Cid;
         this.Type = Type;
         this.Balance = Balance;            
     }

    public String getAcctNo() {
        return AcctNo;
    }

    public void setAcctNo(String AcctNo) {
        this.AcctNo = AcctNo;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String Cid) {
        this.Cid = Cid;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }
    public void selectDB(String AcctNo){
   
    try {
         String id;
         id = AcctNo;

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/Java project/Java3/JRbank/ChattBankMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              PreparedStatement ps=con.prepareStatement("Select * from Accounts where AcctNo=?");
           ps.setString(1,id);
         
           ResultSet rs=ps.executeQuery();
            
           boolean status = rs.next();
          
           con.close();
         if(status) {
            setAcctNo(rs.getString(1));
            setCid(rs.getString(2));
            setType(rs.getString(3));
            setBalance(rs.getString(4));       
           }else {
           System.out.println("Account not found!");
           
           }
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
    }
     public void insertDB(String AccountNo, String AccountID, String AccountType, String AccountBalance){
        setAcctNo(AccountNo);
        setCid(AccountID);
        setType(AccountType);
        setBalance(AccountBalance);
        try {
         String id;
         id = AcctNo;

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/Java project/Java3/JRbank/ChattBankMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              Statement stmt = con.createStatement();
            String sql ="Insert into Accounts values ('"+getAcctNo()+"',"+"'"+getCid()+"',"+"'"+getType()+"',"+"'"+getBalance()+"')";
           System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
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
            String sql = "Delete from Accounts where AcctNo='"+getAcctNo()+"'";

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
        public void display() {
        System.out.println("Account Number = " + AcctNo );
        System.out.println("Account ID = " + Cid );
        System.out.println("Account Type = " + Type );
        System.out.println("Account Balance = " + Balance );

    }
     public static void main(String args[]){
        Account a1 = new Account();
        a1.selectDB("90000");
        a1.display();
      
        Account a2 = new Account();
        a2.insertDB("10","20","CHK","100");
      
        Account a3 = new Account();
        a3.selectDB("10");
        a3.deleteDB();
        
    }
}
