import java.util.*;

class InsufficientBalanceException extends Exception{
  public InsufficientBalanceException(String message){
    super(message);
  }
}

class Account{
  String accountHolderName;
  double accountBalance;

  public Account(String name, double balance){
    this.accountHolderName=name;
    this.accountBalance=balance;

  }
  public void displayDetails(){
    System.out.println("Account Holder Name: "+accountHolderName+"\nAccount Balance: "+accountBalance);
  }
  public void withdraw(double amount) throws InsufficientBalanceException{
    if(amount<=0){
      throw new IllegalArgumentException("Invalid Withdrawal Amount | Amount must be greater than 0!");

    }
    if(amount>accountBalance){
      throw new InsufficientBalanceException("Insufficient balance! Available Balance: "+accountBalance);
    }
    accountBalance = accountBalance-amount;
    System.out.println("Withdrawal of Rs."+amount+" Successfull");
    System.out.println("Remaining Account Balance: "+accountBalance);
  }
}

public class ATM{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    try{
      System.out.println("Enter Account Holder Name:");
      String name=in.nextLine();

      System.out.println("Enter Initial Account Balance:");
      double balance=in.nextDouble();

      Account acc = new Account(name,balance);
      acc.displayDetails();

      System.out.println("Enter Number of Withdrawals: ");
      int n = in.nextInt();

      for(int i=1;i<=n;i++){
        System.out.print(i+". Enter Withdrawal Amount: ");
        double amount=in.nextDouble();

        try{
          acc.withdraw(amount);
        }
        catch(InsufficientBalanceException | IllegalArgumentException e){
          System.out.println("Transaction Failed! "+ e.getMessage());
          System.out.println("Remaining Account Balance: "+acc.accountBalance);


        }
      
      }
    
    }
    catch(InputMismatchException e){
      System.out.println("Invalid Input! Enter only Numeric Values");

    }

    finally{
        in.close();
      }
  }
}
