public class MyCustomRuntimeException extends RuntimeException{

    MyCustomRuntimeException(String message){
        super(message);
        System.out.println("Inside MyCustomRuntime exception: message = " + message);
    }

    MyCustomRuntimeException(){
        System.out.println("Inside MyCustomRuntime exception default constructor");
    }
}
