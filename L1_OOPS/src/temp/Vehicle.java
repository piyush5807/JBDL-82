package temp;

public class Vehicle {

    private int speed;
    private int mileage;
    private int noOfTyres;


    private void pvtFunction(){
        System.out.println("Inside pvt function parent class");
    }

    public void publicFunction(){
        System.out.println("Inside public function parent class");
    }

    Vehicle(){
        System.out.println("Inside vehicle constructor");
    }

    public int getAvgSpeed(){
        // Some logic is there
        return 40;
    }

    public int getMileage(){
        // Some logic is there
        return 0;
    }
}
