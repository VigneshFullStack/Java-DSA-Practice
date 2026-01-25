package strings;

/* 
    Problem Statement :
     
    Given a string s, check whether it is a palindrome.
    The comparison should be case-insensitive.
*/

public class PalindromeCheckIgnoreCase {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Madam"));     // true
        System.out.println(isPalindrome("RaceCar"));   // true
        System.out.println(isPalindrome("Hello"));     // false
    }

    public static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            
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

    “I use two pointers from both ends of the string.
    Before comparison, I normalize characters by converting them
    to lowercase to make the comparison case-insensitive.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(1)
*/