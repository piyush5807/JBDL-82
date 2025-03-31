import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling2 {

    // Exception e = new MyCustomException();
    // Exception e = new NumberTooLongException();

    public static void main(String[] args)  {
        System.out.println("Inside main");

        try {
            D(-90);
        }catch (Exception e){
            if(e instanceof NegativeNumberException)
                System.out.println("Inside main: number is negative");
            else if(e instanceof NumberTooLongException)
                System.out.println("Inside main: number is too long");
            else if(e instanceof MyCustomRuntimeException)
                System.out.println("Some error occured during runtime");
            else
                e.printStackTrace();
        }

        try {
            D(-90);
        }catch (NegativeNumberException e) {
            System.out.println("Inside main: number is negative");
        }catch (NumberTooLongException e) {
            System.out.println("Inside main: number is too long");
        }catch (MyCustomRuntimeException e) {
            System.out.println("Some error occured during runtime");
        }catch (Exception e){
                e.printStackTrace();
        }

//            try{
//                C(-80);
//            }catch (MyCustomRuntimeException e){
//                e.printStackTrace();
//            }
    }

    public static void A() throws FileNotFoundException, NegativeNumberException {
        try {
            System.out.println("Inside A");
            int result = B();
            //...
            // error
        }catch (FileNotFoundException e){
            System.out.println("Inside A, received error, msg - " + e.getMessage());
            throw e;
        }
    }

    public static Integer B() throws FileNotFoundException, NegativeNumberException {

        try{
            System.out.println("Inside B");
            FileInputStream fileInputStream = new FileInputStream("abc.txt");
            throw new NegativeNumberException();
//            return -1;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw e;
        }catch (NegativeNumberException e){
            throw e;
        }
    }

    public static void C(int number){

//        try{
            if(number < 0){
                throw new MyCustomRuntimeException();
            }
//        }catch (MyCustomRuntimeException e){
//            e.printStackTrace();
//        }
    }

    public static void D(int number) throws NegativeNumberException, NumberTooLongException {

        if(number < 0){
            throw new NegativeNumberException("Number is not positive");
        }else if (number > 1000){
            throw new NumberTooLongException();
        }

//        System.out.println("Inside D: doing something");
    }
}
