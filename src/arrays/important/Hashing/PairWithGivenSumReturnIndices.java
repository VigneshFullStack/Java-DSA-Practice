package arrays.important.Hashing;

import java.util.HashMap;
import java.util.Map;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers and an integer target,
    return the indices of the two elements such that
    their sum is equal to the target.

    Brute Force:
    - Check all possible pairs
    - Return indices when sum matches

    Optimal:
    - Use HashMap
    - Works for UNSORTED array
*/

public class PairWithGivenSumReturnIndices {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {2, 6, 5, 8, 11};
        printResult(pairBruteForce(arr1, 14)); // [1, 3]


        // -------- Optimal (HashMap) --------
        int[] arr2 = {2, 6, 5, 8, 11};
        printResult(pairOptimal(arr2, 14));    // [1, 3]

        int[] arr3 = {3};
        printResult(pairOptimal(arr3, 6));     // no pair

        int[] arr4 = null;
        printResult(pairOptimal(arr4, 10));    // no pair
    }

    // 🔴 Brute Force Approach
    public static int[] pairBruteForce(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return new int[]{ -1, -1 };
        }

        int n = arr.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{ i, j };
                }
            }
        }

        return new int[]{ -1, -1 };
    }

    // 🟢 Optimal Approach (HashMap – Unsorted Array)
    public static int[] pairOptimal(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return new int[]{ -1, -1 };
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){

            int complement = target - arr[i];

            // Check if complement already exists
            if(map.containsKey(complement)){
                return new int[]{ map.get(complement), i };
            }

            // Store current value with its index
            map.put(arr[i], i);
        }

        return new int[]{ -1, -1 };
    }

    public static void printResult(int[] result){

        if(result[0] == -1){
            System.out.println("No valid pair");
        } else {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I check all possible pairs using two nested loops.
    When the sum of a pair matches the target,
    I immediately return their indices.
    This approach is straightforward but inefficient for large arrays.”


    🧠 Interview Explanation (Optimal Approach – HashMap):

    “To optimize the solution for an unsorted array,
    I use a HashMap to store elements along with their indices.
    For each element, I calculate the required complement
    and check if it already exists in the map.
    If found, I return both indices in constant time.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle edge cases such as null arrays
    or arrays with fewer than two elements upfront.
    In such cases, returning immediately avoids
    unnecessary computation and runtime errors.”
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