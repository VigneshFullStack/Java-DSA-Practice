package arrays;

/* 
    Problem Statement :
     
    Given an array of integers nums, return the value of the largest element in the array
*/

public class LargestElement {
    public static void main(String[] args) {
        int[] nums = { 3, 3, 0, 99, -40 };
        System.out.println(largestElement(nums));  // 99
    }

    public static int largestElement(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array must not be empty");
        }

        int largest = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }

        return largest;
    }
}

/*
    🧠 Interview Explanation :

    “I initialize a variable largest with the first element of the array.
    Then I iterate through the array starting from the second element.
    For each element, I compare it with the current largest.
    If the current element is greater, I update largest.
    After traversing the entire array, largest will contain the maximum value.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n) 
        - We scan the array exactly once.
    Space Complexity: O(1)
        - Only one extra variable (largest) is used.
*/