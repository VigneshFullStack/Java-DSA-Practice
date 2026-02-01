package arrays.important.PrefixSum;

import java.util.HashMap;

/*
    Problem Statement :

    Given an array of integers (can include negative numbers)
    and an integer K,
    find the length of the longest contiguous subarray
    whose sum equals K.

    Brute Force:
    - Generate all subarrays
    - Calculate sum for each
    - Track maximum length

    Optimal:
    - Use Prefix Sum + HashMap
    - Store first occurrence of each prefix sum
*/

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        
         // -------- Brute Force --------
         int[] arr1 = {1, -1, 5, -2, 3};
         System.out.println(longestSubArrayBruteForce(arr1, 3)); // 4

         // -------- Optimal (Prefix Sum + HashMap) --------
        int[] arr2 = {1, -1, 5, -2, 3};
        System.out.println(longestSubArrayOptimal(arr2, 3)); // 4

        int[] arr3 = {-2, -1, 2, 1};
        System.out.println(longestSubArrayOptimal(arr3, 1)); // 2

        int[] arr4 = null;
        System.out.println(longestSubArrayOptimal(arr4, 3)); // 0
    }

    // 🔴 Brute Force Approach
    public static int longestSubArrayBruteForce(int[] arr, int k){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxLength = 0;

        for(int start = 0; start < arr.length; start++){
            int sum = 0;

            for(int end = start; end < arr.length; end++){
                sum += arr[end];

                if(sum == k){
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }

        return maxLength;
    }

    // 🟢 Optimal Approach (Prefix Sum + HashMap)
    public static int longestSubArrayOptimal(int[] arr, int k){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        HashMap<Integer, Integer> prefixIndexMap = new HashMap<>();
        prefixIndexMap.put(0, -1);

        int prefixSum = 0;
        int maxLength = 0;

        for(int i = 0; i < arr.length; i++){
            prefixSum += arr[i];

            // Check if (prefixSum - k) exists
            if(prefixIndexMap.containsKey(prefixSum - k)){
                int length = i - prefixIndexMap.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }

            // Store prefix sum ONLY if not already present
            // (we want earliest index for maximum length)
            if(!prefixIndexMap.containsKey(prefixSum)){
                prefixIndexMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I generate all possible subarrays and calculate their sums.
    Whenever the sum equals K, I update the maximum length.
    This approach is straightforward but inefficient.”


    🧠 Interview Explanation (Optimal – Prefix Sum + HashMap):

    “I use prefix sum to track cumulative sums.
    At each index, I check if (currentPrefixSum - K)
    has appeared before.
    If it has, then a subarray ending at the current index
    sums to K.
    I calculate the length using the earliest index stored
    in the HashMap and update the maximum length.”


    🧠 Why store FIRST occurrence only?

    “Storing the earliest index gives the longest possible
    subarray when the same prefix sum appears again.”


    🧠 Why prefixIndexMap.put(0, -1)?

    “This handles subarrays that start from index 0
    when prefixSum itself equals K.”

    
    🧠 Interview Explanation — Edge Case Handling:

    “I handle null or empty arrays upfront.
    If no valid subarray exists, the count naturally remains 0.”
*/


/*
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (Prefix Sum + HashMap):
    Time  : O(n)
    Space : O(n)
*/