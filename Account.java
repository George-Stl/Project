import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Account {
    private int id;
    private String name;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions= new ArrayList<Transaction>();

    public Account(){
        dateCreated = new Date();
    }
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }
    public Account(String name, int id, double balance){
        this.name = name;
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public static void setAnnualInterestRate(double annualInterestRate){
        Account.annualInterestRate = annualInterestRate;
    }
    public double getMonthlyInterest(){
        return balance * (annualInterestRate / 1200);
    }
    public void withdraw(double amount){
        this.balance -= amount;
        transactions.add(new Transaction('-', amount,
                this.balance, ""));
    }
    public String getName(){
        return this.name;
    }
    public void deposit(double amount){
        balance += amount;
        transactions.add(new Transaction('+', amount,
                this.balance, ""));
    }
    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

}
