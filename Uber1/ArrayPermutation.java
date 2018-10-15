import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayPermutation {
    static List<String> get(int[] arr) {
        List<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }

        boolean[] used = new boolean[arr.length];
        helper(new StringBuilder(), arr, result, used);
        return result;
    }
    static void helper(StringBuilder sb, int[] arr, List<String> result, boolean[] used) {
        if (sb.length() == arr.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                sb.append(arr[i]);
                used[i] = true;
                helper(sb, arr, result, used);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }

    private static final Scanner input = new Scanner(System.in);
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        //int size = Integer.parseInt(input.nextLine().trim());
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
            //array[i] = Integer.parseInt(input.nextLine().trim());
        }
        List<String> result = get(array);
        for(String str : result) {
            System.out.println(str);
        }
    }
}
