package main;

public class Main {

    int a;
    int b;

    static int c;

    public int add(){
        Main.c = 10;
        return this.a + this.b;
    }



    // attributes / variables
    // functions / methods

//    public main.Main(){
//        System.out.println("Inside default constructor");
//    }

    public Main(int aVar, int bVar){
        a = aVar; // this refers to the current object
        b = bVar;

        System.out.println(this.add());
    }

    public static void main(String[] args) {

        Main main = new Main(10, 20);
        int result = main.add();
        System.out.println(result);

        Video video = new Video();
        video.duration = 10;

    }
}