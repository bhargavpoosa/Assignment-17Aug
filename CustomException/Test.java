import java.io.IOException;
import java.util.Date;
class Account {
    private String accountNo;
    private String accountName;
    private Date openedDate;
    private String status;
    private double balance;

    public Account(String accountNo, String accountName, Date openedDate, String status, double balance){
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.openedDate = openedDate;
        this.status = status;
        this.balance = balance;
    }
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}

class Transaction {
    public void deposit(Account acc, double amount){
        acc.setBalance(acc.getBalance() + amount);
    }

    public void withdraw(Account acc, double amount) throws ISBException{
        double balance = acc.getBalance();
        if(balance<amount)
            throw new ISBException(balance);
        acc.setBalance(balance-amount);
    }
}
class ISBException extends IOException {
    private String msg;
    private double amount;

    public ISBException(double amount){
        this.msg = "Not Enough Balance";
        this.amount = amount;
    }
    public ISBException(String msg, double amount){
        this.msg = msg;
        this.amount = amount;
    }

    public String toString(){
        return this.msg + " " + this.amount;
    }
}

public class Test{
    public static void main(String args[]) throws Exception{
        try{
            Account acc = new Account("123", "bhargav", new Date(), "Active",2000);
            Transaction transaction = new Transaction();
            transaction.deposit(acc,100);
            System.out.println(acc.getBalance());
            transaction.withdraw(acc, 10000);
        }
        catch(ISBException e){
            System.out.println("Exception");
        }

    }
}