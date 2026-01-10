package arrays;

import java.util.Map;
import java.util.HashMap;

/*
    Problem Statement :

    You are given an integer array arr[] and an integer target.
    Your task is to find two distinct indices i and j such that:

        arr[i] + arr[j] == target

    Return the indices as an integer array [i, j].
    If no such pair exists, return [-1, -1].
*/

public class TwoSumReturnIndices {
    public static void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] arr2 = {3, 3};
        int target2 = 6;

        int[] arr3 = {1, 2, 3};
        int target3 = 10;

        int[] result1 = twoSum(arr1, target1);
        int[] result2 = twoSum(arr2, target2);
        int[] result3 = twoSum(arr3, target3);

        System.out.println(result1[0] + ", " + result1[1]); // 0, 1
        System.out.println(result2[0] + ", " + result2[1]); // 0, 1
        System.out.println(result3[0] + ", " + result3[1]); // -1, -1
    }

    public static int[] twoSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int required = target - arr[i];

            // If complement exists, return indices
            if(map.containsKey(required)){
                return new int[]{ map.get(required), i };
            }

            // Store current element with its index
            map.put(arr[i], i);
        }
        
        return new int[]{-1, -1};
    }
}

/*
    🧠 Interview Explanation :

    “I iterate through the array while storing previously seen elements
    along with their indices in a HashMap.
    For each element, I calculate the complement needed to reach the target.
    If the complement already exists in the map, I return the stored index
    and the current index.
    This guarantees distinct indices and ensures an optimal solution.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
        - Single traversal of the array

    Space Complexity: O(n)
        - HashMap used to store values and indices
*/