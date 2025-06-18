import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        number = scanner.nextInt();
        int nextNumber = scanner.nextInt();
        if(nextNumber > number){
            number = nextNumber;
        }
        int nextNumber2 = scanner.nextInt();
        if(nextNumber2 > number){
            number = nextNumber2;
        }
        System.out.println(number);
        
        scanner.close();
    }
}