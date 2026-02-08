package arrays.important.TwoPointers;

/* 
    Problem Statement :
     
    Pair with given sum in a sorted array.

    Given a sorted integer array arr[] and an integer target,
    count the number of pairs (i, j) such that:

        arr[i] + arr[j] == target
        and i < j

    Note:
    - Array is already sorted
    - Pairs must be from distinct indexes
    - Duplicate values are allowed

    Brute Force:
    - Try all possible pairs

    Optimal:
    - Two Pointer Technique
    - Handles duplicates properly
*/

public class CountPairsWithGivenSumSorted {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        int[] arr1 = {-1, 1, 5, 5, 7};
        System.out.println(countPairsBruteForce(arr1, 6));  // 3

        // -------- Optimal (Two Pointer) --------
        System.out.println(countPairsOptimal(arr1, 6));   // 3

        int[] arr2 = {1, 1, 1, 1};
        System.out.println(countPairsOptimal(arr2, 2));   // 6

        int[] arr3 = {-1, 10, 10, 12, 15};
        System.out.println(countPairsOptimal(arr3, 125)); // 0
    }

    // 🔴 Brute Force Approach
    public static int countPairsBruteForce(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return 0;
        }

        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    count++;
                }
            }
        }

        return count;
    }

    // 🟢 Optimal Approach (Two Pointers)
    public static int countPairsOptimal(int[] arr, int target){

        // Edge case handling
        if(arr == null || arr.length < 2){
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            
            int sum = arr[left] + arr[right];

            if(sum == target){

                // both values same
                if(arr[left] == arr[right]){
                    int n = right - left + 1;
                    count += (n * (n - 1)) / 2;
                    break;
                }

                // count duplicates on left
                int leftVal = arr[left];
                int leftCount = 0;
                while (left <= right && arr[left] == leftVal) {
                    leftCount++;
                    left++;
                }

                // count duplicates on right
                int rightVal = arr[right];
                int rightCount = 0;
                while (left <= right && arr[right] == rightVal) {
                    rightCount++;
                    right--;
                }

                count += leftCount * rightCount;
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I check every possible pair using nested loops.
    If their sum equals target, I increment count.
    This works but takes O(n²) time.”



    🧠 Interview Explanation (Optimal – Two Pointers):

    “Since the array is already sorted, I use two pointers:
    one from start and one from end.

    If sum is smaller, I move left pointer.
    If sum is larger, I move right pointer.

    When sum matches:
    - I count duplicates on both sides.
    - Multiply their frequencies.
    - Add to result.

    If both pointers point to same value,
    I directly compute nC2.”



    🧠 Edge Case Handling:

    “If array is null or size < 2, return 0 immediately.”
*/


/*
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(1)

    Optimal (Two Pointer):
    Time  : O(n)
    Space : O(1)
*/