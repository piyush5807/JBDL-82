package abstract_classes;

public abstract class Faculty {

    int age;

    public Faculty(){
        System.out.println("Inside faculty constructor");
    }


    public void printName(String name){
        System.out.println("Faculty name is - " + name);
    }

    public abstract void printAge(int age);

}
