package lib;

import java.util.Scanner;

import models.*;
import models.abstracts.Payment;

public class Functions {
    @SuppressWarnings("resource")
    public static String OutAndInput(String Output) {
        System.out.print(Output);
        return (new Scanner(System.in)).nextLine();
    }

    public static Payment createPayment(String className) {
        switch (className) {
            case "0":
                return new Cash();
            case "1":
                return new LinePay(0.9f);
            case "2":
                return new ApplePay(0.85f);
            default:
                return null;
        }
    }
}
