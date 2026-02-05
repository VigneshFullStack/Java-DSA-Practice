package arrays.important.SortingLogic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Problem Statement :

    Given two strings s and t,
    determine if t is an anagram of s.

    An anagram is formed by rearranging letters of another string
    using all original characters exactly once.

    Brute Force:
    - Convert both strings to char arrays
    - Sort them
    - Compare

    Optimal:
    - Use HashMap to count character frequency
*/

public class ValidAnagram {
    public static void main(String[] args) {
        
        // -------- Brute Force (Sorting) --------
        System.out.println(isAnagramSorting("anagram", "nagaram")); // true
        System.out.println(isAnagramSorting("rat", "car"));         // false

        // -------- Optimal (HashMap) --------
        System.out.println(isAnagramHashing("anagram", "nagaram")); // true
        System.out.println(isAnagramHashing("rat", "car"));         // false
    }

    // 🔴 Brute Force Approach (Sorting)
    public static boolean isAnagramSorting(String s, String t){

        // Edge case handling
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    // 🟢 Optimal Approach (HashMap)
    public static boolean isAnagramHashing(String s, String t){

        // Edge case handling
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        
        // Count characters in s
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrease counts using t
        for(char c : t.toCharArray()){

            if(!map.containsKey(c)){
                return false;
            }

            map.put(c, map.get(c) - 1);

            if(map.get(c) == 0){
                map.remove(c);
            }
        }

        return map.isEmpty();
    }
}

/*
    🧠 Interview Explanation (Sorting):

    “I convert both strings into character arrays,
    sort them, and compare.
    If both sorted arrays are equal, the strings are anagrams.
    This works because anagrams have identical characters
    in the same frequency.”


    🧠 Interview Explanation (Optimal – HashMap):

    “I use a HashMap to count character frequencies of the first string.
    Then I iterate over the second string and reduce the counts.
    If any character is missing or becomes negative, it’s not an anagram.
    Finally, if the map is empty, both strings are anagrams.”


    🧠 Edge Case Handling:

    “If either string is null or their lengths differ,
    I return false immediately because anagrams must have equal length.”
*/


/*
    ⏱ Complexity :

    Sorting Approach:
    Time  : O(n log n)
    Space : O(n)

    HashMap Approach:
    Time  : O(n)
    Space : O(n)
*/