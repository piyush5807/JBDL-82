package test;

public class Researcher extends Human implements Faculty, Student{

    // multiple inheritance is not possible for interfaces in scenarios where there are
    // default fns with the same name in different parent interfaces

    // Functional interfaces --> Lambdas --> Streams

    /**
     * printName --> Human
     * printName --> Faculty
     */

    public static int print(){
        return 0;
    }

//    public void printName(String name){
//        Faculty.super.printName(name);
//    }



    public void print(int age, String name, String surname){

        Faculty.super.printAge(age);
        Faculty.super.printName(name);
        Faculty.printSurname(surname);

    }

    public static void main(String[] args) {

        Faculty faculty = new Faculty() {{
            System.out.println("Anonymous inner class.");
        }};

        faculty.printAge(10);


//        Researcher researcher = new Researcher();
//        researcher.print(10, "ABC", "DEF");
//        researcher.printName("Piyush");
//        Faculty.printSurname("Aggarwal");
    }
}
