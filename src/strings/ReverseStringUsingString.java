package strings;

/* 
    Problem Statement :
     
    Given a String s, reverse the string.
    
    Note:
    - String is immutable in Java
    - In-place modification is NOT possible
*/

public class ReverseStringUsingString {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        String s1 = "hello";
        System.out.println(reverseBruteForce(s1));   // olleh

        // -------- Optimal --------
        String s2 = "hello";
        System.out.println(reverseOptimal(s2));      // olleh

        System.out.println(reverseOptimal("a"));     // a
        System.out.println(reverseOptimal(""));      // empty
        System.out.println(reverseOptimal(null));    // null
    }

    // 🔴 Brute Force (StringBuilder)
    public static String reverseBruteForce(String s){

        // Edge case
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder reversed = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            reversed.append(s.charAt(i));
        }

        return reversed.toString();
    }

    // 🟢 Optimal (Convert to char[] + Two Pointers)
    public static String reverseOptimal(String s){

        // Edge case
        if(s == null || s.length() <= 1){
            return s;
        }

        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while(left < right){

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }
}

/*
    🧠 Interview Explanation (VERY IMPORTANT):

    First thing you should say 🔥
        “Since strings are immutable in Java, we cannot reverse them in-place.”


    🧠 Interview Explanation (Brute Force Approach):

    “I iterate from the end of the string and build a new string using a StringBuilder. 
    This is simple but still uses extra space.”


    🧠 Interview Explanation (Optimal Approach):

    “To optimize, I convert the string into a character array and apply the two-pointer technique to reverse it. 
    Then I convert it back to a string. This is the most efficient approach possible for strings due to immutability.”


    🧠 Interview Explanation — Edge Case Handling (Bonus)

    “Before applying the logic, I handle null, empty, and single-character strings as edge cases.
    Whitespace and special characters don’t need special handling because reversal is purely positional.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal:
    Time  : O(n)
    Space : O(n)  // unavoidable because String is immutable
*/