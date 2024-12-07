package math;

public class Prime {

    public static int testNum = 0;
    public Prime(){}

    public boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
