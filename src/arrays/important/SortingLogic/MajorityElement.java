package arrays.important.SortingLogic;

import java.util.HashMap;
import java.util.Map;

/*
    Problem Statement :

    Given an integer array nums,
    find the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the majority element always exists.

    Brute Force:
    - Count frequency of each element

    Optimal:
    - Use Boyer–Moore Voting Algorithm
*/

public class MajorityElement {
    public static void main(String[] args) {
        
        // -------- Brute Force (HashMap) --------
        int[] arr1 = {2,2,1,1,1,2,2};
        System.out.println(majorityBruteForce(arr1)); // 2

        // -------- Optimal (Boyer–Moore) --------
        int[] arr2 = {2,2,1,1,1,2,2};
        System.out.println(majorityOptimal(arr2));    // 2

        int[] arr3 = {3,3,4};
        System.out.println(majorityOptimal(arr3));    // 3
    }

    // 🔴 Brute Force Approach (HashMap)
    public static int majorityBruteForce(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = arr.length;

        for(int key : map.keySet()){
            if(map.get(key) > n/2){
                return key;
            }
        }

        return -1;
    }

    // 🟢 Optimal Approach (Boyer–Moore Voting Algorithm)
    public static int majorityOptimal(int[] arr){

        // Edge case handling
        if(arr == null || arr.length == 0){
            return -1;
        }

        int candidate = arr[0];
        int count = 1;

        for(int i = 1; i < arr.length; i++){

            if(arr[i] == candidate){
                count++;
            } else {
                count--;
            }

            if(count == 0){
                candidate = arr[i];
                count = 1;
            }
        }

        return candidate;
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I count the frequency of each element using a HashMap.
    Then I return the element whose count exceeds n/2.
    This works but uses extra space.”


    🧠 Interview Explanation (Optimal – Boyer Moore):

    “Since the majority element appears more than n/2 times,
    every other element combined cannot cancel it out.
    I maintain a candidate and a count.
    If the current element matches the candidate, I increment count.
    Otherwise I decrement it.
    When count becomes zero, I choose a new candidate.
    At the end, the candidate is the majority element.”


    🧠 Key Insight:

    “Majority element survives cancellation because it appears
    more than all other elements combined.”


    🧠 Edge Case Handling:

    “If the array is null or empty, I return -1.”
*/


/*
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal (Boyer–Moore):
    Time  : O(n)
    Space : O(1)
*/