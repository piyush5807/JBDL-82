package object_class;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void createPersonMap(Person p1, Person p2){
        HashMap<Person, Boolean> map = new HashMap<>();

//        HashMap<Integer, Boolean> map2 = new HashMap<>();
//        Integer a1 = new Integer(1);
//        Integer a2 = new Integer(1);
//        map2.put(a1, true);
//        map2.put(a2, true);

//        people
//                .stream()
//                .forEach(p -> map.put(p, true));

        map.put(p2, false);
        map.put(p1, true);

        System.out.println(map);

        System.out.println(map.get(p1) + " " + map.get(p2));

//        System.out.println(people.get(0).equals(people.get(1)));
//        System.out.println(people.get(0).hashCode() + " " + people.get(1).hashCode());
//
//        map.get(people.get(0));
//
//        System.out.println(map);

    }

    public static void main(String[] args) throws Exception {

//        List<int>

        // diff b/w arrays -> contiguous  and list -> dynamic
        int[] numbers = {1, 2, 3, 4}; // A1 , A2 = A1 + 4, A3 = A2 +

        numbers[3] = 10; // O(1)

        List<Integer> al = Arrays.asList(1, 2, 3, 4);
        al.set(3, 4);

        Person p1 = new Person(10, "Jim", "Tyson");
        Person p2 = new Person(10, "Jim", "Ty");

        createPersonMap(p1, p2);

//        p1.hashCode();
//        p2.hashCode();
//
//        System.out.println(p1 + " " + p2);

//
//        boolean isEqual = p1 == p2; // addresses / memory references are different
//        System.out.println("== - " + isEqual);
//
//        isEqual = p1.equals(p2);
//        System.out.println("equals - " + isEqual);

//        Integer a = new Integer(10);
//
//        int b = 10; // float, double, boolean, long
//
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
//
//        System.out.println(numbers);

//        try {
//            Person person = new Person(-1, "Piyush", "Aggarwal");
//            person.getAge();
////        person.age = -1;
//            person.setAge(20);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
