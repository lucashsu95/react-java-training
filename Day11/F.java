import java.util.Scanner;

public class F {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num >= 1000) {
            System.out.println((int) (num * 0.11));
        }else{
            System.out.println(0);
        }
        scanner.close();

    }
}