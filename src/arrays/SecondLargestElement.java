package arrays;

/* 
    Problem Statement :
     
    Given an array of integers nums, return the second-largest element in the array.
    If the second-largest element does not exist, return -1.
    Note: nums may contain duplicate elements and negative values.
*/

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] nums1 = {8, 8, 7, 6, 5};
        System.out.println(secondLargestElement(nums1));  // 7

        int[] nums2 = {10, 10, 10, 10, 10};
        System.out.println(secondLargestElement(nums2));  // -1
    }

    public static int secondLargestElement(int[] arr){
        if(arr == null || arr.length < 2){
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int num : arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest){
                secondLargest = num;
            }
        }

        // If secondLargest was never updated
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }
}

/*
    🧠 Interview Explanation :

    “I iterate through the array once while tracking the largest and second largest values.
    When a new largest is found, the old largest becomes the second largest.
    Duplicates of the largest are ignored.
    If the second largest is never updated, I return -1.
    This runs in O(n) time and O(1) space.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/