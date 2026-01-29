package strings;

import java.util.HashSet;
import java.util.Set;

/*
    Problem Statement :

    Given a string s,
    find the length of the longest substring
    without repeating characters.

    Example:
    Input  : "abcabcbb"
    Output : 3   ("abc")

    Input  : "bbbbb"
    Output : 1   ("b")

    Input  : "pwwkew"
    Output : 3   ("wke")
*/

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        System.out.println(lengthBruteForce("abcabcbb")); // 3

        // -------- Optimal --------
        System.out.println(lengthOptimal("abcabcbb"));    // 3
        System.out.println(lengthOptimal("bbbbb"));       // 1
        System.out.println(lengthOptimal(""));            // 0
        System.out.println(lengthOptimal(null));          // 0
    }

    // 🔴 Brute Force Approach
    public static int lengthBruteForce(String s){

        // Edge case handling
        if(s == null || s.length() == 0){
            return 0;
        }

        int maxLength = 0;

        // Step 1: Fix starting index
        for(int i = 0; i < s.length(); i++){

            Set<Character> set = new HashSet<>();

            // Step 2: Expand ending index
            for(int j = i; j < s.length(); j++){

                char ch = s.charAt(j);

                // If duplicate found → stop this substring
                if(set.contains(ch)){
                    break;
                }

                set.add(ch);
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    // 🟢 Optimal Approach (Sliding Window + HashSet)
    public static int lengthOptimal(String s){

        // Edge case handling
        if(s == null || s.length() == 0){
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int windowStart = 0;
        int maxLength = 0;

        // Step 1: Right pointer expands the window
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){

            char ch = s.charAt(windowEnd);

            // Step 2: If duplicate exists, shrink window
            while(set.contains(ch)){
                set.remove(s.charAt(windowStart));
                windowStart++;
            }

            set.add(ch);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I consider all possible substrings using two loops.
    For each substring, I check if it contains duplicate
    characters using a HashSet.
    If a duplicate appears, I stop expanding that substring.
    I track the maximum valid length found.”


    🧠 Interview Explanation (Optimal Approach - Sliding Window):

    “I use a sliding window with two pointers.
    The right pointer expands the window by adding characters.
    If a duplicate character appears, I shrink the window
    from the left until the duplicate is removed.
    At every step, the window contains only unique characters,
    and I track the maximum window size.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    - null string → return 0
    - empty string → return 0
    - all characters same → answer is 1
    - string with all unique characters → full length
*/


/*
    ⏱ Complexity :

    Brute Force:
    Time  : O(n²)
    Space : O(n)

    Optimal (Sliding Window):
    Time  : O(n)
    Space : O(n)
*/