package arrays.important.Hashing;

import java.util.HashSet;
import java.util.Set;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers and an integer target,
    determine whether there exists a pair of elements
    whose sum is equal to the given target.
    
    Brute Force:
    - Check all possible pairs
    - No assumptions about array order
    
    Optimal:
    - Use HashSet
    - Works for UNSORTED array
*/

public class PairWithGivenSumUsingHashSet {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {2, 6, 5, 8, 11};
        System.out.println(hasPairBruteForce(arr1, 14)); // true

        int[] arr2 = {3};
        System.out.println(hasPairBruteForce(arr2, 6));  // false


        // -------- Optimal (HashSet) --------
        int[] arr3 = {2, 6, 5, 8, 11};
        System.out.println(hasPairOptimal(arr3, 14));    // true

        int[] arr4 = {};
        System.out.println(hasPairOptimal(arr4, 5));     // false

        int[] arr5 = null;
        System.out.println(hasPairOptimal(arr5, 10));    // false
    }

    // 🔴 Brute Force Approach
    public static boolean hasPairBruteForce(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return false;
        }

        int n = arr.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] + arr[j] == target){
                    return true;
                }
            }
        }

        return false;
    }

    // 🟢 Optimal Approach (HashSet – Unsorted Array)
    public static boolean hasPairOptimal(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        for(int num : arr){

            int complement = target - num;

            // If complement already seen, pair exists
            if(seen.contains(complement)){
                return true;
            }

            // Store current element for future checks
            seen.add(num);
        }

        return false;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I check every possible pair using two nested loops.
    For each pair, I calculate the sum and compare it with the target.
    If any pair matches, I return true.
    This approach is simple but inefficient for large arrays.”


    🧠 Interview Explanation (Optimal Approach – HashSet):

    “To optimize the solution for an unsorted array,
    I use a HashSet to store elements I’ve already seen.
    For each element, I compute the required complement
    and check if it exists in the set.
    This allows me to find a valid pair in linear time.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle edge cases such as null arrays or arrays
    with fewer than two elements upfront.
    These cases cannot form a valid pair, so returning early
    prevents unnecessary processing and runtime errors.”
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