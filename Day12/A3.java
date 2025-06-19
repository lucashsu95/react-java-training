import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tot = 0;
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            tot += num;
        }
        System.out.println(tot);
        sc.close();
    }
}