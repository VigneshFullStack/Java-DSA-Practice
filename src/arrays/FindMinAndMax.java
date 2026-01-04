package arrays;

import java.util.ArrayList;

/* 
    Problem Statement :
     
    Given an array arr[]. Your task is to find the minimum and maximum elements in the array.
*/

public class FindMinAndMax {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 3, -5, -4, 8, 6};
        System.out.println(getMinMax(nums1));  // [-5, 8]

        int[] nums2 = {12, 3, 15, 7, 9};
        System.out.println(getMinMax(nums2));  // [3, 15]
    }

    public static ArrayList<Integer> getMinMax(int[] arr){

        ArrayList<Integer> result = new ArrayList<>();

        if(arr == null || arr.length == 0){
            return result;
        }

        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            } else if(arr[i] > max){
                max = arr[i];
            }
        }

        result.add(min);
        result.add(max);

        return result;
    }
}

/*
    🧠 Interview Explanation :

    “I initialize min and max with the first element and traverse the array once,
    updating them whenever a smaller or larger value is found.
    This handles negative and duplicate values efficiently in O(n) time.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/