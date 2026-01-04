package arrays;

/* 
    Problem Statement :
     
    Given an array, arr[] of n integers, and an integer element x, find whether element x is present in the array.
    Return the index of the first occurrence of x in the array, or -1 if it doesn't exist.
*/

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1, 7};

        System.out.println(search(arr, 7));   // Output: 2 (first occurrence)
        System.out.println(search(arr, 1));   // Output: 3
        System.out.println(search(arr, 10));  // Output: -1 (not present)
        System.out.println(search(arr, 5));   // Output: 0
    }

    public static int search(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;  // first occurrence
            }
        }

        return -1;  // not found
    }
}

/*
    🧠 Interview Explanation :

    “I traverse the array from left to right and compare each element with the target.
    If a match is found, I return its index immediately to ensure the first occurrence.
    If the traversal completes without a match, I return -1.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/