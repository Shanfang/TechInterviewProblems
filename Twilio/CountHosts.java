import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class CountHosts {
    static void count(String path) {
        String[] strings = path.split("\\.");
        String inputFile = strings[0];
        String outputFile = "records_" + inputFile + ".txt";

        Map<String,Integer> map = new HashMap<>();
        PrintWriter writer = null;
        Scanner scanner = null;
        try {
            writer = new PrintWriter(new File(outputFile));
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] strs = line.split("--");
                map.put(strs[0], map.getOrDefault(strs[0], 0) + 1);
            }

            for (String host : map.keySet()) {
                writer.println(host + " " + map.get(host));
                writer.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void main(String[] args) {
        String path = "hosts_access_log_00.txt";
        count(path);
    }
}
