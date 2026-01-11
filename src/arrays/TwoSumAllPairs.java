package arrays;

import java.util.*;

/*
    Problem Statement :

    Given an unordered array arr[] and an integer target,
    return all pairs of indices (i, j) such that:

        arr[i] + arr[j] == target
        i < j
*/

public class TwoSumAllPairs {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15, -3, 9, 1, 12};
        int target = 9;

        System.out.println(twoSumAllPairs(arr, target));
        // Expected: [[0,1], [4,7]]
    }

    public static List<List<Integer>> twoSumAllPairs(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int required = target - arr[i];

            // If complement exists, form pairs
            if(map.containsKey(required)){
                for(int index : map.get(required)){
                    result.add(Arrays.asList(index, i));
                }
            }

            // Store current index
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        return result;
    }
}

/*
    🧠 Interview Explanation :

    “Since the array is unordered, I cannot use the two-pointer approach.
    Instead, I use a HashMap to store each number along with all its indices.

    While iterating through the array, for each element arr[i],
    I calculate the required value as target − arr[i].

    If the required value already exists in the map,
    then all stored indices of that value form valid pairs with index i.
    I add each such pair (previousIndex, i) to the result list.

    After processing the current element, I store its index in the map
    so it can be used for future pair matching.

    This ensures that:
    - All valid pairs are found
    - Each pair satisfies i < j
    - Duplicate values are handled correctly”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(n)
        - The array is traversed once
        - HashMap lookups and insertions are O(1) on average

    Space Complexity: O(n)
        - HashMap stores indices of elements seen so far
        - Result list stores all valid pairs
*/