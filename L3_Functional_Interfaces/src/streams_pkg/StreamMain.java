package streams_pkg;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamMain {

    /**
     * You are given a list of integers, you need to print the sum of squares of even numbers in the list
     * Ex: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * Ans = 2^2 + 4^4 + 6^6 + 8^8 + 10^10 = 220
     * @param args
     */

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(getSumOfSquaresUsingStreams(numbers));
    }

    // declarative way
    // stream of elements --> phase 1 --> phase 2 --> phase 3 --> phase 4 --> .....

    /**
     * Identity for addition, subtraction = I + e = e {0}
     * Identity for multiplication, division, power = I * e = e {1}
     *
     * @param numbers
     * @return
     */


    /**
     * Identity for addition, subtraction = I + e = e {0}
     * Identity for multiplication, division, power = I * e = e {1}
     */

    public static Integer getSumOfSquaresUsingStreams(List<Integer> numbers){

        int result = numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce(0, (x, y) -> {       // Disclaimer: Valid only for this particular scenario
                    System.out.println("Inside reduce: x = " + x + ", y = " +  y);
                    return x + y;
                });

        return result;
    }

    public static Integer getSumOfSquares(List<Integer> numbers){
        // Imperative way of writing code
        // e1, e2, e3, ..... e10
        // 1. filtering (checking if the number is even or not)
        // 2. Transforming / Mapping (Squaring the numbers)
        // 3. Accumulating result (Summing all the squares)
        int result = 5;
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 0){
                int square = numbers.get(i) * numbers.get(i);
                result = result + square;
                // result += Math.pow(numbers.get(i), 2);
            }
        }

        return result;
    }
}
