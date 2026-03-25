public class Main{
    public static  void main(String[] args){
        System.out.println("*******************");
        System.out.println("FRETDEV BANK");
        System.out.println("*******************");


//        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount("Prosper","8133179030",5000);

        System.out.println("Total accounts "+ BankAccount.getTotalAccounts());
        account2.displayInfo();

        System.out.println("Testing my class attributes");
        System.out.println("***************************");
        System.out.println("Account name: "+account2.getAccountName());
        System.out.println("Account number: "+account2.getAccountNumber());
        System.out.println("Account balance: "+account2.getBalance());

        System.out.println("***********************************************");
        System.out.println("Testing the deposit and withdraw methods");
        System.out.println("***********************************************");
        account2.deposit(5000);
        System.out.println("Account balance: "+account2.getBalance());
        System.out.println();
        account2.withdraw(1000);
        System.out.println("Account balance: "+account2.getBalance());
        System.out.println();

        System.out.println("*******************************");
        System.out.println("Testing the default constructor");
//        account1.displayInfo();

        System.out.println("Checking my input validations");
        System.out.println("*******************************");
        System.out.println("Checking withdraw amount input validation");
        System.out.println("*****************************************");
        try{
            account2.withdraw(500000);
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Account balance: "+account2.getBalance());

        }
        System.out.println("*****************************************");
        System.out.println("Checking deposit amount input validation");
        System.out.println("*****************************************");
        try{
            account2.deposit(-500);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Account balance: "+account2.getBalance());
        }

    }
}