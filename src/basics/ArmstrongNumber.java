package basics;

/* 
    Problem Statement :
     
    You are given an integer n. You need to check whether it is an armstrong number or not.
    Return true if it is an armstrong number, otherwise return false.
    An armstrong number is a number which is equal to the sum of the digits of the number,
    raised to the power of the number of digits.
*/

public class ArmstrongNumber {
    public static void main(String[] args) {
        boolean result1 = isArmstrong(371);   // true
        System.out.println(result1);

        boolean result2 = isArmstrong(1234);  // false
        System.out.println(result2);

        boolean result3 = isArmstrong(1634);  // true
        System.out.println(result3);
    }

    public static boolean isArmstrong(int n){
        if(n < 0) return false;

        int originalValue = n;
        int digits = countDigits(n);
        int sum = 0;

        while(n > 0){
            int lastDigit = n % 10;
            sum += power(lastDigit, digits);
            n = n / 10;
        }

        return originalValue == sum;
    }

    private static int countDigits(int n){
        if(n == 0) return 1;

        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }

        return count;
    }

    private static int power(int base, int exp){
        int result = 1;
        for(int i = 1; i <= exp; i++){
            result *= base;
        }
        return result;
    }
}

/*
    🧠 One-Line Interview Explanation :

   “I first count the digits, then sum each digit raised to that power, and finally compare it with the original number.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(d) where d = number of digits
    Space Complexity: O(1)
*/