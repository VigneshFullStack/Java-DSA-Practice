package arrays.important;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* 
    Problem Statement :
     
    Given an UNSORTED array arr[] of n integers,
    remove the duplicates such that each unique
    element appears only once.

    Return the number of unique elements.

    Brute Force:
    - Use HashSet
    - Order does NOT matter

    Better (Preserve Order):
    - Use LinkedHashSet
    - Maintains insertion order

    Note:
    - In-place removal is NOT possible for unsorted array
      without extra space.
*/

public class RemoveDuplicatesFromUnsortedArray {
    public static void main(String[] args) {
        
        // -------- Brute Force (HashSet) --------
        int[] arr1 = {4, 2, 1, 4, 2, 3};
        int count1 = removeDuplicatesUsingHashSet(arr1);
        printArray(arr1, count1); // order not guaranteed

        // -------- Better (LinkedHashSet – Preserve Order) --------
        int[] arr2 = {4, 2, 1, 4, 2, 3};
        int count2 = removeDuplicatesUsingLinkedHashSet(arr2);
        printArray(arr2, count2); // 4 2 1 3

        int[] arr3 = {1};
        printArray(arr3, removeDuplicatesUsingLinkedHashSet(arr3)); // 1

        int[] arr4 = {};
        printArray(arr4, removeDuplicatesUsingLinkedHashSet(arr4)); // empty

        int[] arr5 = null;
        printArray(arr5, removeDuplicatesUsingLinkedHashSet(arr5)); // null
    }

    // 🔴 Brute Force Approach (HashSet – Order NOT preserved)
    public static int removeDuplicatesUsingHashSet(int[] arr){

        // Edge case handling
        if(arr == null || arr.length <= 1){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            set.add(num);
        }

        int index = 0;
        for(int num : set){
            arr[index++] = num;
        }

        return set.size();
    }

    // 🟢 Better Approach (LinkedHashSet – Order preserved)
    public static int removeDuplicatesUsingLinkedHashSet(int[] arr){

        // Edge case handling
        if(arr == null || arr.length <= 1){
            return 0;
        }

        Set<Integer> set = new LinkedHashSet<>();

        for(int num : arr){
            set.add(num);
        }

        int index = 0;
        for(int num : set){
            arr[index++] = num;
        }

        return set.size();
    }

    public static void printArray(int[] arr, int length){

        if(arr == null){
            System.out.println("null");
            return;
        }

        for(int i = 0; i < length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation (HashSet):

    “Since the array is unsorted, duplicates are not adjacent.
    Two pointers will not work here.
    I use a HashSet to store unique elements in O(1) average time.
    This removes duplicates efficiently but does not preserve order.”


    🧠 Interview Explanation (LinkedHashSet – Preferred):

    “If the problem requires preserving the original order,
    I use a LinkedHashSet.
    It removes duplicates while maintaining insertion order.
    I then copy the unique elements back into the array.”


    🧠 Interview Explanation — Why No In-Place Solution:

    “For an unsorted array, removing duplicates in-place
    without extra space would require O(n²) time.
    Using hashing gives the optimal O(n) solution.”
*/

/* 
    ⏱ Complexity :

    HashSet:
    Time  : O(n)
    Space : O(n)

    LinkedHashSet:
    Time  : O(n)
    Space : O(n)
*/