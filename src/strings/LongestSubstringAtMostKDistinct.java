package strings;

import java.util.HashMap;
import java.util.Map;

/* 
    Problem Statement :
     
    Given a string s and an integer k,
    find the length of the longest substring
    that contains at most k distinct characters.

    Brute Force:
    - Generate all substrings
    - Count distinct characters for each

    Optimal:
    - Variable Sliding Window
    - Use HashMap to track character frequency
*/

public class LongestSubstringAtMostKDistinct {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        System.out.println(longestSubstringBruteForce("eceba", 2)); // 3

        // -------- Optimal --------
        System.out.println(longestSubstringOptimal("eceba", 2));    // 3
        System.out.println(longestSubstringOptimal("aa", 1));       // 2
        System.out.println(longestSubstringOptimal("", 2));         // 0
        System.out.println(longestSubstringOptimal(null, 2));       // 0
    }

    // 🔴 Brute Force Approach
    public static int longestSubstringBruteForce(String s, int k){

        // Edge case handling
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }

        int maxLength = 0;

        for(int i = 0; i < s.length(); i++){

            Map<Character, Integer> map = new HashMap<>();

            for(int j = i; j < s.length(); j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if(map.size() > k){
                    break;
                }

                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    // 🟢 Optimal Approach (Sliding Window)
    public static int longestSubstringOptimal(String s, int k){

        // Edge case handling
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){

            char endChar = s.charAt(windowEnd);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);

            // shrink window if distinct chars > k
            while (freqMap.size() > k) {
                char startChar = s.charAt(windowStart);
                freqMap.put(startChar, freqMap.get(startChar) - 1);

                if(freqMap.get(startChar) == 0){
                    freqMap.remove(startChar);
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}

/*
    🧠 Interview Explanation (Brute Force):

    “I generate all possible substrings using two loops.
    For each substring, I track distinct characters using a HashMap.
    If the number of distinct characters exceeds k, I stop expanding.
    This guarantees correctness but is inefficient.”


    🧠 Interview Explanation (Optimal – Sliding Window):

    “I use a variable sliding window.
    The right pointer expands the window and adds characters to a frequency map.
    If distinct characters exceed k, I shrink the window from the left
    until the condition becomes valid again.
    During this process, I track the maximum window size.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    - Null or empty string → return 0
    - k = 0 → no valid substring
    - Single character strings handled naturally
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(n)

    Optimal:
    Time  : O(n)
    Space : O(k)
*/