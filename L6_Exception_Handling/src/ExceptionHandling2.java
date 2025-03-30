import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling2 {

    public static void main(String[] args) throws FileNotFoundException, CustomException {
        try {
            System.out.println("Inside main");
            A();
        }catch (FileNotFoundException e){
            throw e;

        }
    }

    public static void A() throws FileNotFoundException, CustomException {
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

    public static Integer B() throws FileNotFoundException, CustomException{

        try{
            System.out.println("Inside B");
            FileInputStream fileInputStream = new FileInputStream("abc.txt");
            throw new CustomException();
//            return -1;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw e;
        }catch (CustomException e){
            throw e;
        }
    }
}
