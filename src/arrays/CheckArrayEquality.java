package arrays;

import java.util.Map;
import java.util.HashMap;

/* 
    Problem Statement :

    Given two arrays a[] and b[] of equal size, determine whether both arrays
    contain the same elements with the same frequencies.

    The order of elements does NOT matter.
    If an element appears multiple times in one array,
    it must appear the same number of times in the other array.

    Return true if both arrays are equal, otherwise return false.
*/

public class CheckArrayEquality {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 5, 4, 0};
        int[] b1 = {2, 4, 5, 0, 1};

        int[] a2 = {1, 2, 5};
        int[] b2 = {2, 4, 15};

        System.out.println(areArraysEqual(a1, b1)); // true
        System.out.println(areArraysEqual(a2, b2)); // false
    }

    public static boolean areArraysEqual(int[] a, int[] b){
        // If sizes differ, arrays cannot be equal
        if(a.length != b.length){
            return false;
        }

        // Create a frequency map for array a
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Reduce frequency using array b
        for(int num : b) {
            if(!freqMap.containsKey(num)){
                return false;  // element not present in a
            }

            freqMap.put(num, freqMap.get(num) - 1);

            if(freqMap.get(num) == 0){
                freqMap.remove(num);
            }
        }

        // If map is empty, arrays are equal
        return freqMap.isEmpty();
    }
}

/*
    🧠 Interview Explanation :

    “Since the order of elements does not matter, I compare the frequency of each element in both arrays.

    I first count the occurrences of each element in the first array using a HashMap.
    Then I traverse the second array and decrement the corresponding frequencies.

    If at any point an element is missing or a frequency becomes negative, the arrays are not equal.
    Finally, if all frequencies cancel out and the map becomes empty, the arrays are equal.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
        - One traversal for array a
        - One traversal for array b

    Space Complexity: O(n)
        - HashMap stores frequencies of elements
*/