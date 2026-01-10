package arrays;

import java.util.Arrays;

/*
    Problem Statement :

    Given an array arr[] and an integer target, determine if there exists
    a triplet in the array whose sum equals the given target.

    Return true if such a triplet exists, otherwise return false.
*/

public class TripletSum {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        int target1 = 13;

        int[] arr2 = {1, 2, 4, 3, 6, 7};
        int target2 = 10;

        int[] arr3 = {40, 20, 10, 3, 6, 7};
        int target3 = 24;

        System.out.println(hasTriplet(arr1, target1)); // true
        System.out.println(hasTriplet(arr2, target2)); // true
        System.out.println(hasTriplet(arr3, target3)); // false
    }

    public static boolean hasTriplet(int[] arr, int target){
        int n = arr.length;

        Arrays.sort(arr);

        // Fix one element and apply two pointers
        for(int i = 0; i < n - 2; i++){

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == target){
                    return true;
                } else if(sum < target){
                    left++;   // need bigger sum
                } else {
                    right--;  // need smaller sum
                }
            }
        }

        return false;
    }
}

/*
    🧠 Interview Explanation :

    “I first sort the array and then fix one element.
    For the remaining part, I apply the two-pointer technique to find if a pair exists whose sum equals target − fixedElement.
    This reduces the brute-force O(n³) approach to O(n²) time with constant extra space.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n²)
        - Outer loop → O(n)
        - Two pointers inside → O(n)

    Space Complexity: O(1)
        - No extra data structures used
*/