import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m1 = scanner.nextInt();
        int m2 = scanner.nextInt();

        System.out.println(Math.abs(m1 - m2));
        
        scanner.close();
    }

}
