public class Child extends Parent{

    int a = 20;

//    public void B(){
//
//    }

    @Override
    public void A() {
        throw new ArithmeticException();
    }

//    public static void main(String[] args) throws MyCustomException, FileNotFoundException, IOException {
//
//        // There is a number given to you, you need to return a list of normalized length of cities:
//        // normalized length : number / len(city)  10 / 5 = 2
//
////        List<String> cities = Arrays.asList("delhi", "haryana", "bangalore", "");
//
//        List<FileInputStream> files = Arrays.asList(new FileInputStream("/Users/piyush/Downloads/L6_Exception_Handling/src/abc.txt"), new FileInputStream("/Users/piyush/Downloads/L6_Exception_Handling/src/def.txt"));
//
//        files.stream()
//                .forEach(x -> {
//                    try {
//                        x.read();
//                        throw new IOException();
//                    }catch (IOException e){
//                        System.out.println("error message: e = " + e.getMessage());
//                    }
//                });
//
//
////        try {
////            cities
////                    .stream()
////                    .mapToDouble(x -> 10 / x.length())
////                    .forEach(System.out::println);
////        }catch (Exception e){
////            e.printStackTrace();
////        }
//
////        Parent object = new Child();
////        object.A();
//    }
}
