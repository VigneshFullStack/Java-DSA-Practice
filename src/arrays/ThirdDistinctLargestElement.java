package arrays;

/* 
    Problem Statement :
     
    Given an array, arr of positive integers.
    Find the third DISTINCT largest element in it.
    Return -1 if the third distinct largest element is not found.
*/

public class ThirdDistinctLargestElement {
    public static void main(String[] args) {

        int[] nums1 = {2, 4, 1, 3, 5};
        System.out.println(thirdLargestDistinct(nums1));  // 3

        int[] nums2 = {10, 2};
        System.out.println(thirdLargestDistinct(nums2));  // -1

        int[] nums3 = {5, 5, 5};
        System.out.println(thirdLargestDistinct(nums3));  // -1

        int[] nums4 = {5, 4, 4, 3};
        System.out.println(thirdLargestDistinct(nums4));  // 3
    }

    public static int thirdLargestDistinct(int[] arr){
        if(arr == null || arr.length < 3){
            return -1;
        }

        Integer first = null;
        Integer second = null;
        Integer third = null;

        for(int num : arr){

            // Skip duplicate values
            if((first != null && num == first) ||
               (second != null && num == second) ||
               (third != null && num == third)){
                continue;
            }

            if(first == null || num > first){
                third = second;
                second = first;
                first = num;
            }
            else if(second == null || num > second){
                third = second;
                second = num;
            }
            else if(third == null || num > third){
                third = num;
            }
        }

        return third == null ? -1 : third;
    }
}

/*
    🧠 Interview Explanation :

    “I traverse the array once while maintaining the largest,
    second largest, and third largest DISTINCT values.
    I explicitly skip duplicates to ensure uniqueness.
    Whenever a larger distinct element is found, I shift the previous values.
    If fewer than three distinct elements exist, I return -1.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/