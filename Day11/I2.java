import java.util.Scanner;
import java.util.stream.IntStream;

public class I2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // boolean isPrime = true;
        // for (int i = 2; i < num; i++) {
        //     if (num % i == 0){
        //         isPrime = false;
        //         break;
        //     }
        // }
        boolean isPrime = num > 1 && IntStream.range(2, num).noneMatch(i -> num % i == 0);
        System.out.println(isPrime ? "T" : "F");
        sc.close();
    }
}
