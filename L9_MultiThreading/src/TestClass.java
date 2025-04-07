public class TestClass {

    public static void main(String[] args) {

        Thread thread = new Thread(new MyThread());
        thread.setDaemon(true);
        thread.start();

        System.out.println("Exiting from main function");
    }

    private static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("Inside thread - " + Thread.currentThread() + ", daemon - " + Thread.currentThread().isDaemon());
                Thread.sleep(5000);

                System.out.println("After sleeping in " + Thread.currentThread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
