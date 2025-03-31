

public class TrywithResources {

    public static void main(String[] args) {

        try {
            useCursor();
        }catch (Exception e){
            if(e instanceof MyCustomException){
                System.out.println("My custom exception");
            }else if(e instanceof NumberTooLongException){
                System.out.println("Exception Thrown from close of cursor class");
            }else{
                e.printStackTrace();
            }
        }

//        try(FileInputStream fi = new FileInputStream("abc.txt")){
//            while(fi.read() != -1){
//                // do something here
//            }
//        }catch (FileNotFoundException e){
//            System.out.println("Inside file not found exception catch block");
//        }catch (IOException e){
//            System.out.println("Inside IO exception catch block");
//        }

        // ****************************************************

//        FileInputStream fi = null;
//        try{
//            fi = new FileInputStream("abc.txt");
//        }catch (FileNotFoundException e){
//
//        }catch (IOException e){
//
//        }finally {
//            fi.close();
//        }

//        try(Integer a = 10){
//            a /= 0;
//        }catch (Exception e){
//
//        }
    }

    public static void useCursor() throws Exception {

        /**
         * 1. a new object of cursor is created --- ? no exception thrown
         * 2. cursor.draw -- ? MyCustomException is thrown
         * 3. cursor.close() -- ? Exception
         */

        try(MyCursor cursor = new MyCursor(10)){
            cursor.draw(-4, 5);
        }catch (Exception e){
            System.out.println("Inside catch of use cursor...");
//            throw e;
        }


//        MyCursor cursor = null;
//        try{
//            cursor = new MyCursor(10);
//            cursor.draw(-4, 5);
//        }catch (Exception e){
//            System.out.println("Inside catch of use cursor...");
//            throw e;
//        }finally {
//            cursor.close();
//        }




    }
}
