public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        System.out.println("Inside thread - " + Thread.currentThread() + " at instant " + System.currentTimeMillis());


        Thread t1 = new Thread(new MyRunnable(), "mt1");  // Creating an object of thread class, not an actual thread on the h/w
        t1.start();   // Creating a new thread on the hardware

//        t1.join();
        System.out.println("Inside main thread, t1 is created at instant " + System.currentTimeMillis());

//        Thread t2 = new Thread(new MyRunnable(), "main");  // Creating an object of thread class, not an actual thread on the h/w
//        t2.start();   // Creating a new thread on the hardware
//
//        System.out.println("Inside main thread, t2 is created");
//
//        Thread t3 = new Thread(new MyRunnable(), "mt3");  // Creating an object of thread class, not an actual thread on the h/w
//        t3.start();   // Creating a new thread on the hardware
//
//        System.out.println("Inside main thread, t3 is created");
//
//        Thread t4 = new Thread(new MyRunnable(), "mt4");  // Creating an object of thread class, not an actual thread on the h/w
//        t4.start();   // Creating a new thread on the hardware
//
//        System.out.println("Inside main thread, t4 is created");
//
//        System.out.println(Runtime.getRuntime().availableProcessors());


//        t1.run();

//        A();
//        B();
//        C();
//        D();
    }

    public static void A(){
        System.out.println("Inside function A...");
    }

    public static void D(){
        System.out.println("Inside function D...");
    }

    public static void B(){
        System.out.println("Inside function B...");
    }

    public static void C(){
        System.out.println("Inside function C...");
    }
}