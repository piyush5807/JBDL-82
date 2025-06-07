package com.example.L18_apis;

import java.util.Arrays;
import java.util.List;

public class Test {

    private static void printAllCities(List<String> cities){
        for(int i = 0; i < cities.size(); i++){
            System.out.println(cities.get(i));
        }
    }

    private static void printAllCities(String... cities){
        for(String city: cities){
            System.out.println(city);
        }
    }

    public static void main(String[] args) {

//        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Chennai");
//        printAllCities(cities);
//
        printAllCities("Delhi", "Mumbai", "Chennai", "Ahmedabad", "Kolkata");

        int a = 1 / 0;

        System.out.println("Inside main function after exception...");

    }
}
