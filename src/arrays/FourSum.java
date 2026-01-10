package arrays;

import java.util.*;

/*
    Problem Statement:

    Given an array nums of n integers, return all unique quadruplets
    [nums[a], nums[b], nums[c], nums[d]] such that:

        0 <= a, b, c, d < n
        a, b, c, and d are distinct
        nums[a] + nums[b] + nums[c] + nums[d] == target

    Return the answer in any order.
*/

public class FourSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        System.out.println(fourSum(nums1, target1)); // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        System.out.println(fourSum(nums2, target2)); // [[2, 2, 2, 2]]
    }

    public static List<List<Integer>> fourSum(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);

        // First loop for first element
        for(int i = 0; i < n - 3; i++){
            // Skip duplicates for first element
            if(i > 0 && arr[i] == arr[i - 1]) continue;

            // Second loop for second element
            for(int j = i + 1; j < n - 2; j++){
                // Skip duplicates for second element
                if(j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                // Two pointers for remaining two elements
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if(sum == target){
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));

                        left++;
                        right--;

                        // Skip duplicates for third element
                        while(left < right && arr[left] == arr[left - 1]) left++;
                        
                        // Skip duplicates for fourth element
                        while(left < right && arr[right] == arr[right + 1]) right--;
                    } else if(sum < target){
                        left++;   // Need bigger sum
                    } else {
                        right--;  // Need smaller sum
                    }
                }
            }
        }

        return result;
    }
}

/*
    🧠 Interview Explanation :

    “I first sort the array so that I can use the two-pointer technique.
    Then I fix the first two numbers using nested loops.
    For the remaining two numbers, I use two pointers — one starting from
    the left and one from the right.

    If the current sum is equal to the target, I store the quadruplet
    and move both pointers while skipping duplicates.
    If the sum is smaller than the target, I move the left pointer forward
    to increase the sum.
    If the sum is greater than the target, I move the right pointer backward
    to decrease the sum.

    By skipping duplicate elements at every step, I ensure that
    only unique quadruplets are returned.
    This approach reduces the brute-force O(n⁴) solution
    to an efficient O(n³) time solution using constant extra space.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n³)
        - Two nested loops (O(n²))
        - Two-pointer traversal inside (O(n))
        - Overall: O(n² × n)

    Space Complexity: O(1)
        - No extra data structures used
        - Output list is not counted as extra space
*/
