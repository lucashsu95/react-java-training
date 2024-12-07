import java.util.ArrayList;

import math.Point;
import math.Prime;

class MyClass {
    private static int count = 0;

    public int cnt = 0;

    public MyClass() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class App {

    public static void main(String[] args) {
        
        // Point class
        System.out.println(Point.ORIGIN_X);
        Point.printPoint();
        
        // Count class
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        System.out.println("Count: " + MyClass.getCount()); // 輸出: Count: 2
        obj1.cnt++;
        obj2.cnt++;
        obj1.cnt++;
        System.out.println("obj1: " + obj1.cnt);
        System.out.println("obj2: " + obj2.cnt);

        // Prime class
        Prime prime = new Prime();
        boolean n1 = prime.isPrime(7);
        boolean n2 = prime.isPrime(12);
        System.out.println(n1 + " " + n2);

        // 輸出2到20之間的質數
        ArrayList<Integer> nums = new ArrayList<>();
        int start = 2;
        int end = 20;
        for (int i = start; i < end; i++) {
            if (prime.isPrime(i)) {
                nums.add(i);
            }
        }
        System.out.println(nums);
        
    }
}
