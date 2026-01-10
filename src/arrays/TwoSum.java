package arrays;

import java.util.Map;
import java.util.HashMap;

/*
    Problem Statement :

    Given an array arr[] of integers and another integer target.
    Determine if there exist two distinct indices such that the sum of their elements is equal to the target.
    Return true if such a pair exists, otherwise return false.
*/

public class TwoSum {
    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int target1 = -2;

        int[] arr2 = {1, -2, 1, 0, 5};
        int target2 = 0;

        int[] arr3 = {11};
        int target3 = 11;

        System.out.println(twoSum(arr1, target1)); // true
        System.out.println(twoSum(arr2, target2)); // false
        System.out.println(twoSum(arr3, target3)); // false
    }

    public static boolean twoSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int required = target - arr[i];

            // Check if complement already exists
            if(map.containsKey(required)){
                return true;
            }

            // Store current element with its index
            map.put(arr[i], i);
        }

        return false;
    }
}

/*
    🧠 Interview Explanation :

    “To check whether a pair exists with a given sum, I iterate through the array
    while storing previously seen elements in a HashMap.
    For each element, I compute the required complement (target - current value).
    If the complement already exists in the map, a valid pair is found.
    Using a HashMap allows constant-time lookups, ensuring an optimal solution.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
        - Single traversal of the array

    Space Complexity: O(n)
        - HashMap used to store elements
*/