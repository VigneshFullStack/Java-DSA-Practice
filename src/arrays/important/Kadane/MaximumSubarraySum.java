package arrays.important.Kadane;

/*
    Problem Statement :

    Given an integer array nums,
    find the contiguous subarray
    which has the largest sum
    and return that sum.

    Brute Force:
    - Generate all subarrays
    - Calculate sum for each
    - Track maximum sum

    Optimal:
    - Use Kadane’s Algorithm
*/

public class MaximumSubarraySum {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayBruteForce(arr1)); // 6

        // -------- Optimal (Kadane’s Algorithm) --------
        int[] arr2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArrayKadane(arr2)); // 6

        int[] arr3 = {-1, -2, -3};
        System.out.println(maxSubArrayKadane(arr3)); // -1

        int[] arr4 = null;
        System.out.println(maxSubArrayKadane(arr4)); // 0
    }

    // 🔴 Brute Force Approach
    public static int maxSubArrayBruteForce(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            int sum = 0;

            for(int j = i; j < arr.length; j++){
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // 🟢 Optimal Approach (Kadane’s Algorithm)
    public static int maxSubArrayKadane(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        int currentSum = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            
            // Either extend previous subarray or start new
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Track global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I check all possible subarrays and calculate their sums.
    I track the maximum sum found.
    This approach is correct but inefficient.”


    🧠 Interview Explanation (Optimal – Kadane’s Algorithm):

    “At each index, I decide whether to extend the existing subarray
    or start a new one.
    If the current sum becomes worse than the current element itself,
    I reset the sum.
    I track the maximum sum seen so far.”


    🧠 Key Insight:

    “A negative running sum will only reduce future subarray sums,
    so it is better to discard it.”


    🧠 Interview Explanation — Edge Case Handling:

    “I handle null or empty arrays upfront.
    If no valid subarray exists, the count naturally remains 0.”
*/


/*
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (Kadane’s Algorithm):
    Time  : O(n)
    Space : O(1)
*/