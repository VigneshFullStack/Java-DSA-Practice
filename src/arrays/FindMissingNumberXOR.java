package arrays;

/* 
    Problem Statement :

    You are given an array arr[] of size n - 1 that contains distinct integers
    in the range from 1 to n (inclusive).
    One number is missing. Find and return the missing number.
*/

public class FindMissingNumberXOR {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {8, 2, 4, 5, 3, 7, 1};
        int[] arr3 = {1};

        System.out.println(findMissing(arr1));   // Output: 4
        System.out.println(findMissing(arr2));   // Output: 6
        System.out.println(findMissing(arr3));   // Output: 2
    }

    public static int findMissing(int[] arr){
        int n = arr.length + 1;
        int xor = 0;

        // XOR all array elements
        for(int num : arr){
            xor ^= num;
        }

        // XOR numbers from 1 to n
        for(int i = 1; i <= n; i++){
            xor ^= i;
        }

        return xor;  // missing number
    }
}

/*
    🧠 Interview Explanation :

    “I use XOR because XOR of a number with itself becomes 0.
    All numbers from 1 to n appear once in the range,
    and all except the missing one appear in the array.
    After XOR-ing both, all matching numbers cancel out,
    leaving only the missing number.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/