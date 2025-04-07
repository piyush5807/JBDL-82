import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class FactorialUsingMT {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long start = System.currentTimeMillis();
        MyThread[] threads = new MyThread[numbers.size()];
        BigInteger[] result = new BigInteger[numbers.size()];
        for(int i = 0; i < numbers.size(); i++) {
            threads[i] = new MyThread(numbers.get(i));
            threads[i].start(); // creation of a thread

//            threads[i].join(3000); // thread-0 --> 15 ms --> main thread will be unblocked after 15 ms
            // thread-0 --> 45 ms --> main thread will be unblocked after 30 ms
//            result[i] = threads[i].result;
        }


        for (int i = 0; i < result.length; i++){
            threads[i].join();
            result[i] = threads[i].result;
            System.out.println("Factorial of " + numbers.get(i) + " is " + result[i]);
        }

        long end = System.currentTimeMillis();

        System.out.println("Time taken - " + (end - start));

    }

    private static class MyThread extends Thread {

        private int num;
        private BigInteger result;

        MyThread(int num){
            this.num = num;
            this.result = BigInteger.ONE;
        }

        public void run(){  // T1's run - 10000 , T2's run - 20000
            System.out.println("Inside run of thread : " + currentThread());
            calculateFactorial(this.num);
        }

        public void calculateFactorial(int num) {
            for(int i = 1; i <= num; i++){
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }

//            System.out.println("Factorial of " + this.num + " is " + this.result);
        }
    }
}
