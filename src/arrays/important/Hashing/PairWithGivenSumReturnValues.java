package arrays.important.Hashing;

import java.util.HashSet;
import java.util.Set;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers and an integer target,
    return the pair of values whose sum is equal to the target.

    Brute Force:
    - Check all possible pairs
    - Return the pair values

    Optimal:
    - Use HashSet
    - Works for UNSORTED array
*/

public class PairWithGivenSumReturnValues {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {2, 6, 5, 8, 11};
        printPair(pairBruteForce(arr1, 14));   // [6, 8]


        // -------- Optimal (HashSet) --------
        int[] arr2 = {2, 6, 5, 8, 11};
        printPair(pairOptimal(arr2, 14));      // [6, 8]

        int[] arr3 = {3};
        printPair(pairOptimal(arr3, 6));       // no pair

        int[] arr4 = null;
        printPair(pairOptimal(arr4, 10));      // no pair
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
                    return new int[]{ arr[i], arr[j] };
                }
            }
        }

        return new int[]{ -1, -1 };
    }

    // 🟢 Optimal Approach (HashSet – Unsorted Array)
    public static int[] pairOptimal(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return new int[]{ -1, -1 };
        }

        Set<Integer> seen = new HashSet<>();

        for(int num : arr){

            int complement = target - num;

            // If complement already seen, pair exists
            if(seen.contains(complement)){
                return new int[]{ complement, num };
            }

            // Store current element for future checks
            seen.add(num);
        }

        return new int[]{ -1, -1 };
    }

    public static void printPair(int[] pair){

        if(pair[0] == -1){
            System.out.println("No valid pair");
        } else {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I check every possible pair using two nested loops.
    If the sum of any pair matches the target,
    I immediately return the pair values.
    This approach is simple but inefficient for large inputs.”


    🧠 Interview Explanation (Optimal Approach – HashSet):

    “To optimize the solution for an unsorted array,
    I use a HashSet to keep track of elements seen so far.
    For each element, I calculate the required complement.
    If the complement already exists in the set,
    I return the pair values in constant time.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle edge cases such as null arrays
    or arrays with fewer than two elements upfront.
    These cases cannot form a valid pair,
    so returning early avoids unnecessary computation.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (HashSet):
    Time  : O(n)
    Space : O(n)
*/