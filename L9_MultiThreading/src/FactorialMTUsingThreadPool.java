import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FactorialMTUsingThreadPool {

    private static class Task{
        int input;
        BigInteger output;

        public Task(int input) {
            this.input = input;
            this.output = BigInteger.ONE;
        }

        public BigInteger calculate(){
            for(int i = 1; i <= this.input; i++){
                this.output = this.output.multiply(BigInteger.valueOf(i));
            }

            return this.output;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Task> tasks = numbers.stream().map(x -> new Task(x)).collect(Collectors.toList());

        ExecutorService executors = Executors.newFixedThreadPool(10);

        List<Future<BigInteger>> results = new ArrayList<>();

        for(final Task task: tasks){
            Future<BigInteger> taskResult = executors
                    .submit(() -> task.calculate());

            results.add(taskResult);
        }

//        executors.awaitTermination(5, TimeUnit.SECONDS);
         executors.shutdown();

        for(int i = 0; i < results.size(); i++){
            System.out.println("Factorial of " + tasks.get(i).input + " is " + results.get(i).get());
        }

        long end = System.currentTimeMillis();

        System.out.println("Total time - " + (end - start));
    }


}
