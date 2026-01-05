package arrays;

/* 
    Problem Statement :

    You are given an array arr[] of size n containing integers from 1 to n - 1.
    Each number appears exactly once except for one number which appears twice.
    Your task is to find and return the repeating number.
*/

public class FindRepeatingNumber {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 2, 2};
        int[] arr2 = {3, 1, 3, 4, 2};

        System.out.println(findRepeating(arr1)); // Output: 2
        System.out.println(findRepeating(arr2)); // Output: 3
    }

    public static int findRepeating(int[] arr){
        int n = arr.length;
        int xor = 0;

        // XOR all array elements
        for(int num : arr){
            xor ^= num;
        }

        // XOR numbers from 1 to n - 1
        for(int i = 1; i <= n - 1; i++){
            xor ^= i;
        }

        return xor;  // repeating number
    }
}

/*
    🧠 Interview Explanation :

    “I use the XOR operation because XOR of a number with itself becomes 0.
    I XOR all the elements in the array and then XOR all numbers from 1 to n - 1.
    All correctly occurring numbers cancel out, and the number that appears twice
    remains as the final result.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/