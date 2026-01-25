package strings;

/* 
    Problem Statement :
     
    Given a character array s, reverse the array.
    
    Brute Force:
    - You may use extra space
    
    Optimal:
    - Reverse the string in-place
    - You are NOT allowed to use extra space
*/

public class ReverseStringApproaches {
    public static void main(String[] args) {
        
        // -------- Brute Force --------
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        char[] reversed1 = reverseBruteForce(s1);
        printCharArray(reversed1);   // o l l e h

        // -------- Optimal --------
        char[] s2 = {'h', 'e', 'l', 'l', 'o'};
        reverseOptimal(s2);
        printCharArray(s2);          // o l l e h

        char[] s3 = {'a'};
        reverseOptimal(s3);
        printCharArray(s3);          // a

        char[] s4 = {};
        reverseOptimal(s4);
        printCharArray(s4);          // empty

        char[] s5 = null;
        reverseOptimal(s5);          // safe
    }

    // 🔴 Brute Force (Extra Space)
    public static char[] reverseBruteForce(char[] s){

        // Edge case
        if (s == null || s.length == 0) {
            return s;
        }

        int n = s.length;
        char[] reversed = new char[n];

        for(int i = 0; i < n; i++){
            reversed[i] = s[n - 1 - i];
        }

        return reversed;
    }

    // 🟢 Optimal (Two Pointers – In-place)
    public static void reverseOptimal(char[] s){

        // Edge case handling
        if (s == null || s.length <= 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while(left < right){
            
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void printCharArray(char[] s){

        if(s == null){
            System.out.println("null");
            return;
        }

        for(char c : s){
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

/*
    🧠 Interview Explanation (Brute Force Approach):

    “I start with a simple brute-force approach.
    I create a new character array and copy characters from the end of the original array to the beginning. 
    This reverses the string easily but uses extra space.”


    🧠 Interview Explanation (Optimal Approach):

    “To reverse the string in-place, I use the two-pointer technique. 
    One pointer starts from the beginning and the other from the end. 
    I swap characters and move both pointers inward until they meet.”


    🧠 Interview Explanation — Edge Case Handling (Bonus)

    “Before applying the logic, I handle edge cases like null input, empty strings, or single-character strings.
    These cases don’t require any processing and returning early avoids unnecessary operations and runtime exceptions.”
*/


/* 
    ⏱ Complexity :

    Brute Force:
    Time  : O(n)
    Space : O(n)

    Optimal:
    Time  : O(n)
    Space : O(1)
*/