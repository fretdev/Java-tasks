public class Main{
    public static  void main(String[] args){
        System.out.println("*******************");
        System.out.println("FRETDEV BANK");
        System.out.println("*******************");


        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount("Prosper","8133179030",5000);

        BankAccount.getTotalAccounts();

        account2.displayInfo();
        account2.getAccountName();
        account2.getAccountNumber();
        account2.getBalance();

        account2.deposit(5000);
        account2.getBalance();
        account2.withdraw(800);
        account2.getBalance();


        account1.displayInfo();
    }
}