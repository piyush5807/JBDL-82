package abstract_classes;

public abstract class Student {

    public Student(){
        // do certain things
        System.out.println("Inside student constructor");
    }

    /**
     * You can define a non abstract method in an abstract class but vice versa is not true i.e
     * you can define an abstract function in a non-abstract class
     * @param name
     */

    public void printSurname(String surname){

    }

    public void printName(String name){
        System.out.println("Faculty name is - " + name);
    }

//    public abstract void printAge(int age);
}
