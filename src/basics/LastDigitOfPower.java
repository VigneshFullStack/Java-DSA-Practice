package basics;

/* 
    Problem Statement :

    You are given two integer numbers in the form of string,
    the base 'a' and the index 'b'.
    You need to return the last digit of a^b.

    Note:
    - The numbers can be very large (up to 1000 digits)
    - You must not calculate the full power
*/

public class LastDigitOfPower {
    public static void main(String[] args) {
        System.out.println(getLastDigit("3", "10"));  // 9
        System.out.println(getLastDigit("6", "2"));   // 6
        System.out.println(getLastDigit("7", "100")); // 1
    }

    public static int getLastDigit(String a, String b){
        // If exponent is 0 → a^0 = 1
        if(b.equals("0")){
            return 1;
        }

        // Get last digit of base 'a'
        int lastDigit = a.charAt(a.length() - 1) - '0';

        // Find b % 4 (since last digits repeat every 4)
        int power = 0;
        for(int i = 0; i < b.length(); i++){
            power = (power * 10 + (b.charAt(i) - '0')) % 4;
        }

        // If remainder is 0, use full cycle
        if(power == 0){
            power = 4;
        }

        // Multiply only 'power' times and keep last digit
        int result = 1;
        for(int i = 0; i < power; i++){
            result = (result * lastDigit) % 10;
        }

        return result;
    }
}

/*
    🧠 Interview Explanation :

    We do not compute a^b directly because the numbers are extremely large.

    The last digit of any power depends only on the last digit of the base.

    The last digit pattern repeats every 4 powers.

    Since b is a string, we compute b % 4 digit by digit.

    If b % 4 == 0, it represents a full cycle, so we use 4.

    We multiply the base’s last digit only a few times (maximum 4) and keep % 10
    to maintain the last digit.
*/


/*
    ⏱ Complexity :
    Time Complexity: O(|b|)
        - We iterate once over the string 'b' to compute b % 4
        - All other operations take constant time

    Space Complexity: O(1)
        - Only a few integer variables are used
        - No extra data structures
*/