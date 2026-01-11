package arrays;

import java.util.*;

/*
    Problem Statement :

    You are given an array arr[] of size n containing integers in the range 1 to n.
    Some numbers may be repeated or missing.

    Your task is to count the frequency of all numbers from 1 to n
    and return a list of size n where result[i] represents
    the frequency of number (i + 1).
*/

public class FrequencyCountUsingMap {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 2, 3, 5};
        int[] arr2 = {3, 3, 3, 3};
        int[] arr3 = {1};

        System.out.println(frequencyCount(arr1)); // [0, 2, 2, 0, 1]
        System.out.println(frequencyCount(arr2)); // [0, 0, 4, 0]
        System.out.println(frequencyCount(arr3)); // [1]
    }

    public static List<Integer> frequencyCount(int[] arr){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency using HashMap
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Build result for numbers 1 to n
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            result.add(map.getOrDefault(i, 0));
        }

        return result;
    }
}

/*
    🧠 Interview Explanation :

    “I use a HashMap to store the frequency of each number in the array.
    Then, I iterate from 1 to n and fetch the frequency from the map.
    If a number is missing, I return 0 for that position.
    This approach is simple and works even when the array cannot be modified.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
        - One pass to count frequencies
        - One pass to build the result

    Space Complexity: O(n)
        - HashMap used to store frequencies
*/