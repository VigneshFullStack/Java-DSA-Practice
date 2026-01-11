package arrays;

import java.util.Arrays;

/*
    Problem Statement :

    Given an array arr[] of integers, determine whether it contains
    a triplet whose sum equals zero.

    Return true if such a triplet exists, otherwise return false.
*/

public class ThreeSumZero {
    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {-5, 3, 2, -1, 0, 1};

        System.out.println(hasTripletZero(arr1)); // true
        System.out.println(hasTripletZero(arr2)); // false
        System.out.println(hasTripletZero(arr3)); // true
    }

    public static boolean hasTripletZero(int[] arr){
        int n = arr.length;

        if(n < 3){
            return false;
        }

        Arrays.sort(arr);

        // Fix one element and apply two pointers
        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0){
                    return true;
                } else if(sum < 0){
                    left++;   // Need bigger sum
                } else {
                    right--;  // Need smaller sum
                }
            }
        }

        return false;
    }
}

/*
    🧠 Interview Explanation :

    “I sort the array first and fix one element.
    Then, using the two-pointer technique, I search for two numbers
    whose sum equals the negative of the fixed element.
    This optimizes the brute-force O(n³) solution to O(n²)
    while using constant extra space.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n²)
        - Sorting → O(n log n)
        - Outer loop → O(n)
        - Two pointers → O(n)

    Space Complexity: O(1)
        - No extra data structures used
*/