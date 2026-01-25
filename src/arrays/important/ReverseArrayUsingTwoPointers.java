package arrays.important;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers, reverse the array in-place.
    You are not allowed to use extra space for another array.
*/

public class ReverseArrayUsingTwoPointers {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        reverse(arr1);
        printArray(arr1);   // Output: 5 4 3 2 1

        int[] arr2 = {10};
        reverse(arr2);
        printArray(arr2);   // Output: 10

        int[] arr3 = {};
        reverse(arr3);
        printArray(arr3);   // Output: (empty)
    }

    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void printArray(int[] arr){
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation :

    “I use the two-pointer technique where one pointer starts from the beginning
    of the array and the other from the end. I swap the elements at these pointers
    and move them towards each other. This continues until the pointers meet.
    Since the array is modified in-place, no extra space is used.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/