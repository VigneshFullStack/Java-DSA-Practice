package basics;

/* 
    Problem Statement :

    Given a positive integer n, count the number of digits in n
    that divide n evenly (without leaving a remainder).

    A digit d divides n evenly if:
        n % d == 0

    Note:
    - Each digit of n should be checked individually
    - If a digit is 0, ignore it (division by 0 is undefined)
*/

public class CountDividingDigits {
    public static void main(String[] args) {
        System.out.println(evenlyDivides(12));    // 2
        System.out.println(evenlyDivides(2446));  // 1
        System.out.println(evenlyDivides(23));    // 0
        System.out.println(evenlyDivides(1012));  // 3
    }

    public static int evenlyDivides(int n){
        int original = n;
        int count = 0;

        while(n > 0){
            int digit = n % 10;

            // Ignore digit 0 and check divisibility
            if(digit != 0 && original % digit == 0){
                count++;
            }

            n = n / 10;  // remove last digit
        }

        return count;
    }
}

/*
    🧠 Interview Explanation :

    We need to check each digit of the number independently.

    We store the original value of n because we will modify n
    while extracting digits.

    For every digit:
    - If the digit is 0, we skip it
    - Otherwise, we check if originalNumber % digit == 0

    If the condition is satisfied, we increment the count.

    We continue this process until all digits are processed.
*/


/*
    ⏱ Complexity :

    Time Complexity: O(d)
        - d is the number of digits in n
        - Each digit is processed once

    Space Complexity: O(1)
        - Only constant extra variables are used
*/