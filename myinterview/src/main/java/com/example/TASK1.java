package com.example;

/**
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * <p>
 * <p>
 * <p>
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
    public static void main(String[] args) {
        TASK1 task = new TASK1();

        checkAndPresent(task, "arara");
        checkAndPresent(task, "Socorram-me, subi no ônibus em Marrocos.");
        checkAndPresent(task, "Frase aleatória :)");
        checkAndPresent(task, "9873469");
        checkAndPresent(task, "123321");
    }

    public boolean isPalindrome(String characters) {
        String cleanCharacters = characters.toLowerCase().replaceAll("[^a-z0-9]", "");

        int start = 0;
        int end = cleanCharacters.length() - 1;

        while (start < end) {
            if (cleanCharacters.charAt(start) != cleanCharacters.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static void checkAndPresent(TASK1 task, String string) {
        System.out.println("'" + string + "'" + " is a palindrome: " + task.isPalindrome(string));
    }
}