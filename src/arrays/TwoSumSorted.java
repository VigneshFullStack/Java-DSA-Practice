package arrays;

import java.util.Arrays;

/*
    Problem Statement :

    You are given a sorted array of integers arr[] and a target value.
    Your task is to find the indices of two numbers such that
    their sum is equal to the target.

    Assumption:
    - The array is sorted in non-decreasing order
    - Exactly one valid pair exists

    Return the indices as an integer array of size 2.
*/

public class TwoSumSorted {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 6};
        int target1 = 6;

        int[] arr2 = {2, 5, 8, 12, 30};
        int target2 = 13;

        System.out.println(Arrays.toString(twoSum(arr1, target1))); // [1, 3]
        System.out.println(Arrays.toString(twoSum(arr2, target2))); // [1, 2]
    }

    public static int[] twoSum(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if(sum == target){
                return new int[]{ left, right };
            } else if (sum < target){
                left++;   // need bigger sum
            } else {
                right--;  // need smaller sum
            }
        }

        return new int[]{-1, -1};
    }
}

/*
    🧠 Interview Explanation :

    “Since the array is sorted, I use two pointers starting from both ends.
    If the sum is smaller, I move the left pointer; if larger, I move the right pointer.
    This guarantees an O(n) time and O(1) space solution.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
        - Each pointer moves at most n times
    Space Complexity: O(1)
        - No extra data structures used
*/