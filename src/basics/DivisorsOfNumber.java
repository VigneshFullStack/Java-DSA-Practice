package basics;

import java.util.Arrays;

public class DivisorsOfNumber {
    public static void main(String[] args) {
        int[] result = divisors(36);   // [1, 2, 3, 4, 6, 9, 12, 18, 36]
        System.out.println(Arrays.toString(result));
    }

    public static int[] divisors(int n){

        // count divisors
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0) count++;
        }

        // create array
        int[] result = new int[count];

        // fill array
        int index = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0) {
                result[index++] = i;
            }
        }

        return result;
    }
}

/*
    🧠 One-Line Interview Explanation :

   “Since arrays need a fixed size, I first count the number of divisors,
   then create an array of that size and fill it in a second pass.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(n)
    Space Complexity: O(d) where d = number of divisors
*/