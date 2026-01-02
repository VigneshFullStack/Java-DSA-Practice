package basics;

/*
    Problem Statement :

    Given a number n, determine whether it is a prime number or not.
    Note: A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
*/

public class PrimeNumberCheck {
    public static void main(String[] args) {
        System.out.println(isPrime(1));   // false
        System.out.println(isPrime(2));   // true
        System.out.println(isPrime(3));   // true
        System.out.println(isPrime(4));   // false
        System.out.println(isPrime(29));  // true
        System.out.println(isPrime(36));  // false
    }

    public static boolean isPrime(int n){
        // Numbers <= 1 are not prime
        if(n <= 1){
            return false;
        }

        // Check divisibility from 2 to sqrt(n)
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;  // Found a divisor
            }
        }

        // No divisors found
        return true;
    }
}

/*
    🧠 Interview Explanation :

    “A number is prime if it has no divisors between 2 and √n.
    We stop at √n because divisors occur in pairs.”
*/


/*
    ⏱ Complexity :

    Time Complexity: O(√n)
    Space Complexity: O(1)
*/