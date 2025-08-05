import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class FactorialUsingMT {

    public static void main(String[] args) throws InterruptedException {
        // ✅ Step 1: Define input numbers
        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000);
        // For testing smaller values:
        // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // ✅ Step 2: Initialize timer
        long startTime = System.currentTimeMillis();

        // ✅ Step 3: Create arrays to hold threads and results
        int n = numbers.size();
        MyThread[] threads = new MyThread[n];
        BigInteger[] results = new BigInteger[n];

        // ✅ Step 4: Start all threads
        for (int i = 0; i < n; i++) {
            threads[i] = new MyThread(numbers.get(i));
            threads[i].start(); // This runs threads in parallel
        }

        // ✅ Step 5: Wait for all threads to finish (join) and collect results
        for (int i = 0; i < n; i++) {
            threads[i].join(); // Ensure this thread completes
            results[i] = threads[i].getResult(); // Fetch computed result
            System.out.println("Factorial of " + numbers.get(i) + " is " + results[i]);
        }

        // ✅ Step 6: Print total time taken
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + " ms");
    }

    /**
     * 🧵 Custom thread class to compute factorial of a number
     */
    private static class MyThread extends Thread {
        private final int num;
        private BigInteger result;

        public MyThread(int num) {
            this.num = num;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            System.out.println("Thread started for number: " + num + " → " + currentThread().getName());
            calculateFactorial();
        }

        /**
         * Calculates factorial and stores in `result`
         */
        private void calculateFactorial() {
            for (int i = 1; i <= num; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
