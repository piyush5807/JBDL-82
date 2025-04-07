public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside run function of myrunnable, thread - " + Thread.currentThread());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        Thread thread = new Thread(new MyOtherRunnable());
//        thread.start();
    }
}
