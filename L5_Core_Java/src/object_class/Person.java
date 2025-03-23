package object_class;

import java.util.Objects;

public class Person {

    public static int function(){
        return -1;
    }

    private int age;
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, firstName);
    }

    //    @Override
//    public int hashCode() {
//        return Objects.hash(age, firstName, lastName);
//    }
//
//
//
//    @Override
//    public boolean equals(Object obj) {
//
//        if(obj != null){
//            Person p = (Person) obj;
//            if(p.firstName.equals(this.firstName)
//                    && p.lastName.equals(this.lastName)
//                    && p.age == this.age){
//                return true;
//            }
//        }
//
//        return false;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    Person(int age, String firstName, String lastName) throws Exception {
        if (age < 0) {
            throw new Exception("Invalid input");
        }

        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }


    // Getters and Setters
    public int getAge(){
        return this.age;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }


    // --------------- Setters ---------------

    public void setAge(int age){
        if(age < 0){
            return; // or throw some validation exception
        }
        this.age = age;
    }

    public void setFirstName(String firstName){
        if(firstName == null || firstName.length() == 0){
            return;
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }





}
