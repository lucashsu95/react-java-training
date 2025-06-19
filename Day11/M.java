import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] stringList = line.split(",");
        System.out.println(stringList.length);
        sc.close();
    }
}
