import java.util.Comparator;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

//    public void D(){
//        this.F = 20;
//        this.E();
//    }
//
//    public void E(){
//
//    }

    public int F;

    public static void A(){
        System.out.println("Inside A");
        B();
        System.out.println("Inside A after B");
    }

    public static void B(){
        System.out.println("Inside B");
        C();
        System.out.println("Inside B after C");

    }

    public static void C(){
        System.out.println("Inside C");
    }

    public static void main(String[] args) {

//        A();
//        Operations operations = new Operations() {
//            @Override
//            public int add(int a, int b) {
//                System.out.println("Inside add function, a = " + a + ", b = " +  b);
//                return a + b;
//            }
//
//            @Override
//            public int subtract(int a, int b) {
//                return Math.abs(a - b);
//            }
//        };

//        System.out.println(operations.add(10, 20));
//        System.out.println(operations.subtract(10, 20));

//        System.out.println("***************************");


        // Lambda expression
        // You have to write the method signature parameters and the function body, nothing else
        // Lambda expressions can only be written for functional interfaces not the normal interfaces
//        Operations o2 = (c, d) -> {
//            System.out.println("Inside add function, c = " + c + ", d = " +  d);
//            return c + d;
//        };


//        System.out.println(o2.add(10, 20));
//        System.out.println(o2.subtract(10, 20));

        // Streams


//        Operations o3 = () -> System.out.println("Hello world!!!");
//        o3.subtract(10, 20);


//
//        OperationsImpl operations = new OperationsImpl();
//        operations.print();
//
//        //
//        Runnable runnable = () -> System.out.println("Inside runnable, run function...");
//        runnable.run();
//
//        Runnable runnable2 = () -> System.out.println("Inside runnable 2, run function...");
//        runnable2.run();
//
//        Runnable runnable3 = () -> System.out.println("Inside runnable 3, run function...");
//        runnable3.run();
//
//
//        Runnable runnable4 = () -> System.out.println("Inside runnable 4, run function...");
//        runnable4.run();
//
//        Runnable[] arr = new Runnable[4];
//        for(int i = 0; i < 4; i++){
//            arr[i] = () -> System.out.println("Inside runnable, run function...");
//            arr[i].run();
//        }
//
//
//        arr = new Runnable[4];
//        for(int i = 0; i < 4; i++){
//            arr[i] = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("Inside runnable, run function...");
//                }
//            };
//            arr[i].run();
//        }

//        Comparator<Person> comparator = (p1, p2) -> {
//            if(p1.age == p2.age){
//                return p1.name.compareTo(p2.name);
//            }
//            return p1.age - p2.age;
//        };
//        Person p1 = new Person(20, "ABC");
//        Person p2 = new Person(20, "DEF");
//        System.out.println(comparator.compare(p1, p2));

        // 4 5 --> "44444"
        // 33 --> "3333"

//        Function<Integer, String> function = (a) -> a + "" + a;
//        System.out.println(function.apply(10));
//
//        Function<String, String> f2 = (a) -> a.toLowerCase();
//        System.out.println(f2.apply("CitY"));


//        BiFunction<Integer, Integer, String> biFunction = (a, b) -> {
//            String result = "";
//            for(int i = 0; i < b; i++){
//                result += a;
//            }
//
//            return result;
//        };
//
//        System.out.println(biFunction.apply(200, 10));

//        Supplier<Integer> supplier = () -> new Random().nextInt();
//        System.out.println(supplier.get());

        Predicate<String> predicate = (s) -> s.length() == 10;
        System.out.println(predicate.test("Ahemdabad"));

    }
}