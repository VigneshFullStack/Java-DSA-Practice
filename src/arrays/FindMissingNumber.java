package arrays;

/* 
    Problem Statement :

    You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive).
    This array represents a permutation of the integers from 1 to n with one element missing.
    Your task is to identify and return the missing element.
*/

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {8, 2, 4, 5, 3, 7, 1};
        int[] arr3 = {1};

        System.out.println(findMissing(arr1));   // Output: 4
        System.out.println(findMissing(arr2));   // Output: 6
        System.out.println(findMissing(arr3));   // Output: 2
    }

    public static int findMissing(int[] arr){
        long n = (long) arr.length + 1;
        long expectedSum = n * (n + 1) / 2;
        long actualSum = 0;

        for(int num : arr){
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }
}

/*
    🧠 Interview Explanation :

    “I know that the sum of first n natural numbers is n*(n+1)/2. 
    If one number is missing, the difference between the expected sum and the actual sum of array elements gives the missing number.
    This approach ensures O(n) time and O(1) extra space, which is optimal.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)  → We traverse the array once to calculate the sum
    Space Complexity: O(1) → No extra data structures are used
*/