import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int score = sc.nextInt();
            if(score == 100){
                System.out.println("A+");
            }
            else if (score >= 90) {
                System.out.println("A");
            }
            else if (score >= 80) {
                System.out.println("B");
            }
            else if (score >= 70) {
                System.out.println("C");
            }
            else if (score >= 60) {
                System.out.println("D");
            } else {
                System.out.println("E");
            }
        }
        sc.close();
    }
}
