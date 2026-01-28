package arrays.important.SlidingWindow;

/* 
    Problem Statement :
     
    Given an array arr[] of n positive integers and an integer S,
    find the length of the smallest contiguous subarray
    whose sum is greater than or equal to S.

    If no such subarray exists, return 0.

    Brute Force:
    - Try all subarrays
    - Calculate sum for each

    Optimal:
    - Use Variable Size Sliding Window
*/

public class SmallestSubarrayWithSum {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {2, 1, 5, 2, 3, 2};
        System.out.println(findMinSubArrayBruteForce(arr1, 7)); // 2

        // -------- Optimal (Sliding Window) --------
        int[] arr2 = {2, 1, 5, 2, 3, 2};
        System.out.println(findMinSubArraySlidingWindow(arr2, 7)); // 2

        int[] arr3 = {1, 1, 1};
        System.out.println(findMinSubArraySlidingWindow(arr3, 5)); // 0

        int[] arr4 = null;
        System.out.println(findMinSubArraySlidingWindow(arr4, 7)); // 0
    }

    // 🔴 Brute Force Approach
    public static int findMinSubArrayBruteForce(int[] arr, int S){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        int minLength = Integer.MAX_VALUE;

        for(int start = 0; start < arr.length; start++){
            int sum = 0;

            for(int end = start; end < arr.length; end++){
                sum += arr[end];

                if(sum >= S){
                    minLength = Math.min(minLength, end - start + 1);
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    // 🟢 Optimal Approach (Variable Size Sliding Window)
    public static int findMinSubArraySlidingWindow(int[] arr, int S){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        int windowStart = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            
            // Expand window
            windowSum += arr[windowEnd];

            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I generate all possible subarrays using two loops.
    For each subarray, I calculate the sum and check if it
    is greater than or equal to S.
    Once the condition is satisfied, I update the minimum length.
    This approach is correct but inefficient due to repeated calculations.”


    🧠 Interview Explanation (Optimal Approach – Variable Sliding Window):

    “I use a variable-size sliding window.
    I expand the window by moving the end pointer and adding elements
    until the sum becomes greater than or equal to S.
    Then, I shrink the window from the start to find the smallest
    possible subarray that satisfies the condition.
    This ensures each element is processed at most twice.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle cases where the array is null or empty upfront.
    If no subarray satisfies the condition, I return 0 to indicate
    no valid subarray exists.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (Sliding Window):
    Time  : O(n)
    Space : O(1)
*/