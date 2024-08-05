// Write a method to sort an array of string so that all the anagrams are next to each other.

import java.util.Arrays;

public class Q2 {
    public static void sortAnagrams(String[] arr) {
        Arrays.sort(arr, (s1, s2) -> canonicalForm(s1).compareTo(canonicalForm(s2)));
    }

    private static String canonicalForm(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] arr = {"cat", "dog", "tac", "god", "act", "odg"};
        sortAnagrams(arr);
        System.out.println(Arrays.toString(arr));
    }
}