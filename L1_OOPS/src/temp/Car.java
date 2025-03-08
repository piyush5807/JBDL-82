package temp;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle{ // implicit inheritance always gets lower preference than the explicit one

//    public int calculateSpeed(){
//        // Custom logic is there for car speed calculation
//        return 0;
//    }
    Car(){
        System.out.println("Inside car constructor");
    }

    /**
     * Method overriding - the method name and signature should be same as that of parent class' method
     */


//    @Override
    public int getAvgSpeed() {
        return 60;
    }

    public double random(){
        return Math.random();
    }

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.trimToSize();

        List<Integer> al2 = new ArrayList<>(); // Third part library
        al2.add(20);
//        al2.trimToSize(); // different expectation as compared to a similar function in LinkedList
//
    }
}
