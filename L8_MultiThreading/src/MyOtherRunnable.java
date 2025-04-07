public class MyOtherRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside another runnable... , thread = " + Thread.currentThread());
    }
}
