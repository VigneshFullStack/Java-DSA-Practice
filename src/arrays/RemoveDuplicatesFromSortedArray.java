package arrays;

/* 
    Problem Statement :
     
    Given a sorted integer array, remove the duplicate elements in-place such that each element appears only once.
    Return the length of the array after removing duplicates.

    Note:
        - Do not use extra space for another array.
        - Modify the given array in-place using O(1) extra memory.
*/

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 3, 3, 5, 6, 7};
        System.out.println(removeDuplicates(nums1));  // 5

        int[] nums2 = {-2, 2, 4, 4, 4, 4, 5, 5};
        System.out.println(removeDuplicates(nums2));  // 4
    }

    public static int removeDuplicates(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int i = 0;

        for(int j = 1; j < arr.length; j++){
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }

        return (i + 1);
    }
}

/*
    🧠 Interview Explanation :

    “Since the array is already sorted, duplicates will be adjacent.
    I use two pointers: one to track the position of unique elements and another to scan the array.
    Whenever a new unique value is found, I place it at the next position.
    This removes duplicates in-place using O(1) extra space.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/