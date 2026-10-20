import java.util.Scanner;

class BankAccount {
    int balance = 0;

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        balance -= amount;
    }

    int getBalance() {
        return balance;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        BankAccount account = new BankAccount();

        for (int i = 0; i < N; i++) {
            String operation = sc.next();
            int amount = sc.nextInt();

            if (operation.equals("Deposit")) {
                account.deposit(amount);
            } else if (operation.equals("Withdraw")) {
                account.withdraw(amount);
            }
        }

        System.out.println(account.getBalance());
        sc.close();
    }
}
