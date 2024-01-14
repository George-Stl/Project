public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Баланс равен: " + account.getBalance() +
                " руб.");
        System.out.println("Ежемесячный процент равен " +
                account.getMonthlyInterest() + " руб.");
        System.out.println("Этот счет был создан " +
                account.getDateCreated());
    }
}
