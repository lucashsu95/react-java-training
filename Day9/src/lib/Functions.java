package lib;

import java.util.Scanner;

public class Functions {
    public static String OutAndInput(String Output) {
        System.out.print(Output);
        return (new Scanner(System.in)).nextLine() + "\n";
    }
}
