package abstract_classes;

public class Researcher extends Student{

    public Researcher(){
        System.out.println("Inside researcher constructor...");
    }


//    @Override
    public void printAge(int age) {
        System.out.println("Inside researcher class, age = " + age);
    }

    public void printAadhar(String aadhar){
        System.out.println("aadhar = " +  aadhar);
    }

    public static void main(String[] args) {


//        Researcher r = new Researcher();
//        r.printAge(10);
//        r.printName("Surya");

        /**
         * Parent ref = child instance
         * Parent ref = parent instance
         * child ref = child instance
         */

        /**
         * You cannot create instances of interfaces and abstract classes
         */

        // Anonymous inner class
        Faculty faculty = new Faculty() {
            @Override
            public void printAge(int age) {
                System.out.println("Inside anonymous inner class, age = " + age);
            }

        };
        faculty.printAge(10);
//
//        Faculty f1 = new Faculty() {
//            @Override
//            public void printAge(int age) {
//
//            }
//
//            @Override
//            public void printName(String name){
//
//            }
//        };
//
////        Faculty faculty1 = new Faculty() {};
////
////        faculty1.printAge(10);
//
//        Faculty faculty2 = new Faculty() {
//            @Override
//            public void printAge(int age) {
//                System.out.println("Inside anonymous inner class, age = " + age);
//            }
//
//            @Override
//            public void printName(String name) {
//                System.out.println("Inside printName of anonymous inner class.. name = " + name);
//            }
//
//            public void printUid(String uid){
//                System.out.println("Inside printUid of anonymous inner class.. uid = " + uid);
//            }
//        };

        // Parent ref = child instace
        // fn defined in the child but not present in the parent



//        Researcher r1 = new Researcher();
//        Researcher r2 = new Researcher();
//        r1.printAge(10);
//        r2.printAge(20);
//        r1.printAadhar("1234");

    }
}
