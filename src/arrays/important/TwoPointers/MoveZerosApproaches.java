package arrays.important.TwoPointers;

/* 
    Problem Statement :
     
    Given an integer array nums,
    move all zeros to the end of the array
    while maintaining the relative order of non-zero elements.

    You must do this in-place.

    Brute Force:
    - Create a new array
    - Copy non-zero elements first
    - Fill remaining with zeros

    Optimal:
    - Use Two Pointers (Overwrite Technique)
*/

public class MoveZerosApproaches {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {0, 1, 0, 3, 12};
        int[] result1 = moveZerosBruteForce(arr1);
        printArray(result1);   // 1 3 12 0 0

        // -------- Optimal --------
        int[] arr2 = {0, 1, 0, 3, 12};
        moveZerosOptimal(arr2);
        printArray(arr2);     // 1 3 12 0 0

        int[] arr3 = {0};
        moveZerosOptimal(arr3);
        printArray(arr3);     // 0

        int[] arr4 = {};
        moveZerosOptimal(arr4);
        printArray(arr4);     // empty

        int[] arr5 = null;
        moveZerosOptimal(arr5);   // safe
    }

    // 🔴 Brute Force (Extra Space)
    public static int[] moveZerosBruteForce(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return arr;
        }

        int n = arr.length;
        int[] result = new int[n];

        int insertPosition = 0;

        // Copy non-zero elements
        for(int num : arr){
            if(num != 0){
                result[insertPosition++] = num;
            }
        }

        // Remaining positions automatically filled with zero
        return result;
    }

    // 🟢 Optimal (Two Pointers – Overwrite)
    public static void moveZerosOptimal(int[] arr){

        // Edge case handling
        if(arr == null || arr.length <= 1){
            return;
        }

        int insertPosition = 0;

        // Move all non-zero values forward
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[insertPosition++] = arr[i];
            }
        }

        // Fill remaining with zeros
        while (insertPosition < arr.length) {
            arr[insertPosition++] = 0;
        }
    }

    public static void printArray(int[] arr){

        if(arr == null){
            System.out.println("null");
            return;
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I create a new array and first copy all non-zero elements.
    After that, I fill the remaining positions with zeros.
    This preserves order but uses extra space.”


    🧠 Interview Explanation (Optimal Approach):

    “To avoid extra space, I use two pointers.
    One pointer tracks where the next non-zero element should go.
    I iterate through the array and overwrite elements in-place.
    After placing all non-zero values, I fill the remaining positions with zeros.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle null, empty, or single-element arrays upfront.
    These cases do not require processing and returning early avoids errors.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal (Two Pointers):
    Time  : O(n)
    Space : O(1)
*/