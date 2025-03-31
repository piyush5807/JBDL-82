public class MyCursor implements AutoCloseable{

    private int startIndex;

    @Override
    public void close() throws Exception {
        System.out.println("Inside close function of mycursor");

        // delete that file
        throw new NumberTooLongException();
    }

    public MyCursor() {
        this.startIndex = -1;
    }

    public MyCursor(int startIndex){
        this.startIndex = startIndex;
    }

    public void start(){
        System.out.println("Inside start fn");
    }

    public void draw(int start, int end) throws MyCustomException {
        if(start < 0 || end < start){
            throw new MyCustomException();
        }

        // do something....
    }
}
