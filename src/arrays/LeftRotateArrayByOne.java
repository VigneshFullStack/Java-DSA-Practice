package arrays;

/* 
    Problem Statement :

    Given an array arr[], rotate the array by one position in left direction.

    Left rotation means:
    - The first element moves to the last position
    - All other elements are shifted one position to the left
*/

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {9, 8, 7, 6, 4, 2, 1, 3};

        rotateByOne(arr1);
        rotateByOne(arr2);

        printArray(arr1); // [2, 3, 4, 5, 1]
        printArray(arr2); // [8, 7, 6, 4, 2, 1, 3, 9]
    }

    public static void rotateByOne(int[] arr){
        int n = arr.length;
        int firstElement = arr[0];

        for(int i = 1; i < n; i++){
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = firstElement;
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

    “To rotate the array left by one position, I store the first element first.
    Then I shift all remaining elements one position to the left.
    Finally, I place the stored first element at the last index.

    This solution works in-place, uses constant extra space, and traverses the array only once.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
        - Single traversal to shift elements

    Space Complexity: O(1)
        - No extra data structures used
*/
