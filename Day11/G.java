import java.util.Scanner;

public class G {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int mm = scanner.nextInt();
        int hh = 0;
        if(mm > 60){
            hh = mm / 60;
            mm %= 60;
        }
        System.out.printf("%02d:%02d", hh, mm);
        scanner.close();
    }
}
