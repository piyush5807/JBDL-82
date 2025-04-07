import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        /**
         * Q1. You are given a list of numbers, you need to find the factorial of those numbers
         */

        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000);
        long start = System.currentTimeMillis();
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        calculateFactorials(numbers);

        long end = System.currentTimeMillis();
        System.out.println("Time diff - " + (end - start));
    }

    public static void calculateFactorials(List<Integer> numbers){

        for(int i = 0; i < numbers.size(); i++){
            BigInteger result = calculateFactorial(numbers.get(i));
            System.out.println(result);
        }

    }

    private static BigInteger calculateFactorial(int num){
        BigInteger result = BigInteger.ONE;
        for(int i = 1; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}