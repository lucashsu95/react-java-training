import java.util.Scanner;

public class J {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String revered = new StringBuilder(s).reverse().toString();
        String result = String.valueOf(s.equals(revered));
        System.out.println(result.substring(0,1).toUpperCase() + result.substring(1));
        sc.close();
    }
}
