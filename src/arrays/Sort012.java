package arrays;

/* 
    Problem Statement :

    Given an array arr[] containing only 0s, 1s, and 2s.
    Sort the array in ascending order without using any built-in sort function.
*/

public class Sort012 {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 0, 1, 2};
        int[] arr2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        sort012(arr1);
        sort012(arr2);

        printArray(arr1);
        printArray(arr2);
    }

    public static void sort012(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        
        while (mid <= high) {
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    “I use the Dutch National Flag algorithm with three pointers: low, mid, and high.
    The low pointer tracks the position for 0s, the high pointer tracks the position for 2s,
    and mid is used to traverse the array.
    Based on the value at mid, I swap elements to their correct positions.
    This sorts the array in one pass using constant extra space.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/