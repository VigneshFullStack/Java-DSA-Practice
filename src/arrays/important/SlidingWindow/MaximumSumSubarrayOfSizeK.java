package arrays.important.SlidingWindow;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers and an integer k,
    find the maximum sum of any contiguous subarray of size k.

    Brute Force:
    - Check sum of every subarray of size k
    - Recalculate sum each time

    Optimal:
    - Use Sliding Window technique
    - Reuse previous window sum
*/

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSumBruteForce(arr1, 3)); // 9


        // -------- Optimal (Sliding Window) --------
        int[] arr2 = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSumSlidingWindow(arr2, 3)); // 9

        int[] arr3 = {1};
        System.out.println(maxSumSlidingWindow(arr3, 1)); // 1

        int[] arr4 = null;
        System.out.println(maxSumSlidingWindow(arr4, 3)); // 0
    }

    // 🔴 Brute Force Approach
    public static int maxSumBruteForce(int[] arr, int k){

        // Edge case handling
        if(arr == null || arr.length < k || k <= 0){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;

        // Try every subarray of size k
        for(int i = 0; i <= arr.length - k; i++){
            int currentSum = 0;

            for(int j = i; j < i + k; j++){
                currentSum += arr[j];
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    
    // 🟢 Optimal Approach (Sliding Window)
    public static int maxSumSlidingWindow(int[] arr, int k){

        // Edge case handling
        if(arr == null || arr.length < k || k <= 0){
            return 0;
        }

        int windowSum = 0;
        int maxSum = 0;

        // Step 1: Calculate sum of first window
        for(int i = 0; i < k; i++){
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Step 2: Slide the window
        for(int end = k; end < arr.length; end++){
            windowSum += arr[end];      // add new element
            windowSum -= arr[end - k];  // remove old element

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I calculate the sum of every possible subarray of size k
    using nested loops.
    For each subarray, I compute the sum and track the maximum.
    While this guarantees correctness, it recalculates sums
    repeatedly and is inefficient.”


    🧠 Interview Explanation (Optimal Approach – Sliding Window):

    “Instead of recalculating sums, I use the sliding window technique.
    I first compute the sum of the first window of size k.
    Then I slide the window by one position:
    add the next element and remove the element leaving the window.
    This allows me to reuse previous calculations and achieve linear time.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle cases where the array is null, k is invalid,
    or the array size is smaller than k.
    These cases cannot form a valid window, so returning early
    avoids unnecessary computation and runtime errors.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n × k)
    Space : O(1)

    Optimal (Sliding Window):
    Time  : O(n)
    Space : O(1)
*/