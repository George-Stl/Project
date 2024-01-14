import java.util.Scanner;

public class TestAccountATM {
    private static Scanner input = new Scanner(System.in);
    private Account[] accounts = new Account[10];
//создает объект банкомат с 10-ю банковскими счетами
    public TestAccountATM(){
        for(int i = 0; i < accounts.length; i++){
            accounts[i] = new Account(i, 10000);
        }
    }

    public static void main(String[] args) {
        TestAccountATM accountATM = new TestAccountATM();
        int id;

        while(true){
            System.out.print("Введите id: ");
            id = input.nextInt();
            if(id < 0 || id > accountATM.accounts.length){
                System.out.println("Введите, пожалуйста, корректный id");
                continue;
            }
            while(true){
                int choice = accountATM.getMenuSelection();
                if(choice == 1){
                    System.out.println("Баланс равен " +
                            accountATM.accounts[id].getBalance());
                } else if (choice == 2){
                    accountATM.withdraw(id);
                } else if (choice == 3){
                    accountATM.deposit(id);
                } else break;

            }
        }
    }
    public int getMenuSelection(){
        int choice;

        while(true){
            System.out.println("Основное меню" +
                    "\n1: проверить баланс счета" +
                    "\n2: снять со счета" +
                    "\n3: положить на счет" +
                    "\n4: выйти");
            System.out.print("Введите пункт меню: ");
            choice = input.nextInt();
            if(choice < 1 || choice > 4){
                System.out.println("Вы ввели некорректный пункт меню!");
            }
            else{
                break;
            }
        }
        return choice;
    }
    public void withdraw(int id){
        System.out.println("Введите сумму для снятия со счета: ");
        int amount = input.nextInt();
        if(amount < 0){
            System.out.print("Сумма отрицательная! Операция отменена.");
        }else if (amount <= accounts[id].getBalance()){
            accounts[id].withdraw(amount);
        } else{
            System.out.println("Недостаточно средств на счете! Операция отменена.");
        }
    }
    public void deposit(int id){
        System.out.println("Введите суму для внесения на счет: ");
        int amount = input.nextInt();
        if(amount >= 0){
            accounts[id].deposit(amount);
        } else {
            System.out.println("Сумма отрицательная! Операция отменена.");
        }
    }

}
