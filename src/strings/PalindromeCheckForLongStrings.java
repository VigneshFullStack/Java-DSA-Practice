package strings;

/* 
    Problem Statement :
     
    Given a very large string, check if it is a palindrome.
    The solution must be efficient in both time and space.
*/

public class PalindromeCheckForLongStrings {
    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(isPalindrome(s)); // true
    }

    public static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            
            if(s.charAt(left) != s.charAt(right)){
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

    “Since strings can be very large, I avoid creating any
    extra data structures. I compare characters directly
    using two pointers to maintain O(1) space.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/