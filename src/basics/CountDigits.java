package basics;

public class CountDigits {
    public static void main(String[] args) {
        int result1 = count(607301);   // 6
        int result2 = count(0);        // 1
        int result3 = count(-7777);      // 4
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

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
}
