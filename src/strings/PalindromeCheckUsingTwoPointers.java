package strings;

/* 
    Problem Statement :
     
    Given a string s, check whether it is a palindrome.
    A palindrome reads the same forwards and backwards.
*/

public class PalindromeCheckUsingTwoPointers {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));   // true
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("hello"));   // false
        System.out.println(isPalindrome("a"));       // true
        System.out.println(isPalindrome(""));        // true
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

    “I use two pointers starting from both ends of the string.
    At each step, I compare the characters at the left and right pointers.
    If at any point the characters do not match, the string is not a palindrome.
    If all matching pairs are equal, the string is a palindrome.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/