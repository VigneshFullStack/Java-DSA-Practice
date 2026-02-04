package arrays.important.TwoPointers;

/* 
    Problem Statement :
     
    Given a string s,
    determine whether it is a palindrome.
    
    A palindrome reads the same forward and backward.

    Consider ONLY alphanumeric characters
    and IGNORE case sensitivity.

    Brute Force:
    - Clean the string (remove special chars + lowercase)
    - Reverse the string
    - Compare both strings

    Optimal:
    - Use Two Pointers
    - Compare characters from both ends
    - Skip non-alphanumeric characters
*/

public class ValidPalindromeApproaches {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeBruteForce(s1));   // true

        // -------- Optimal --------
        String s2 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromeOptimal(s2));     // true

        String s3 = "race a car";
        System.out.println(isPalindromeOptimal(s3));     // false

        String s4 = "a";
        System.out.println(isPalindromeOptimal(s4));     // true

        String s5 = null;
        System.out.println(isPalindromeOptimal(s5));     // false
    }

    // 🔴 Brute Force (Extra Space)
    public static boolean isPalindromeBruteForce(String s){

        // Edge case handling
        if(s == null || s.length() == 0){
            return false;
        }

        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }

    // 🟢 Optimal (Two Pointers)
    public static boolean isPalindromeOptimal(String s){

        // Edge case handling
        if(s == null || s.length() == 0){
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            
            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (ignore case)
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
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
    If both are equal, the string is a palindrome.
    This approach works but uses extra space.”


    🧠 Interview Explanation (Optimal Approach):

    “To optimize space, I use the two-pointer technique.
    One pointer starts at the beginning of the string and the other at the end.
    I skip any non-alphanumeric characters and compare valid characters.
    If a mismatch occurs, I return false.
    Otherwise, I move both pointers inward until they meet.”


    🧠 Interview Explanation — Edge Case Handling (Bonus):

    “I handle null or empty strings upfront.
    Single-character strings are automatically palindromes,
    so returning early avoids unnecessary processing.”
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