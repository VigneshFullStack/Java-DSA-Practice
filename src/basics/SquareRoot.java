package basics;

/* 
    Problem Statement :
     
    Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.
    Floor value of any number is the greatest Integer which is less than or equal to that number.
*/

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(floorSqrt(11));  // 3
        System.out.println(floorSqrt(4));   // 2
    }

    public static int floorSqrt(int n){
        if(n == 0 || n == 1){
            return n;
        }

        int low = 1, high = n;
        int result = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if square of mid is less than or equal to n 
            // update the result and search in upper half
            if((long) mid * mid <= n){
                result = mid;
                low = mid + 1;
            }
            // if square of mid exceeds n, 
            // search in the lower half
            else {
                high = mid - 1;
            }
        }

        return result;
    }
}

/*
    🧠 One-Line Interview Explanation :

    “I use binary search to find the largest integer whose square is less than or equal to n,
    which directly gives the floor square root.”
*/

 
/* 
    ⏱ Complexity :

    Time Complexity: O(log n)
        - Binary search reduces the search space by half in each iteration.

    Space Complexity: O(1)
        - Only constant extra variables are used.
*/