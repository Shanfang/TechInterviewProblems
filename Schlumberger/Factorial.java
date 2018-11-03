import java.util.*;
import java.lang.IllegalArgumentException;

class Factorial {
    static int factorial(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        int n = 10;
        try {
            System.out.println(factorial(n));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
