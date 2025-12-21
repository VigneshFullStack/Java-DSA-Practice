package patterns;

public class Pattern11_BinaryPattern {
    public static void main(String[] args) {
        int n = 5;
        int start;

        for(int i = 0; i < n; i++){
            start = (i % 2 == 0) ? 1 : 0;
            for(int j = 0; j <= i; j++){
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }
}
