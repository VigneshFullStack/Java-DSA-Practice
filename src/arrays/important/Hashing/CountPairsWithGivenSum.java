package arrays.important.Hashing;

import java.util.HashMap;
import java.util.Map;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers and an integer target,
    count the number of pairs (i, j) such that:

        arr[i] + arr[j] == target
        and i < j

    Brute Force:
    - Check all possible pairs
    - Count valid pairs

    Optimal:
    - Use HashMap (frequency map)
    - Works for UNSORTED array
*/

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {1, 5, 7, -1, 5};
        System.out.println(countPairsBruteForce(arr1, 6)); // 3


        // -------- Optimal (HashMap) --------
        int[] arr2 = {1, 5, 7, -1, 5};
        System.out.println(countPairsOptimal(arr2, 6));    // 3

        int[] arr3 = {1};
        System.out.println(countPairsOptimal(arr3, 2));    // 0

        int[] arr4 = null;
        System.out.println(countPairsOptimal(arr4, 6));    // 0
    }

    // 🔴 Brute Force Approach
    public static int countPairsBruteForce(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return 0;
        }

        int n = arr.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    count++;
                }
            }
        }

        return count;
    }

    // 🟢 Optimal Approach (HashMap – Frequency Count)
    public static int countPairsOptimal(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return 0;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for(int num : arr){

            int complement = target - num;

             // If complement already seen, add its frequency
            if(freqMap.containsKey(complement)){
                count += freqMap.get(complement);
            }

            // Update frequency of current number
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I check all possible index pairs using two nested loops.
    For each pair, I check if their sum equals the target.
    If yes, I increment the count.
    This guarantees correctness but is inefficient for large arrays.”


    🧠 Interview Explanation (Optimal Approach – HashMap):

    “To optimize, I use a HashMap to store the frequency
    of elements seen so far.
    For each element, I calculate the required complement.
    If the complement exists in the map, I add its frequency
    to the count.
    This ensures all valid index pairs are counted efficiently.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle edge cases such as null arrays or arrays
    with fewer than two elements upfront.
    These cases cannot form valid pairs, so returning early
    avoids unnecessary computation.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (HashMap):
    Time  : O(n)
    Space : O(n)
*/