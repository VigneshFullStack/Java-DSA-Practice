package arrays.important.SlidingWindow;

/* 
    Problem Statement :
     
    Given an array arr[] of n integers and an integer k,
    find the average of all contiguous subarrays of size k.

    Brute Force:
    - For each subarray of size k
    - Calculate sum and average separately

    Optimal:
    - Use Fixed Sliding Window
    - Maintain running sum
*/

public class AverageOfSubarraysApproaches {
    public static void main(String[] args) {
        
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        // -------- Brute Force --------
        printResult(printAveragesBruteForce(arr, k));

        // -------- Optimal (Sliding Window) --------
        printResult(printAveragesOptimal(arr, k));
    }

    // 🔴 Brute Force Approach
    public static double[] printAveragesBruteForce(int[] arr, int k){

        // Edge case handling
        if(arr == null || k <= 0 || arr.length < k){
            return new double[0];
        }

        int resultSize = arr.length - k + 1;
        double[] result = new double[resultSize];

        for(int i = 0; i <= arr.length - k; i++){

            double sum = 0;

            for(int j = i; j < i + k; j++){
                sum += arr[j];
            }

            result[i] = sum / k;
        }

        return result;
    }

    // 🟢 Optimal Approach (Fixed Sliding Window)
    public static double[] printAveragesOptimal(int[] arr, int k){

        // Edge case handling
        if(arr == null || k <= 0 || arr.length < k){
            return new double[0];
        }

        int resultSize = arr.length - k + 1;
        double[] result = new double[resultSize];

        double windowSum = 0;
        int windowStart = 0;
        int index = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){

            windowSum += arr[windowEnd];

            // when window size reaches k
            if (windowEnd >= k - 1) {
                result[index++] = windowSum / k;

                // remove element going out of window
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return result;
    }

    public static void printResult(double[] arr){

        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I generate all contiguous subarrays of size k.
    For each subarray, I calculate the sum using a loop
    and then divide it by k to get the average.
    This approach is straightforward but involves repeated
    computation of overlapping elements.”


    🧠 Interview Explanation (Optimal – Fixed Sliding Window):

    “Instead of recalculating the sum for every subarray,
    I use a fixed sliding window of size k.
    As the window slides forward, I add the new element
    entering the window and remove the element leaving it.
    This allows me to compute each average in constant time.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle cases where the array is null, k is non-positive,
    or the array length is smaller than k.
    In these cases, no valid subarray exists, so I return early.”
*/

/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n * k)
    Space : O(n - k + 1)

    Optimal (Sliding Window):
    Time  : O(n)
    Space : O(n - k + 1)

    “The auxiliary space is O(1), but including the returned result array, 
    the overall space complexity is O(n − k + 1).”
*/