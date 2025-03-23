public class Main {
    final int a;

    final static int b;

    static int c = 60;

    final public static int NUMBER_OF_RETRIES = 3;

    static{
        b = 40;
    }

//    {
//        this.a = 30;
//    }

    public void print(){
        System.out.println(c + " " + b);
//        this.a = 500;  // Not allowed
        c = 700;
        System.out.println("b = " + b ) ;
//        b = 800;  // Not allowed

    }




    Main(int num){
        c = 60;
//        b = 50; // Not possible
        this.a = num;

//        this.a = 30;
    }

    public static void main(String[] args) {
//        System.out.println(Main.b); // not initialized exception
//        System.out.println("Hello world!");
        Main obj = new Main(10);
        Main obj2 = new Main(20);

        System.out.println(obj.a + " " + obj2.a);
//
//        // You need your variable to be assigned some value : Mandate
//
//        System.out.println(obj.a);
//
////        obj.a = 30;
//        System.out.println(obj.a);

//        System.out.println(Main.b + " " + Main.c);

        Main.c = 100;
//        Main.b = 200;

//        System.out.println(Main.b +  " " + Main.c);

    }
}