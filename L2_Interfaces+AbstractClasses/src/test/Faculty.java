package test;

public interface Faculty extends Runnable{

    default void printName(String name){
        System.out.println("Faculty name is " + name);
    }

    default void printAge(int age){
        System.out.println("Faculty's age is " + age);
    }

    static void printSurname(String name){
        System.out.println("Faculty name is " + name);
    }

    default void run(){
        System.out.println("Run function in Faculty interface");
    }


}
