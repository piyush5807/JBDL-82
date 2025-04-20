import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread2 t0 = new MyThread2("a1", 50000l);
        MyThread2 t1 = new MyThread2("a2", 60000l);
        MyThread2 t2 = new MyThread2("a3", 40000l);
        MyThread2 t3 = new MyThread2("a4", 30000l);
        MyThread2 t4 = new MyThread2("a5", 20000l);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
//        BankAccount account = new BankAccount("a1", 50000l);
//
//        MyThread t0 = new MyThread(account, 20000l, false); // - 20000
//        t0.start();
//        MyThread t1 = new MyThread(account, 30000l, false); // + 30000
//        t1.start();
//        MyThread t2 = new MyThread(account, 40000l, true); // - 20000
//        t2.start();
//
//        BankAccount account2 = new BankAccount("a2", 100000l);
//        MyThread t3 = new MyThread(account2, 10000l, true);
//        t3.start();
//
//        MyThread t4 = new MyThread(account2, 20000l, false);
//        t4.start();

//        t1.join();
//        t2.join();
//        t3.join();
//        System.out.println("In main thread: after all operations, balance = " + account.getBalance());

    }

    private static class MyThread extends Thread {

        private Long money;
        private boolean isDeposit; // false

        private BankAccount account;


        MyThread(BankAccount account, Long money, boolean isDeposit){
            this.money = money;
            this.isDeposit = isDeposit;
            this.account = account;
        }

        @Override
        public void run() {
            if(this.isDeposit){
                try {
                    this.account.deposit(this.money);
                    System.out.println("Inside run: thread name " + currentThread() + ", balance = " + this.account.getBalance());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try {
                    this.account.withdraw(this.money);
                    System.out.println("Inside run: thread name " + currentThread() + ", balance = " + this.account.getBalance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class MyThread2 extends Thread {
        private String accountId;

        private Long balance;


        MyThread2(String accountId, Long balance){
            this.accountId = accountId;
            this.balance = balance;
        }

        @Override
        public void run() {
            new BankAccount(accountId, balance);
        }
    }
}