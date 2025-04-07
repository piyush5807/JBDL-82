public class ThreadCreationByInheritingFromThread extends Thread{

    @Override
    public void run() {
        System.out.println("Inside thread : " + currentThread());
    }

    public static void main(String[] args) {

//        System.out.println("Inside main thread...");
//        MyThread thread = new MyThread();
//        thread.start();


        ThreadCreationByInheritingFromThread thread = new ThreadCreationByInheritingFromThread();
        thread.start();

        System.out.println("Inside main thread, after new thread creation... " + Thread.currentThread());


        /**
         * 1. Using Runnable interface
         * 2. Extending thread.java class
         */

    }

//    private static class MyThread extends Thread{
//        @Override
//        public void run() {
//            System.out.println("Inside MyThread: current thread - " + currentThread());
//        }
//    }
}
