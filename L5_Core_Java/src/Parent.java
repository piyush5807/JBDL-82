public class Parent {

    int a;

    Parent(){
//        this.a = num;
    }

    public int sum(int a, int b){
        return a + b;
    }

    public int sum(int a){
        return a + 1;
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.a = 40;
    }
}
