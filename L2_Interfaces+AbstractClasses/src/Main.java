import java.util.*;

public class Main {

    {
        System.out.println("Inside main classes' non static block, ... a = " + this.a + ", b = " + this.b + ", c = " + c);
    }

    static int c = 40;

    // c1 --> o1 --> a1, o2 --> a2

    int a = 10;

    static {
        System.out.println("Inside main classes' non static block, ... c = " + c);
    }

    int b;

    Main(){
        this.b = 20;
        System.out.println("Inside main constructor,  a = " + this.a + "b = " + this.b);
    }

    public static void main(String[] args) {
//        Main main = new Main();
//        BritishCalculator bc = new BritishCalculator();
//        AmericanCalculator ac = new AmericanCalculator();
//
//        System.out.println(ac.multiply(4, 5));
//        System.out.println(bc.multiply(4, 5));

//        Calculator calci = new Calculator();
//        calci.add(10, 20);

//        Calculator calculator = new Calculator() {
//            @Override
//            public int add(int a, int b) {
//                return 0;
//            }
//
//            @Override
//            public int subtract(int a, int b) {
//                return 0;
//            }
//
//            @Override
//            public int multiply(int a, int b){
//                return a * b;
//            }
//        };
//
//        calculator.add(10, 20);
//
//
//        List<Integer> al = new ArrayList<>();



        /**
         * List --> 1. ArrayList
         *          2. LinkedList
         *
         * add()  --> ....
         *            ''''
         */
//
//        System.out.println(ac.subtract(1, 2));
//        System.out.println(bc.subtract(1, 2));
    }
}