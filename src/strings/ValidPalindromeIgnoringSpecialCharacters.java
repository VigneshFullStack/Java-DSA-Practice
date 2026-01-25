package strings;

/*
    Problem Statement :

    Given a string s, determine if it is a palindrome,
    considering only alphanumeric characters and ignoring cases.
*/

public class ValidPalindromeIgnoringSpecialCharacters {
    public static void main(String[] args) {
        
        System.out.println(isPalindromeBruteForce("A man, a plan, a canal: Panama")); // true

        System.out.println(isPalindromeOptimal("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindromeOptimal("race a car")); // false
        System.out.println(isPalindromeOptimal(""));           // true
        System.out.println(isPalindromeOptimal(null));         // true
    }

    // 🔴 Brute Force Approach
    public static boolean isPalindromeBruteForce(String s){

        // Edge case
        if(s == null || s.length() == 0){
            return true;
        }

        StringBuilder cleaned = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String filtered = cleaned.toString();
        String reversed = cleaned.reverse().toString();

        return filtered.equals(reversed);
    }

    // 🟢 Optimal Approach (Two Pointers)
    public static boolean isPalindromeOptimal(String s){

        // Edge case
        if(s == null || s.length() == 0){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){

            // Skip non-alphanumeric from left
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            // Skip no-alphanumeric from right
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if(leftChar != rightChar){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I first filter the string by keeping only alphanumeric characters and converting them to lowercase. 
    Then I check whether the cleaned string equals its reverse.”


    🧠 Interview Explanation (Optimal Approach):

    “To optimize space, I use two pointers from both ends. 
    I skip non-alphanumeric characters and compare characters in a case-insensitive manner. 
    If all characters match, the string is a palindrome.”


    🧠 Interview Explanation — Edge Case Handling (Bonus)

    “I normalize the string by handling case sensitivity and ignoring non-alphanumeric characters,
    then apply palindrome logic.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal:
    Time  : O(n)
    Space : O(1)
*/