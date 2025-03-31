public class Parent {

    static int a = 10;

    public static void B(){

    }

    public void A(){
        System.out.println("Inside A of Parent");
    }

    public static void main(String[] args) {
        try{
            int a = 1 / 0;
        }catch (ArithmeticException e){
            e.printStackTrace();
        }finally {
            System.out.println("Inside finally");
        }
    }
}
