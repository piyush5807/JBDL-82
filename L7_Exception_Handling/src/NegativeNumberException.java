public class NegativeNumberException extends Exception{

    NegativeNumberException(){
        System.out.println("Inside default constructor");
    }

    NegativeNumberException(String message){
        super(message);
        System.out.println("Inside parametrized constructor: message = " +  message);
    }
}
