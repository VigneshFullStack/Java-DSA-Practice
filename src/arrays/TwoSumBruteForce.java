package arrays;

/*
    Problem Statement :

    Given an integer array arr[] and an integer target,
    determine whether there exist two distinct indices i and j
    such that arr[i] + arr[j] == target.

    Constraint:
    - Auxiliary Space must be O(1)
*/

public class TwoSumBruteForce {
    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int target1 = -2;

        int[] arr2 = {1, -2, 1, 0, 5};
        int target2 = 0;

        System.out.println(twoSum(arr1, target1)); // true
        System.out.println(twoSum(arr2, target2)); // false
    }

    public static boolean twoSum(int[] arr, int target){
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
}

/*
    🧠 Interview Explanation :

    “To achieve constant auxiliary space, I use two nested loops to check every possible pair in the array.
    If any pair sums to the target, I return true.
    This avoids using extra data structures but increases time complexity.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n²)
        - All possible pairs are checked

    Space Complexity: O(1)
        - No extra data structures used
*/