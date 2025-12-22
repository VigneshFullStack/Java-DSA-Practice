package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DivisorsOfNumber {
    public static void main(String[] args) {
        int[] result = divisors(36); // [1, 2, 3, 4, 6, 9, 12, 18, 36]
        System.out.println(Arrays.toString(result));
    }

    public static int[] divisors(int n) {

        ArrayList<Integer> divisors = new ArrayList<>();

        // Loop upto sqrt(n)
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                divisors.add(i);

                if(i != n / i){
                    divisors.add(n / i);
                }
            }
        }

        Collections.sort(divisors);

        // Convert ArrayList to int[]
        int[] result = new int[divisors.size()];
        for(int i = 0; i < divisors.size(); i++){
            result[i] = divisors.get(i);
        }

        return result;
    }
}

/*
    🧠 One-Line Interview Explanation :

    1. Use an ArrayList to dynamically store divisors.
    2. Loop only up to sqrt(n) and add both i and n/i for each divisor.
    3. Avoid duplicates for perfect squares.
    4. Sort the list to get divisors in ascending order.
    5. Convert ArrayList to int[] before returning.
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(√n + d*log(d)) 
        - √n for iterating up to square root
        - d*log(d) for sorting, where d = number of divisors
    Space Complexity: O(d) 
        - ArrayList stores all divisors
*/