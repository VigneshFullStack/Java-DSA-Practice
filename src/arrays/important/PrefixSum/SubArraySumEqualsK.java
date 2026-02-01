package arrays.important.PrefixSum;

import java.util.HashMap;

/*
    Problem Statement :

    Given an array of integers and an integer k,
    return the total number of continuous subarrays
    whose sum equals to k.

    Brute Force:
    - Generate all subarrays
    - Calculate sum for each

    Optimal:
    - Use Prefix Sum + HashMap
*/

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {1, 1, 1};
        System.out.println(subArraySumBruteForce(arr1, 2)); // 2

        // -------- Optimal (Prefix Sum + HashMap) --------
        int[] arr2 = {1, 2, 3};
        System.out.println(subArraySumOptimal(arr2, 3)); // 2

        int[] arr3 = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println(subArraySumOptimal(arr3, 7)); // 4

        int[] arr4 = null;
        System.out.println(subArraySumOptimal(arr4, 3)); // 0
    }

    // 🔴 Brute Force Approach
    public static int subArraySumBruteForce(int[] arr, int k){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        int count = 0;

        for(int start = 0; start < arr.length; start++){

            int sum = 0;

            for(int end = start; end < arr.length; end++){

                sum += arr[end];

                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    // 🟢 Optimal Approach (Prefix Sum + HashMap)
    public static int subArraySumOptimal(int[] arr, int k){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int num : arr){
            prefixSum += num;

            // Check if (prefixSum - k) exists
            if(prefixSumCount.containsKey(prefixSum - k)){
                count += prefixSumCount.get(prefixSum - k);
            }

            // Store/update prefix sum frequency
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I generate all possible subarrays using two nested loops.
    For each subarray, I calculate its sum and check
    whether it equals k.
    If it does, I increment the count.
    This approach is simple but inefficient due to repeated calculations.”


    🧠 Interview Explanation (Optimal Approach – Prefix Sum + HashMap):

    “I use a prefix sum to keep track of the cumulative sum.
    At each index, I check if (currentPrefixSum - k)
    has appeared before.
    If it has, it means there exists a subarray ending at
    the current index whose sum equals k.
    I use a HashMap to store the frequency of prefix sums
    for constant-time lookup.”


    🧠 Interview Explanation — Why prefixSumCount.put(0,1)?

    “This handles subarrays that start from index 0.
    If prefixSum itself becomes equal to k,
    (prefixSum - k) will be 0,
    and the map already contains it.”


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