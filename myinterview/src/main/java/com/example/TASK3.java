package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 */
public class TASK3 {
    public static void main(String[] args) {
        List<String> listAnimals = new ArrayList<>();
        listAnimals.add("urubu");
        listAnimals.add("macaco");
        listAnimals.add("arara");
        listAnimals.add("leão");
        listAnimals.add("lagarto");
        listAnimals.add("zebra");
        listAnimals.add("girafa");
        listAnimals.add("gato");
        listAnimals.add("zebra");
        listAnimals.add("urubu");

        System.out.println("Number of different items in the list: " + listAnimals.stream().distinct().count());
    }
}
