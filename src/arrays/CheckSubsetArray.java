package arrays;

import java.util.Map;
import java.util.HashMap;

/*
    Problem Statement :

    Given two arrays a[] and b[], determine whether b[] is a subset of a[].

    An array b[] is a subset of a[] if:
    - Every element in b[] exists in a[]
    - Frequency of each element in b[] is less than or equal to its frequency in a[]

    Order does not matter.
*/

public class CheckSubsetArray {
    public static void main(String[] args) {
        int[] a1 = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b1 = {11, 3, 7, 1, 7};

        int[] a2 = {1, 2, 3, 4, 4, 5, 6};
        int[] b2 = {1, 2, 4};

        int[] a3 = {10, 5, 2, 23, 19};
        int[] b3 = {19, 5, 3};

        System.out.println(isSubset(a1, b1)); // true
        System.out.println(isSubset(a2, b2)); // true
        System.out.println(isSubset(a3, b3)); // false
    }

    public static boolean isSubset(int[] a, int[] b){
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies of elements in array a
        for(int num : a){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check elements of array b
        for(int num : b){
            if(!freqMap.containsKey(num) || freqMap.get(num) == 0){
                return false;  // element missing or insufficient frequency
            }

            freqMap.put(num, freqMap.get(num) - 1);
        }

        return true;
    }
}

/*
    🧠 Interview Explanation :

    “To check if one array is a subset of another, I use a frequency map.
    First, I store the count of each element in the main array.
    Then, for every element in the subset array, I check its availability and reduce the count.
    If any element is missing or overused, I return false.
    If all checks pass, the array is a subset.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n + m)
        n → size of array a
        m → size of array b
    Space Complexity: O(n)
        HashMap stores frequencies of array a
*/