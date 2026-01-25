package strings;

/* 
    Problem Statement :
     
    Given a string s, determine if it is a palindrome,
    considering only alphanumeric characters and ignoring cases.
*/

public class ValidPalindromeIgnoringSpecialCharacters {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));  // true
        System.out.println(isPalindrome("race a car"));                      // false
        System.out.println(isPalindrome(" "));                               // true
    }

    public static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) 
                != Character.toLowerCase(s.charAt(right))){
                    return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

/*
    🧠 Interview Explanation :

    “I use two pointers and skip non-alphanumeric characters
    from both ends. I compare only valid characters after
    converting them to lowercase.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/