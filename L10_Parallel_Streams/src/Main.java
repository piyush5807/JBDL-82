import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        // Parallel Streams:
        /**
         * Q1. Given a list of integers, you need to find the first even number
         * numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
         * Ans = 2
         */

        List<Integer> numbers = Arrays.asList(9, 3, 1, 5, 7, 2, 4, 6, 7, 8, 10);
        System.out.println(findAnyEvenUsingPS(numbers));

//        List<String> cities = Arrays.asList("Delhi", "Kanpur", "Delhi", "Chennai", "Delhi", "Hyderabad", "Delhi", "Bangalore", "Gurugram", "Delhi", "Chennai", "Delhi");
//            System.out.println(removeDuplicates(cities));

//        List<String> cities = Arrays.asList("Delhi", "Chennai", "Bangalore", "Kanpur", "Hyderabad", "Gurugram");
//        System.out.println(recreateList(cities));
    }


    public static List recreateList(List<String> cities){
        List<String> citiesToReturn = new ArrayList<>();
        cities.stream()
                .forEach(x -> {

                    System.out.println("Inside foreach: x = " +  x + ", thread = " + Thread.currentThread() + ", citiesToReturn = " + citiesToReturn);
                    citiesToReturn.add(x);

                });

        return citiesToReturn;
    }

    // Do not do this
    public static List<String> removeDuplicates(List<String> cities){

        List<String> citiesToReturn = new ArrayList<>();
        cities.stream().parallel()
                .forEach(x -> {
                    boolean isPresent = citiesToReturn.contains(x);

                    if(!isPresent){
                        System.out.println("Inside foreach : x = " + x + ", not present in the set,  thread = " + Thread.currentThread());
                        citiesToReturn.add(x);
                    }else{
                        System.out.println("Inside foreach : x = " + x + ", present in the set ?, thread = " + Thread.currentThread());
//                        citiesToReturn.add(x);
                    }
                });

        return citiesToReturn;

    }

    public static Integer findSumOfSquares(List<Integer> numbers){

        return numbers.parallelStream()
                .filter(x -> {
                    System.out.println("Inside filter: x = " + x + ", thread = " + Thread.currentThread());
                    return x % 2 == 0;
                })
                .map(x -> {
                    System.out.println("Inside map: x = " + x + ", thread = " + Thread.currentThread());
                    return x * x;
                })
                .reduce(0, (x, y) -> {
                    try {
                        if(y == 64 || y == 100) {
                            Thread.sleep(7000);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Inside reduce: x,y = " + x + "," + y + ", thread = " + Thread.currentThread());
                    return x + y;
                });
    }


    public static Integer findFirstEven(List<Integer> numbers){
        return numbers.stream()
                .filter(x -> {
                    System.out.println("Inside filter: x = " + x + ", thread = " + Thread.currentThread()); // 2 or all 10 ?
                    return x % 2 == 0;
                })
                .findFirst() // 2
                .orElse(null);
    }

    /**
     * Q1. How many elements will go inside the filter block ? Is it deterministic or non-deterministic
     * Q2. What should be the output, is it deterministic or non-deterministic ? Deterministic in this scenario
     * @param numbers
     * @return
     */

    public static Integer findFirstEvenUsingPS(List<Integer> numbers){
        return numbers.stream()
                .parallel()
                .filter(x -> {
                    System.out.println("Inside filter: x = " + x + ", thread = " + Thread.currentThread().getName()); // 2 or all 10 ?
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return x % 2 == 0;
                })
                .findFirst() // 2
                .orElse(null);
    }

    public static Integer firstEvenIterativeApproach(List<Integer> numbers) throws InterruptedException {

        Thread[] threads = new Thread[numbers.size()];
        MyRunnable[] runnables = new MyRunnable[numbers.size()];
        for(int i = 0; i < numbers.size(); i++){
            runnables[i] = new MyRunnable(numbers.get(i));
            threads[i] = new Thread(runnables[i]);
            threads[i].start();
        }

        for(int i = 0; i < numbers.size(); i++){
            threads[i].join();
            if(runnables[i].isResult()){
                return numbers.get(i);
            }
        }

        return null;
    }

    public static Integer findAnyEvenUsingPS(List<Integer> numbers){
        return numbers.stream()
                .parallel()
                .filter(x -> {
                    System.out.println("Inside filter: x = " + x + ", thread = " + Thread.currentThread().getName()); // 2 or all 10 ?
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    return x % 2 == 0;
                })
                .findAny() // 2
                .orElse(null);
    }


}