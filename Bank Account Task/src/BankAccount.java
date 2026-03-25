public class BankAccount{
    private final String accountName;
    private final String accountNumber;
    private double balance;
    public static int totalAccounts = 0;

    public BankAccount(){
        this("Unknown","0000000",0.0);
    }
    public BankAccount(String accountName,String accountNumber,double balance){
        validateAmount(balance);
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    private void validateAmount(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Transaction failed you can't have negative values");
        }
    }

    public void deposit(double amount){
        validateAmount(amount);
        this.balance += amount;
        System.out.println("Depositing.............");
        System.out.println("You deposited "+ amount);
    }
    public void withdraw(double amount){
        validateAmount(amount);
        if(amount > balance){
            throw new IllegalStateException("Insufficient Funds");
        }
        this.balance -= amount;
        System.out.println("Withdrawing..........");
        System.out.println("You withdrew "+amount);
    }
    public void displayInfo(){
        System.out.println("*****************************");
        System.out.println("ACCOUNT SUMMARY");
        System.out.println("Account Name: "+ accountName);
        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Balance: "+ balance);
        System.out.println("*****************************");
    }

    public static void getTotalAccounts(){
        System.out.println("Total accounts "+totalAccounts);
    }
    public String getAccountName(){
        return accountName;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
}