package basics;

/* 
    Problem Statement :
     
    Write a program to generate the reverse of a given number N.
    Print the corresponding reverse number.
    Note: If a Number has Trailing Zeros, Then its reverse will not include Them.
    For E.G., Reverse of 10400 will be 401 instead of 00401.
*/

public class ReverseNumber {
    public static void main(String[] args) {
        int result1 = reverseNumber(1234);  // 4321
        System.out.println(result1);

        int result2 = reverseNumber(10400);  // 401
        System.out.println(result2);
    }
    
    public static int reverseNumber(int n){
        int reverseNumber = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            n = n / 10;
        }

        return reverseNumber;
    }
}

/*
    🧠 One-Line Interview Explanation :

    “I extract digits one by one using modulo 10, build the reversed number by multiplying the existing value by 10
    and adding the digit, and remove the digit using division.”
 */

 
 /* 
    ⏱ Complexity :

    Time Complexity: O(d) where d = number of digits
    Space Complexity: O(1)
*/