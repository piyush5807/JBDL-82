public class MyRunnable implements Runnable{

    private int num;
    private boolean result;

    public MyRunnable(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public void run() {
        System.out.println("Inside run : num = " + this.num + ", thread = " + Thread.currentThread());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(this.num % 2 == 0){
            this.result = true;
        }


    }
}
