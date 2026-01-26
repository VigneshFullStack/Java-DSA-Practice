package strings;

/* 
    Problem Statement :
     
    Given a string s, determine whether it is a palindrome.

    Conditions:
    - Ignore non-alphanumeric characters
    - Ignore case sensitivity

    Brute Force:
    - Clean the string
    - Reverse and compare

    Optimal:
    - Use Two Pointers
*/

public class ValidPalindrome {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        System.out.println(isPalindromeBruteForce("madam"));                          // true
        System.out.println(isPalindromeBruteForce("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindromeBruteForce("race a car"));                     // false


        // -------- Optimal (Two Pointers) --------
        System.out.println(isPalindromeOptimal("madam"));                          // true
        System.out.println(isPalindromeOptimal("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindromeOptimal("race a car"));                     // false
        System.out.println(isPalindromeOptimal(null));                             // false
    }

    // 🔴 Brute Force Approach
    public static boolean isPalindromeBruteForce(String s){

        // Edge case handling
        if(s == null){
            return false;
        }

        StringBuilder cleaned = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String original = cleaned.toString();
        String reversed = cleaned.reverse().toString();

        return original.equals(reversed);
    }

    // 🟢 Optimal Approach (Two Pointers)
    public static boolean isPalindromeOptimal(String s){

        // Edge case handling
        if(s == null){
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // Skip non-alphanumeric characters
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            // Compare characters ignoring case
            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
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

    “I first clean the string by removing all non-alphanumeric characters
    and converting it to lowercase.
    Then I reverse the cleaned string and compare it with the original.
    If both are equal, the string is a palindrome.”


    🧠 Interview Explanation (Optimal Approach – Two Pointers):

    “To optimize space, I use the two-pointer technique.
    One pointer starts at the beginning and the other at the end of the string.
    I skip non-alphanumeric characters and compare characters ignoring case.
    If all corresponding characters match, the string is a palindrome.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle edge cases such as null strings or strings with only
    non-alphanumeric characters.
    These cases are handled safely without runtime errors.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal (Two Pointers):
    Time  : O(n)
    Space : O(1)
*/