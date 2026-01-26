package arrays.important.TwoPointers;

import java.util.Arrays;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers and an integer target,
    determine whether there exists a pair of elements
    whose sum is equal to the given target.
    
    Brute Force:
    - Check all possible pairs
    - No assumptions about array order
    
    Optimal:
    - Use Two Pointer technique
    - Array must be sorted
*/

public class PairWithGivenSumApproaches {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {2, 6, 5, 8, 11};
        int target1 = 14;
        System.out.println(hasPairBruteForce(arr1, target1));  // true

        int[] arr2 = {3};
        System.out.println(hasPairBruteForce(arr2, 6));  // false

        int[] arr3 = null;
        System.out.println(hasPairBruteForce(arr3, 10));  // false


        // -------- Optimal (Two Pointers) --------
        int[] arr4 = {2, 6, 5, 8, 11};
        int target2 = 14;
        System.out.println(hasPairOptimal(arr4, target2));  // true

        int[] arr5 = {};
        System.out.println(hasPairOptimal(arr5, 5));  // false
    }

    // 🔴 Brute Force Approach
    public static boolean hasPairBruteForce(int[] arr, int target){

        // edge case handling
        if(arr == null || arr.length < 2){
            return false;
        }

        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    return true;
                }
            }
        }

        return false;
    }

    // 🟢 Optimal Approach (Two Pointers)
    public static boolean hasPairOptimal(int[] arr, int targeet){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return false;
        }

        // Two pointers require sorted array
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while(left < right){

            int sum = arr[left] + arr[right];

            if(sum == targeet){
                return true;
            } else if(sum < targeet){
                left++;    // need bigger sum
            } else {
                right--;   // need smaller sum
            }
        }

        return false;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I start with a brute-force approach where I check all possible pairs
    in the array using two nested loops.
    For each pair, I calculate the sum and compare it with the target.
    If a matching pair is found, I return true.
    This approach is simple but inefficient for large inputs.”


    🧠 Interview Explanation (Optimal Approach):

    “To optimize the solution, I first sort the array.
    Then I use the two-pointer technique where one pointer starts at the
    beginning and the other at the end of the array.
    Based on the sum of the two elements, I move the pointers inward.
    This allows me to find the required pair in linear time after sorting.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “Before applying either approach, I handle edge cases such as
    null arrays or arrays with fewer than two elements.
    These cases cannot form a valid pair, so I return early
    to avoid unnecessary computation or runtime exceptions.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (Two Pointers):
    Time  : O(n log n)   // sorting dominates
    Space : O(1)
*/