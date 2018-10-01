//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.*;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static int paths = 0;
    public static String start = "JFK";
    public static String end = "SFO";

    public static void main(String[] args)
    {
       Scanner stdin = new Scanner(System.in);
       String str = stdin.nextLine();
       int pairs = Integer.parseInt(str);
        String[][] airports = new String[pairs][2];
        int i = 0;
       while(stdin.hasNextLine()) {
           if (i == pairs) {
                break;
            }
           String line = stdin.nextLine();

            if (!line.isEmpty()) {
                String[] codes = line.split(" ");
                airports[i][0] = codes[0];;
                airports[i][1] = codes[1];
                i++;
            }
       }
       stdin.close();
        findPaths(airports);
        System.out.println(paths);
    }
    private static void findPaths(String[][] airports) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < airports.length; i++) {
            String first = airports[i][0];
            String second = airports[i][1];
            if (!map.containsKey(first)) {
                map.put(first, new ArrayList<String>());
            }
            map.get(first).add(second);
        }
        for (String next : map.get(start)) {
            dfs(map, next, end);
        }
    }
    private static void dfs(Map<String, List<String>> map, String cur, String end) {
        if (cur.equals(end)) {
            paths++;
            return;
        }
        if (map.get(cur) == null) {
            return;
        }
        for (String next : map.get(cur)) {
            dfs(map, next, end);
        }
    }
}



import java.util.Scanner;
import java.util.Map;
import java.util.*;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static int paths = 0;
    public static void main(String[] args)
    {
       Scanner stdin = new Scanner(System.in);
       String str = stdin.nextLine();
       int hops = Integer.parseInt(str);

        Map<String, List<String>> map = new HashMap<>();
       while(stdin.hasNextLine())
       {   String line = stdin.nextLine();
            System.out.println(line);
            if (!line.isEmpty()) {
                String[] codes = line.split(" ");
                String first = codes[0];
                String second = codes[1];
                System.out.println(first);
                System.out.println(second);
                if (!map.containsKey(first)) {
                    map.put(first, new ArrayList<String>());
                }
                map.get(first).add(second);
            }
           //System.out.println(stdin.nextLine());
       }
       stdin.close();
       String start = "JFK";
       String end = "SFO";
        for (String next : map.get(start)) {
            dfs(map, next, end);
        }
        System.out.println(paths);
    }

    private static void dfs(Map<String, List<String>> map, String cur, String end) {
        if (cur.equals(end)) {
            paths++;
            return;
        }
        for (String next : map.get(cur)) {
            dfs(map, next, end);
        }
    }
}
