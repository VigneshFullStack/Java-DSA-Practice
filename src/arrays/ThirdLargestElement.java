package arrays;

/* 
    Problem Statement :
     
    Given an array, arr of positive integers. Find the third largest element in it.
    Return -1 if the third largest element is not found.
*/

public class ThirdLargestElement {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 1, 3, 5};
        System.out.println(thirdLargest(nums1));  // 3

        int[] nums2 = {10, 2};
        System.out.println(thirdLargest(nums2));  // -1

        int[] nums3 = {5, 5, 5};
        System.out.println(thirdLargest(nums3));  // 5
    }

    public static int thirdLargest(int[] arr){
        if(arr == null || arr.length < 3){
            return -1;
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for(int num : arr){
            if(num >= first){
                third = second;
                second = first;
                first = num;
            } else if(num >= second){
                third = second;
                second = num;
            } else if(num >= third){
                third = num;
            }
        }

        return third;
    }
}

/*
    🧠 Interview Explanation :

    “I traverse the array once while maintaining the largest, second largest, and third largest values.
    Whenever a larger element is found, I shift the previous values accordingly.
    Since duplicates are allowed, equal values are also considered.
    If the array has fewer than three elements, I return -1.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/