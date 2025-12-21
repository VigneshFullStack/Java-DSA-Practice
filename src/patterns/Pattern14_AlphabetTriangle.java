package patterns;

public class Pattern14_AlphabetTriangle {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 0; i < n; i++){
            for(char ch = 'A'; ch <= 'A' + i; ch++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
