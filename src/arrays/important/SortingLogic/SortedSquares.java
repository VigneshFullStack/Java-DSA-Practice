package arrays.important.SortingLogic;

import java.util.Arrays;

/*
    Problem Statement :

    Given a sorted integer array nums (may contain negative numbers),
    return a new array of the squares of each number,
    also sorted in non-decreasing order.

    Brute Force:
    - Square every element
    - Sort the array

    Optimal:
    - Use Two Pointers
    - Compare absolute values from both ends
*/

public class SortedSquares {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {-4, -1, 0, 3, 10};
        printArray(sortedSquaresBruteForce(arr1)); // 0 1 9 16 100

        // -------- Optimal (Two Pointers) --------
        int[] arr2 = {-4, -1, 0, 3, 10};
        printArray(sortedSquaresOptimal(arr2));    // 0 1 9 16 100

        int[] arr3 = {-7, -3, 2, 3, 11};
        printArray(sortedSquaresOptimal(arr3));    // 4 9 9 49 121

        int[] arr4 = null;
        printArray(sortedSquaresOptimal(arr4));    // null
    }

    // 🔴 Brute Force Approach
    public static int[] sortedSquaresBruteForce(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return arr;
        }

        int[] result = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            result[i] = arr[i] * arr[i];
        }

        Arrays.sort(result);

        return result;
    }

    // 🟢 Optimal Approach (Two Pointers)
    public static int[] sortedSquaresOptimal(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return arr;
        }

        int n = arr.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if(leftSquare > rightSquare){
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }

        return result;
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
    🧠 Interview Explanation (Brute Force):

    “I square each element and then sort the resulting array.
    This works but sorting increases the time complexity.”


    🧠 Interview Explanation (Optimal – Two Pointers):

    “Because the input array is already sorted,
    the largest square must come from either end
    (largest positive or largest negative).
    I compare squares from both ends and fill the result array
    from the back.
    This avoids sorting and runs in linear time.”


    🧠 Edge Case Handling:

    “I handle null or empty arrays upfront.
    If the input has one element, its square is directly returned.”
*/


/*
    ⏱ Complexity :

    Brute Force:
    Time  : O(n log n)
    Space : O(n)

    Optimal:
    Time  : O(n)
    Space : O(n)
*/