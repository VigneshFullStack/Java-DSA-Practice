package arrays;

/*
    Problem Statement :

    Given an array arr[] with n elements, rotate the array to the left by k steps.

    Left rotation by k means:
    - The first k elements move to the end of the array
    - The remaining elements shift left

    Note:
    - k is non-negative
    - k can be greater than n
*/

public class LeftRotateArrayByK {
    public static void main(String[] args) {
        int[] arr1 = {7, 5, 2, 11, 2, 43, 1, 1};
        int k1 = 2;

        int[] arr2 = {5, 6, 7, 8};
        int k2 = 3;

        rotateLeft(arr1, k1);
        rotateLeft(arr2, k2);

        printArray(arr1); // 2 11 2 43 1 1 7 5
        printArray(arr2); // 8 5 6 7
    }

    public static void rotateLeft(int[] arr, int k){
        if (arr == null || arr.length == 0) return;

        int n = arr.length;

        // Normalize k
        k = k % n;
        if (k == 0) return;

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        // Reverse remaining elements
        reverse(arr, k, n - 1);

        // Reverse entire array
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int left, int right){
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void printArray(int[] arr){
        for(int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation :

    “To rotate an array left by k positions efficiently, I use the reversal algorithm.

    First, I normalize k using modulo to handle cases where k is greater than the array size.
    Then I reverse the first k elements, reverse the remaining elements, and finally reverse the entire array.

    This rearranges the elements into the desired rotated order while using constant extra space.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
        - Each element is reversed a constant number of times

    Space Complexity: O(1)
        - Rotation is done in-place
*/