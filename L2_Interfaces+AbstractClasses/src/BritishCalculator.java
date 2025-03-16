public class BritishCalculator implements Calculator{

//    public void run(){}

    public int multiply(int a, int b){
        return a * b + 1;
    }

    /**
     * Implement or override
     * You need to implement or override all the parent interface's abstract functions
     */

//    @Override
    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return Math.abs(a - b);
    }
}
