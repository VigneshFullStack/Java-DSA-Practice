package basics;

/* 
    Problem Statement :

    Given a number n, find the value of n raised to the power
    of its own reverse.

    Note:
    - The reverse of a number is obtained by reversing its digits
    - Leading zeros in the reverse should be discarded
    - The result will always fit into a 32-bit signed integer
*/

public class PowerOfReverse {
    public static void main(String[] args) {
        System.out.println(powerOfReverse(2));    // 4
        System.out.println(powerOfReverse(10));   // 10
        System.out.println(powerOfReverse(5));    // 3125
    }

    public static int powerOfReverse(int n){
        int reverse = reverseNumber(n);
        int result = 1;

        // Compute n^reverse using simple multiplication
        for(int i = 0; i < reverse; i++){
            result *= n;
        }

        return result;
    }

    private static int reverseNumber(int n){
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
    🧠 Interview Explanation :

    First, we reverse the digits of the given number n.

    Leading zeros are automatically discarded when reversing
    using integer arithmetic.

    Once we obtain the reversed number, we compute n raised to
    the power of the reversed value.

    Since the problem guarantees that the result fits into a
    32-bit signed integer, we can safely use int.
*/


/*
    ⏱ Complexity :

    Time Complexity: O(d + r)
        - d is the number of digits in n (for reversing)
        - r is the value of the reversed number (for power calculation)

    Space Complexity: O(1)
        - Only constant extra space is used
*/