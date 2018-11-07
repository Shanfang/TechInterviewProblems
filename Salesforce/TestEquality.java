import java.util.*;

class TestEquality {
    public static void main(String[] args) {
        String a = "hello";
        String b = new String("hello");

        System.out.println(a == b); // this only compare the address
        System.out.println(a.equals(b)); // this compares the value
    }
}
