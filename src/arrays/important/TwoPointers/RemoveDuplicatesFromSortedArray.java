package arrays.important.TwoPointers;

import java.util.LinkedHashSet;
import java.util.Set;

/* 
    Problem Statement :
     
    Given a SORTED array arr[] of n integers,
    remove the duplicates IN-PLACE such that
    each unique element appears only once.

    Return the number of unique elements.

    Brute Force:
    - Use extra space (Set)
    - Copy unique elements back to array

    Optimal:
    - Use Two Pointers (Same Direction)
    - Modify array in-place
    - Do NOT use extra space
*/

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {1, 1, 2, 2, 3};
        int count1 = removeDuplicatesBruteForce(arr1);
        printArray(arr1, count1); // 1 2 3

        // -------- Optimal --------
        int[] arr2 = {1, 1, 2, 2, 3};
        int count2 = removeDuplicatesOptimal(arr2);
        printArray(arr2, count2); // 1 2 3

        int[] arr3 = {1};
        printArray(arr3, removeDuplicatesOptimal(arr3)); // 1

        int[] arr4 = {};
        printArray(arr4, removeDuplicatesOptimal(arr4)); // empty

        int[] arr5 = null;
        printArray(arr5, removeDuplicatesOptimal(arr5)); // null
    }

    // 🔴 Brute Force Approach (Extra Space)
    public static int removeDuplicatesBruteForce(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        Set<Integer> set = new LinkedHashSet<>();

        for(int num : arr){
            set.add(num);
        }

        int index = 0;
        for(int num : set){
            arr[index++] = num;
        }

        return set.size();
    }

    // 🟢 Optimal Approach (Two Pointers – Same Direction)
    public static int removeDuplicatesOptimal(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return 0;
        }

        int slow = 0;  // index of last unique element

        for(int fast = 1; fast < arr.length; fast++){
            if(arr[fast] != arr[slow]){
                slow++;
                arr[slow] = arr[fast];
            }
        }

        return slow + 1;
    }

    public static void printArray(int[] arr, int length) {

        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I use a HashSet to collect unique values.
    Then I copy them back to the array.
    This works but requires extra space.”


    🧠 Interview Explanation (Optimal):

    “Because the array is sorted, duplicates appear consecutively.
    I use two pointers:
    slow tracks the last unique element,
    fast scans the array.

    Whenever nums[fast] is different,
    I increment slow and overwrite its position.

    Finally, slow + 1 gives total unique count.”


    🧠 Edge Case Handling:

    “I return 0 for null or empty arrays.
    Single-element arrays naturally return 1.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal:
    Time  : O(n)
    Space : O(1)
*/