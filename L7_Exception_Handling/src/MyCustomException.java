public class MyCustomException extends Exception{

    MyCustomException(String message){
        super(message);
        System.out.println("Inside MyCustom exception: message = " + message);
    }

    MyCustomException(){
        System.out.println("Inside MyCustom exception default constructor");
    }
}
