import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

//        numbers.stream()
//                .parallel()
//                .forEach(x ->
//                        System.out.println("For X = " + x + ", inside thread - " + Thread.currentThread())
//                );
//
//        System.out.println("****************************");

        numbers.parallelStream()
                .forEach(x -> {
                            compute();
                            System.out.println("For X = " + x + ", inside thread - " + Thread.currentThread());
                });
    }

    public static void compute(){
        long ans = 1;
        for(int i = 1; i < 1000000000; i++){
            ans = ans * i;
        }
    }
}
