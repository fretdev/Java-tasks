public class BankAccount{
    private final String accountname;
    private final String accountNumber;
    private double balance;
    public static int totalAccounts = 0;

    public BankAccount(){
        this("Unknown","0000000",0.0);
    }
    public BankAccount(String accountName,String accountNumber,double balance){
        validateAmount(balance);
        this.accountname = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    private void validateAmount(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Transaction failed you can't have negative values");
        }
    }

    public void deposit(double amount){
        validateAmount(amount);
        this.balance += amount;
        System.out.println("You deposited "+ amount);
    }
    public void withdraw(double amount){
        validateAmount(amount);
        if(amount > balance){
            throw new IllegalStateException("Insufficient Funds");
        }
        this.balance -= amount;
        System.out.println("You withdrew "+amount);
    }
    public void displayInfo(){
        System.out.println("*****************************");
        System.out.println("ACCOUNT SUMMARY");
        System.out.println("Account Name: "+accountname);
        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Balance: "+ balance);
        System.out.println("*****************************");
    }

    public static void getTotalAccounts(){
        System.out.println("Total accounts "+totalAccounts);
    }
    public void getAccountName(){
        System.out.println("Your account name is "+accountname);
    }
    public void getAccountNumber(){
        System.out.println("Your account number is "+accountNumber);
    }
    public void getBalance(){
        System.out.println("Your balance is "+balance);
    }
}