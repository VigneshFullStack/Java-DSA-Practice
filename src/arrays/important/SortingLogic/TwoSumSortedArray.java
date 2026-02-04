package arrays.important.SortingLogic;

/*
    Problem Statement :

    Given a sorted integer array nums and an integer target,
    find TWO numbers such that they add up to target.

    Return true if such a pair exists, otherwise false.

    Brute Force:
    - Try all pairs using nested loops

    Optimal:
    - Use Two Pointers
*/

public class TwoSumSortedArray {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {1, 2, 3, 4, 6};
        System.out.println(twoSumBruteForce(arr1, 6)); // true

        // -------- Optimal (Two Pointers) --------
        int[] arr2 = {1, 2, 3, 4, 6};
        System.out.println(twoSumOptimal(arr2, 6)); // true

        int[] arr3 = {2, 5, 9, 11};
        System.out.println(twoSumOptimal(arr3, 10)); // false

        int[] arr4 = null;
        System.out.println(twoSumOptimal(arr4, 7)); // false
    }

    // 🔴 Brute Force Approach
    public static boolean twoSumBruteForce(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length <= 2){
            return false;
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    return true;
                }
            }
        }

        return false;
    }

    // 🟢 Optimal Approach (Two Pointers)
    public static boolean twoSumOptimal(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length <= 2){
            return false;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            
            int sum = arr[left] + arr[right];

            if(sum == target){
                return true;
            } else if (sum < target){
                left++;  // Need bigger sum
            } else {
                right--; // Need smaller sum
            }
        }

        return false;
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I check every possible pair using two loops.
    If any pair adds up to target, I return true.
    This works but is inefficient because it checks all combinations.”


    🧠 Interview Explanation (Optimal – Two Pointers):

    “Since the array is sorted, I place one pointer at the start
    and one at the end.

    I calculate their sum.

    - If sum equals target → return true.
    - If sum is smaller → move left pointer right to increase sum.
    - If sum is larger → move right pointer left to decrease sum.

    This way, I narrow down the search in linear time.”


    🧠 Key Insight:

    “Sorting gives order.
    Order allows two pointers.
    Two pointers eliminate nested loops.”


    🧠 Edge Case Handling:

    “If array is null or has less than two elements,
    I immediately return false.”
*/


/*
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (Two Pointers):
    Time  : O(n)
    Space : O(1)
*/