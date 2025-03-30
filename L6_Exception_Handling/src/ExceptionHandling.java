import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {

    public static void main(String[] args) throws FileNotFoundException {
        A();
    }

    public static void A() throws FileNotFoundException {
        B();
    }

    public static void B() throws FileNotFoundException{

        try{
            FileInputStream fileInputStream = new FileInputStream("abc.txt");
        }catch (FileNotFoundException e){
            throw e;
        }
    }
}
