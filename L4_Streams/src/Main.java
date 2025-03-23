import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        List<String> cities = Arrays.asList("a", "b", "c");

//        List<String> names = Arrays.asList("Rahul", "Piyush", "Karan");
//
//        names.forEach(x -> System.out.println(x));
//
//        for(String name: names){
//            System.out.println(name);
//        }
        /**
         * Q1. You are given list of numbers, you need to find the sum of squares of even numbers
         * q2. You are list of strings, you need to convert this list into a single string separated by a delimiter ,
         * Q3. You are given a list of numbers, you need to print any even number
         *
         * Q4. You are given list of cities, you need to print the lowercase string of those cities
         * Q5. You are given list of cities, you need to return the list of lowercase string of those cities
         *
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] ==> {2, 4, 6, 8, 10}
         *
         * ["my", "city", "is", "delhi"] ==> "my,city,is,delhi,"
         */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(getSumOfSquaresUsingStreams(numbers));

//        System.out.println(join(Arrays.asList("my", "city", "is", "delhi")));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(2);
        set.add(3);
        set.add(8);
        set.add(6);
        set.add(7);
        set.add(5);
        set.add(9);
        set.add(10);

        List<String> cities = Arrays.asList("Delhi", "Ahmedabad", "Bangalore", "Agra", "Hyderabad");

//        System.out.println(findAnyEvenUsingStreams(numbers));
//        printCities(cities);
        getCities(cities);
    }

    /**
     * filter --> all the elements
     * map --> 2, 4, 6, 8, 10 -->
     * reduce --> 4, 16, 36, 64, 100 -->
     * @param numbers
     * @return
     */

    private static Integer square(int num){
        return num * num;
    }

    private static Long square(long num){
        return num * num;
    }

    private static Double square(int num, int power){
        return Math.pow(num, power);
    }


    public static void printCities(List<String> cities){

        cities
                .stream()
                .map(String::toLowerCase)
//                .forEach(x -> System.out.println(x));
                .forEach(System.out::println);
    }

    public static void getCities(List<String> cities){

        List<String> result = cities
                .stream()
                .map(x -> x.toLowerCase())
                .collect(Collectors.toList());

        Stream<String> s = cities.stream().map(x -> x.toLowerCase());
//        List<String> finalCities = s.collect(Collectors.toList());
//        List<String> finalCities2 = s.collect(Collectors.toList());

        s = cities.stream().map(x -> x.toLowerCase());
        Stream<String> t = s.sorted();
        t.forEach(x -> System.out.println(x)); // terminal

//        s.sorted(); // also not desirable

//        System.out.println(finalCities + " " + finalCities2);

        // result = [delhi, ahmedabad, blr, agra, hyd]

//                .forEach(x -> System.out.println(x)); // We are operating on the list of string, not stream


//        cities
//                .stream()
//                .map(x -> x.toLowerCase())
//                .forEach(x -> System.out.println(x));
    }

    private static Integer add(int x, int y){
        return x + y;
    }

    private static Integer subtract(int x, int y){
        return y - x;
    }

    public static Integer getSumOfSquaresUsingStreams(List<Integer> numbers){


        int result = numbers.stream()
                .filter(x -> {
                    System.out.println("Inside filter: x = " +  x);
                    return x % 2 == 0;
                }) // 1, 3, 5, 7, 9 will be filtered out and not moved to the next phase
                .map(Main::square) // x -> square(x) {square(int a)}
                .reduce(0, Main::subtract); // when the number and the order of arguments is same as that of the lambda input

        return result;
    }

    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    /**
     * If block --> all
     * squaring + adding is happening only for 5 elements i.e 2, 4, 6, 8, 10
     * @param numbers
     * @return
     */

    public static Integer getSumOfSquares(List<Integer> numbers){
        int result = 0;
        for(int i = 0; i < numbers.size(); i++){ // 1
            System.out.println("Checking if i " + i + " is even or odd");
            if(numbers.get(i) % 2 == 0){  // 2 --> true
                int square = numbers.get(i) * numbers.get(i);
                System.out.println("Squaring i " + i);
                result = result + square;
                System.out.println("Adding square of i " + i);
                // result += Math.pow(numbers.get(i), 2);
            }
        }

        return result;
    }

    public static Integer findAnyEven(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 0){
                return numbers.get(i);
            }
        }

        return -1;
    }

    public static Integer findAnyEvenUsingStreams(List<Integer> numbers) {

        Optional<Integer> even = numbers
                .stream()
                .filter(x -> {
                    System.out.println("Inside filter.. x = " + x);
                    return x % 2 == 0;
                }) // {2, 4, 6, 8, 10}
                .findAny(); // even => null

//        return even.get(); // better not to use .get(), instead use a form of orElse
        return even.orElse(-1);
    }

    public static Integer findAnyEvenUsingStreams(Set<Integer> numbers) {

        Optional<Integer> even = numbers
                .stream()
                .filter(x -> {
                    System.out.println("Inside filter.. x = " + x);
                    return x % 2 == 0;
                }) // {2, 4, 6, 8, 10}
                .findAny(); // even => null

//        return even.get(); // better not to use .get(), instead use a form of orElse
        return even.orElse(-1);
    }


    public static String join(List<String> words){

        String result = words
                .stream()
                .map(x -> x + ", ")
                .reduce("", (x, y) -> x + y);

        return result;

        // I + E = E
        // "" + "my," = "my,"
    }

    /**
     * Short circuit terminal function - findFirst, findAny
     * Terminal function - reduce, forEach, collect, count
     */
}