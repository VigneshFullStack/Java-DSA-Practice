package arrays;

/* 
    Problem Statement :

    Given an array arr[], rotate the array by one position in clockwise direction.

    Clockwise rotation means:
    - The last element moves to the first position
    - All other elements are shifted one position to the right
*/

public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {9, 8, 7, 6, 4, 2, 1, 3};

        rotateByOne(arr1);
        rotateByOne(arr2);

        printArray(arr1); // [5, 1, 2, 3, 4]
        printArray(arr2); // [3, 9, 8, 7, 6, 4, 2, 1]
    }

    public static void rotateByOne(int[] arr){
        int n = arr.length;
        int lastElement = arr[n - 1];

        for(int i = n - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;
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

    “To rotate the array clockwise by one position, I store the last element first.
    Then I shift all remaining elements one position to the right.
    Finally, I place the stored last element at the first index.

    This solution works in-place, uses constant extra space, and traverses the array only once.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
        - Single traversal to shift elements

    Space Complexity: O(1)
        - No extra data structures used
*/