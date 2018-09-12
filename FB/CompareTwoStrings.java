
/**
["abc", "a10", "a2", "a100"] String array

default comparator : ["a10", "a100", "a2", "abc", "ba"]

our comparator: ["a2", "a10", "a100", "abc"]

return -1 if a < b
return 1 if a > b
return 0 if a == b
*/
import java.util.*;
public class CompareTwoStrings {
    public static int stringComparator(String a, String b) {
        /*
        int index1 = 0, index2 = 0;
        while(index1 < a.length()  && index2 < b.length()){
        1.c1 c2 not digit
          1.1 c1 = c2 continue;
          1.2 return c1 - c2 < 0 ? - 1: 1
        2.c1 c2 all digit
          compute num1 num2
          2.1 num1 = num2 continue;
          2.2 similar to 1.2
        3 else
          1.2
         */
         int i = 0, j = 0;
         int num1 = 0, num2 = 0;
         while (i < a.length() && j < b.length()) {
             char c1 = a.charAt(i);
             char c2 = b.charAt(j);

             if (!Character.isDigit(c1) && !Character.isDigit(c2)) {
                 if (c1 == c2) {
                     i++;
                     j++;
                     continue;
                 } else {
                     return c1 - c2  < 0 ? -1 : 1;
                 }
             } else if (Character.isDigit(c1) && Character.isDigit(c2)) {
                 while (i < a.length() && Character.isDigit(a.charAt(i))) {
                     num1 = num1 * 10 + a.charAt(i) - '0';
                     i++;
                 }
                 while (j < b.length() && Character.isDigit(b.charAt(j))) {
                     num2 = num2 * 10 + b.charAt(j) - '0';
                     j++;
                 }
                 if (num1 == num2) {
                     continue;
                 } else {
                     return num1 - num2 < 0 ? -1 : 1;
                 }
                 num1 = 0;
                 num2 = 0; // need to reset these two numbers, in case there are numbers afterwards
             } else {
                 return c1 - c2 < 0 ?  -1 : 1;
             }
         }

         if (i == a.length() && j == b.length()) {
             return 0;
         } else {
             return i == a.length() ? -1 : 1;
         }
    }

    //our comparator: ["a2", "a10", "a100", "abc"]
    public static void main(String[] args) {
        String[] strings = {"abc", "a10", "a2", "a100"};
        System.out.println(stringComparator(strings[0], strings[0]));
        System.out.println(stringComparator(strings[0], strings[1]));
        System.out.println(stringComparator(strings[1], strings[2]));
        System.out.println(stringComparator(strings[2], strings[3]));
        System.out.println(stringComparator(strings[1], strings[3]));
    }
}
