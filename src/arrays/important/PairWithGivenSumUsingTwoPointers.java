package arrays.important;

/* 
    Problem Statement :
     
    Given a sorted array arr[] of integers and an integer target,
    find indices of two numbers such that their sum equals the target.
    If no such pair exists, return {-1, -1}.
*/

public class PairWithGivenSumUsingTwoPointers {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 6, 8, 9};

        int[] result = findPair(arr, 7);
        System.out.println(result[0] + ", " + result[1]); // Output: 0, 4 (1 + 6)
    }

    public static int[] findPair(int[] arr, int target){

        // edge case handling
        if(arr == null || arr.length < 2){
            return new int[]{ -1, -1 };
        }

        int left = 0;
        int right = arr.length - 1;
        
        while(left < right){

            long sum = (long) arr[left] + arr[right];

            if(sum == target){
                return new int[] { left, right };
            } else if(sum < target){
                left++;   // need bigger sum
            } else {
                right--;  // need smaller sum
            }
        }

        return new int[]{ -1, -1 }; // No pair found
    }
}

/*
    🧠 Interview Explanation :

    “I first handle edge cases like null or very small arrays.
    Since the array is sorted, I use two pointers.
    If the sum is smaller than the target, I move the left pointer.
    If the sum is larger, I move the right pointer.
    This ensures an optimal single-pass solution.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/