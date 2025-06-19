import java.util.Scanner;

public class I3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean dontHave3or5 = true;
        int count = 2;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                if (i == 3 || i == 5) {
                    dontHave3or5 = false;
                    break;
                }
                count++;
            }
        }
        System.out.println((dontHave3or5 && count > 4) ? 1 : 0);
        sc.close();
    }
}
