package arrays;

/*
    Problem Statement :

    Given an array arr[] with n elements, rotate the array to the right by k steps.

    Left rotation by k means:
    - The last k elements move to the front of the array
    - The remaining elements shift to the right

    Note:
    - k is non-negative
    - k can be greater than n
*/

public class RightRotateByK {
    public static void main(String[] args) {
        int[] arr1 = {7, 5, 2, 11, 2, 43, 1, 1};
        int k1 = 2;

        int[] arr2 = {5, 6, 7, 8};
        int k2 = 3;

        rightRotateByK(arr1, k1);
        rightRotateByK(arr2, k2);

        printArray(arr1); // 1 1 7 5 2 11 2 43
        printArray(arr2); // 6 7 8 5
    }

    public static void rightRotateByK(int[] arr, int k){
        if(arr == null || arr.length == 0) return;

        int n = arr.length;
        k = k % n;  // handle k > n

        // Reverse entire array
        reverse(arr, 0, n - 1);

        // Reverse first k elements
        reverse(arr, 0, k - 1);

        // Reverse remaining n - k elements
        reverse(arr, k, n - 1);
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

    To rotate the array to the right by k positions,
    I use the reversal algorithm.

    First, I reverse the entire array.
    Then, I reverse the first k elements.
    Finally, I reverse the remaining elements.

    This achieves right rotation in-place without using extra space.
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
        - Each element is reversed a constant number of times
    Space Complexity: O(1)
        - Rotation is done in-place
*/