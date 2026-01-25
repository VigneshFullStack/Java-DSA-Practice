package arrays.important;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers, reverse the array.
    
    Brute Force:
    - You may use extra space
    
    Optimal:
    - Reverse the array in-place
    - You are NOT allowed to use extra space
*/

public class ReverseArrayApproaches {
    public static void main(String[] args) {
        
         // -------- Brute Force --------
         int[] arr1 = {1, 2, 3, 4, 5};
         int[] reversed1 = reverseBruteForce(arr1);
         printArray(reversed1);   // 5 4 3 2 1
 
         // -------- Optimal --------
         int[] arr2 = {1, 2, 3, 4, 5};
         reverseOptimal(arr2);
         printArray(arr2);        // 5 4 3 2 1
 
         int[] arr3 = {10};
         reverseOptimal(arr3);
         printArray(arr3);        // 10
 
         int[] arr4 = {};
         reverseOptimal(arr4);
         printArray(arr4);        // empty
 
         int[] arr5 = null;
         reverseOptimal(arr5);    // safe, no crash
    }

    // 🔴 Brute Force (Extra Space)
    public static int[] reverseBruteForce(int[] arr){
        
        // Edge case: null or empty array
        if(arr == null || arr.length == 0){
            return arr;
        }

        int n = arr.length;
        int[] reversed = new int[n];

        for(int i = 0; i < n; i++){
            reversed[i] = arr[n - 1 - i];
        }

        return reversed;
    }

    // 🟢 Optimal (Two Pointers – In-place)
    public static void reverseOptimal(int[] arr){

        // Edge case handling
        if(arr == null || arr.length <= 1){
            return;
        }

        int left = 0; 
        int right = arr.length - 1;
        
        while(left < right){
            
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }

    public static void printArray(int[] arr){

        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I start with a simple brute-force approach.
    I create a new array of the same size and copy elements from the end of the original array
    to the beginning of the new array.
    This reverses the order of elements easily, but it uses extra space”


    🧠 Interview Explanation (Optimal Approach):

    “To optimize space, I use the two-pointer technique.
    One pointer starts at the beginning of the array and the other at the end.
    I swap the elements at these pointers and then move them towards each other.
    This continues until the pointers meet, which reverses the array in-place without using extra space.”


    🧠 Interview Explanation — Edge Case Handling (Bonus)

    “Before applying the logic, I handle edge cases such as null arrays, empty arrays, or single-element arrays.
    These cases don’t require any processing and returning early avoids unnecessary operations and runtime exceptions.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal:
    Time  : O(n)
    Space : O(1)
*/