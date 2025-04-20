public class BankAccount {

    private static int numberOfAccount = 0;

    private String accountId;
    private Long balance;  // 2050

    // Map -->   { accountId --> account }
    public BankAccount(String accountId, Long balance) {
        this.accountId = accountId;
        this.balance = balance;

        incrementCount();
    }
    public static void incrementCount(){

        System.out.println("Inside incrementCount, thread = " + Thread.currentThread());
        synchronized (BankAccount.class){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside incrementCount, inside critical section, thread = " + Thread.currentThread());
            numberOfAccount ++;
        }

        System.out.println("Inside incrementCount, exit section, thread = " + Thread.currentThread() + ", count = " + numberOfAccount);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void deposit(Long money) throws InterruptedException {
//        System.out.println("Inside deposit: money = " + money + " thread = " + Thread.currentThread());

//        Thread.sleep(2000);

        synchronized (this) {
            this.balance += money;
        }

        //

//        System.out.println("Inside deposit, after updating balance: money = " + money + ", thread = " + Thread.currentThread());

    }

    // Bal = +5
    // Withdraw = -10

    public void withdraw(Long money) throws Exception {

        // some other logic which is not working on this object

//        if(money > 5000){
//            System.out.println("Hey! this is a big withdrawl, it needs to be logged, thread = " + Thread.currentThread());
//        }else if(money > 3000){
//            System.out.println("Hey! this is a medium level withdrawl, it needs to be logged, thread = " + Thread.currentThread());
//        }

        synchronized (this) {
//            Thread.sleep(5000);
//            System.out.println("Inside withdraw: money = " + money + ", thread = " + Thread.currentThread());
            if (this.getBalance() < money) {
                throw new Exception("Insufficient Balance");
            }
            this.balance -= money;
        }

//        System.out.println("Inside withdraw, after updating balance: money = " + money + ", thread = " + Thread.currentThread());

    }

    public synchronized void withdraw2(Long money) throws Exception {

            Thread.sleep(5000);
            System.out.println("Inside withdraw: money = " + money + ", thread = " + Thread.currentThread());
            if (this.getBalance() < money) {
                throw new Exception("Insufficient Balance");
            }
            this.balance -= money;
    }
}

/**
 * Inside withdraw: money = 20000, thread = Thread[Thread-0,5,main]
 * Inside deposit: money = 30000 thread = Thread[Thread-1,5,main]
 * Inside withdraw: money = 20000, thread = Thread[Thread-2,5,main]
 * Inside withdraw, after updating balance: money = 20000, thread = Thread[Thread-2,5,main]
 * Inside deposit, after updating balance: money = 30000, thread = Thread[Thread-1,5,main]
 * Inside withdraw, after updating balance: money = 20000, thread = Thread[Thread-0,5,main]
 * In main thread: after all operations, balance = 40000
 */