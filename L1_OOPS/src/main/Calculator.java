package main;

public class Calculator {

    // Constructor is a void function with the name same as that of the enclosing class and is called on object creation
    Calculator(){
        System.out.println("Inside default constructor");
    }

    Calculator(int a, int b){
        System.out.println("Inside parameterized constructor: a = " + a + ", b = " + b);
    }

    Calculator(int a, int b, String c){
        System.out.println("Inside parameterized constructor: a = " + a + ", b = " + b + ", c = " + c);
    }

    public int add(int a, int b){
        return a + b;
    }

    public String add(String a, String b){ // method signature = number and type of arguments
        return a + b;
    }

    public long add(long a, long b){
        return a + b;
    }

    public String add(long a, String b){
        return String.valueOf(a) + String.valueOf(b);
    }

//    public void A(){
//        B();
//    }
//
//    public void B(){
//        C();
//    }
//
//    public void C(){
//        Calculator calculator = new Calculator();
//    }

    public static void main(String[] args) {
        Calculator a = new Calculator(); // allocate some memory on the heap (main memory)
//        System.out.println(a.add(10, 20));

        Calculator calculator = new Calculator(1, 2, "3");



//        a.add(10l, 20l);
//
////        System.out.println(a.add(100l, 200l));
//        System.out.println(a.add("100", "200")); // 100200



    }
}
