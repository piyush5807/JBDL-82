public interface Calculator {

    /**
     * Class inherits from another class
     * Class implements an interface
     */

    /**
     * When you declare a function but not define it, it's known as abstract function
     * i.e function that doesn't have a body are known as abstract functions
     */

    /**
     *
     * Default or non-abstract functions in an interface are different than the default access / no access modifier
     */

    /**
     * In classes, whenever you define any variable or function, default access modifier gets attached to the variable / function
     * In interfaces, whenever you define any function, it's access modifier is public and you cannot change that
     */

     int add(int a, int b); // dead end

     int subtract(int a, int b);

     // functional interface
    default int multiply(int a, int b){
        return a * b;
    }
}
