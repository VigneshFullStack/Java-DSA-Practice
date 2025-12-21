package basics;

/* 
    Problem Statement :

    You are given an integer n. You need to return the number of digits in the number.
    The number will have no leading zeroes, except when the number is 0 itself.
*/

public class CountDigits {
    public static void main(String[] args) {
        int result1 = count(607301);   // 6
        System.out.println(result1);

        int result2 = count(0);        // 1
        System.out.println(result2);

        int result3 = count(-7777);      // 4
        System.out.println(result3);

        int logResult = countDigitsLog(17112025);  // 8
        System.out.println(logResult);
    }

    // Approach 1:
    public static int count(int n){
        if(n == 0) return 1;

        n = Math.abs(n);

        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    // Approach 2:
    public static int countDigitsLog(int n){
        if(n == 0) return 1;

        n = Math.abs(n);

        return (int) Math.floor(Math.log10(n)) + 1;
    }
}

/*
    🧠 One-Line Interview Explanation :

    “I repeatedly divide the number by 10.
    Each division removes one digit, so the number of iterations gives the digit count.
    I handle zero separately.”
*/


/* 
    ⏱ Complexity :

    Time Complexity: O(d) → number of digits
    Space Complexity: O(1)
*/