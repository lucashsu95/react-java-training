import java.util.Scanner;

public class H3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        for (int i = 1; i <= h; i++) {
            int underScore = h - i + 1;
            System.out.print("_".repeat(underScore));
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = i - 1; j > 0; j--) {
                System.out.print(j);
            }
            System.out.print("_".repeat(underScore));
            System.out.println();
        }
        sc.close();
    }
}
