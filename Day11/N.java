import java.util.Arrays;
import java.util.Scanner;

public class N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] stringList = line.split(" ");
        Arrays.sort(stringList);
        String p1 = stringList[0];
        String p2 = stringList[1];

        String winner = p1.equals("X") ? "Y" : p2.equals("X") ? "X" : "O";
        if(p1.equals(p2)){
            System.out.println(0);
        } else {
            System.out.println(line.substring(0, 1).equals(winner) ? 1 : 2);
        }
        sc.close();
    }
}
