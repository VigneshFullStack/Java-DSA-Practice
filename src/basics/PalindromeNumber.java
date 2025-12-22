package basics;

/* 
    Problem Statement :
     
    You are given an integer n. You need to check whether the number is a palindrome number or not.
    Return true if it's a palindrome number, otherwise return false.
    A palindrome number is a number which reads the same both left to right and right to left.
*/

public class PalindromeNumber {
    public static void main(String[] args) {
        boolean result1 = isPalindrome(757);  // true
        System.out.println(result1);

        boolean result2 = isPalindrome(123);  // false
        System.out.println(result2);

        boolean result3 = isPalindrome(-121);  // false
        System.out.println(result3);
    }

    public static boolean isPalindrome(int n){
        if (n < 0) return false;

        int originalValue = n;
        int reverseNumber = 0;

        while(n > 0){
            int lastDigit = n % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            n = n / 10;
        }

        return originalValue == reverseNumber;
    }
}

/*
    🧠 One-Line Interview Explanation :

    “I reverse the number digit by digit and compare it with the original number.
    If both are equal, the number is a palindrome.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(d) where d = number of digits
    Space Complexity: O(1)
*/