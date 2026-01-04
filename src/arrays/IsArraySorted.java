package arrays;

/* 
    Problem Statement :
     
    Given an array, arr of positive integers. check whether the array is sorted in non-decreasing order.
    Return 1 if it is sorted, otherwise return 0.
*/

public class IsArraySorted {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(isArraySorted(nums1));  // 1

        int[] nums2 = {1, 2, 3, 5, 4};
        System.out.println(isArraySorted(nums2));  // 0

        int[] nums3 = {};
        System.out.println(isArraySorted(nums3));  // 0

        int[] nums4 = {7};
        System.out.println(isArraySorted(nums4));  // 1
    }

    public static int isArraySorted(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        if(arr.length == 1){
            return 1;
        }

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]){
                return 0;
            }
        }

        return 1;
    }
}

/*
    🧠 Interview Explanation :

    “I iterate through the array once and compare each element with its previous one.
    If I find any element smaller than the previous, the array is not sorted.
    Single-element arrays are always sorted.
    I explicitly handle empty or null arrays as invalid input and return 0.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/