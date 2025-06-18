import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] stringList = new String[3];
        stringList[0] = scanner.nextLine();
        stringList[1] = scanner.nextLine();
        stringList[2] = scanner.nextLine();
        String maxString = Arrays.stream(stringList)
                .max(String::compareTo)
                .orElse("");
        System.out.println(maxString);
        scanner.close();

    }
}
