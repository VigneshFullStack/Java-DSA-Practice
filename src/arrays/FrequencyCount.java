package arrays;

import java.util.List;
import java.util.ArrayList;

/*
    Problem Statement :

    You are given an array arr[] of size n containing integers in the range 1 to n.
    Some numbers may be repeated or missing.

    Your task is to count the frequency of all numbers from 1 to n
    and return an array of size n where result[i] represents
    the frequency of number (i + 1).
*/

public class FrequencyCount {
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

        // Reduce each element by 1 (to make it 0-based)
        for(int i = 0; i < n; i++){
            arr[i]--;
        }

        // Use array indices to store frequency
        for(int i = 0; i < n; i++){
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Extract frequencies and Build result list
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            result.add(arr[i] / n);
        }

        return result;
    }
}

/*
    🧠 Interview Explanation :

    “Since array values are in the range 1 to n, I use the input array itself to store frequencies.
    I convert values to 0-based indexing, then increment the index corresponding to each value by n.
    Finally, dividing each element by n gives the frequency of that number.
    The result is returned as a list, which is allowed as output space.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
        - Three linear traversals

    Space Complexity: O(1)
        - Frequency stored in the input array itself
*/