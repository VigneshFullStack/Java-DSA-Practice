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
        boolean foundSecond = false;

        for(int num : arr){
            if(num > largest){
                if (largest != Integer.MIN_VALUE) {
                    secondLargest = largest;
                    foundSecond = true;
                }
                largest = num;
            } else if (num < largest && num > secondLargest){
                secondLargest = num;
                foundSecond = true;
            }
        }

        return foundSecond ? secondLargest : -1;
    }
}

/*
    🧠 Interview Explanation :

    “I traverse the array once while tracking the largest and second-largest elements.
    To safely handle negative values, I initialize both with Integer.MIN_VALUE.
    I update a boolean flag only when a valid distinct second-largest value is found,
    and if no such value exists after traversal, I return -1.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/