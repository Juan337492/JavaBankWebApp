package Business;


/**************************************************************
   Juan Rodriguez
      Lab #4 - Sep 27, 2021
   I wrote this code myself...
 **************************************************************/

public class AccountList {
    public int count = 0;
    public Account accArr[] = new Account[10]; 
    
    //a1 inserted into accArr array
    public void addAccount(Account a){
    accArr[count]=a;
    count++;
    }
    
    //displays array of accounts 
    public void displayList(){
    	for (int x=0; x<count; x++) {
	accArr[x].display(); //the Account class has a display() method

        }
    }
 
 public static void main(String arrgs[]){
    
   
 }
 
}
