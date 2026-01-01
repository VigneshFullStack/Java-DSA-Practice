package basics;

/*
    Problem Statement :

    Given a positive integer n, determine whether it is odd or even.
    Return true if the number is even and false if the number is odd.
*/

public class OddOrEven {
    public static void main(String[] args) {
        boolean result1 = isEven(10);  // true
        System.out.println(result1);

        boolean result2 = isEven(7);  // false
        System.out.println(result2);
    }

    public static boolean isEven(int n){
        return n % 2 == 0;
    }
}

/*
    🧠 One-Line Interview Explanation :

    If n % 2 equals 0, the number is divisible by 2 and hence even; otherwise it is odd.
*/


/* 
    ⏱ Complexity :

    Time Complexity  : O(1)
    Space Complexity : O(1)
*/