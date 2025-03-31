import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

////        try {
//            C();
////        }catch (Exception e){
////            System.out.println("Inside main's catch block");
////        }
//        try {
//            String a = null;
//            System.out.println(a.toLowerCase()); // op A - conversion to lower case   op B - printing the converted string
////
////            String b = a.toLowerCase();
////            System.out.println(b);
//
//        }catch (Exception e){
//            System.out.println(e);
////            e.printStackTrace();
////            System.out.println("Some error occurred");
////            e.printStackTrace();
//
//            // suppressing the exception so that it won't go ahead to any other function
//        }
//        System.out.println("Something after the exception in try catch block");
        /**
         * Output
         *
         * Hello world!
         * java.lang.NullPointerException
         * 	at Main.main(Main.java:9)
         *
         * Process finished with exit code 0 - successfully completed, not aborted, normal execution
         */

//            String a = null;
//            a.toLowerCase();
//            System.out.println("Something after the exception in");

        /**
         * Hello world!
         * Exception in thread "main" java.lang.NullPointerException
         * 	at Main.main(Main.java:25)
         *
         * Process finished with exit code 1 - aborted due to some exception
         */


//        Main main;
////        A();
//        someFunction(1000000000, 10);
    }

    public static void someFunction(){
        try {
            int number = 1000000000;
            for (int i = 10; i >= 0; i--) {
                number /= i;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void someFunction(int number, int index){ // A'' , 10

        if(index < 0){
            System.out.println("Base case...");
            return;
        }

//        FileInputStream fileInputStream = new FileInputStream("abc.txt"); // mandatorily handle exception
//        int a = 1 / 0; // No need to mandatorily handle exception

        try {
//            FileInputStream fileInputStream = new FileInputStream("abc.txt");
//            int a = 2 + 3;
            int b = 2 / 0; // not able to do, they get an exception while doing that :
            int newNumber = number / index;
            index--;
            System.out.println("Inside someFunction: number = " + number + ", index = " + index);
            someFunction(newNumber, index);   // A' 9
        }catch (Throwable e){
            e.printStackTrace();
        }


    }

    public static void A(){
//        B();

        try{
            int a = 3 / 4;
            FileInputStream fileInputStream = new FileInputStream("/Users/piyush/Downloads/ouput000 (1).txt");
            String sql = "";

            String city = null;
            city.toLowerCase();
            // sql query operation
//            throw new SQLException();
        } catch (NullPointerException e){
            System.out.println("Null pointer exception");
            throw e;
        } catch (FileNotFoundException e){
            System.out.println("File is not found");
        } catch (ArithmeticException e){
            System.out.println("Arithmetic exception encountered");
            // suppressing it
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void B() throws IOException{

//        try{
//            System.out.println("Inside try block");
//            int a = 1 / 0;
//        }catch (ArithmeticException e){
//            System.out.println("Got arithmetic exception...");
//            e.printStackTrace();
//        }finally{  // optional
//            System.out.println("Inside finally");
//        }

        FileInputStream fileInputStream = null;
        try {
            int s = 1 / 0;

            fileInputStream = new FileInputStream("/Users/piyush/Downloads/output000 (1).txt");
            while (fileInputStream.read() != -1) {
                // ...
            }
        }catch (FileNotFoundException f){
            // suppressing here
        }catch (IOException e){
            // suppressing here
        }finally{
            System.out.println("Inside finally");
            fileInputStream.close();
        }
    }

    public static void C() throws FileNotFoundException {
        try {
            int a = 1 / 0; // Arithmetic exception
        }catch (ArithmeticException e){
            System.out.println("Inside C function's catch block");
            throw e; // throw new Exception()
        }finally{
            System.out.println("Inside finally");
            throw new FileNotFoundException(); // finally's exception overrides / suppresses the catch block's exception
//            System.exit(1);
        }

//        System.out.println("Inside function C, after try-catch-finally block");
    }

}