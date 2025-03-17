@FunctionalInterface
public interface Operations<T> extends Runnable {

//    int add(int a, int b);

    default int subtract(int a, int b){
        return a - b;
    }

    default int multiply(int a, int b){
        return a * b;
    }

    void print();

    default void run(){}
}
