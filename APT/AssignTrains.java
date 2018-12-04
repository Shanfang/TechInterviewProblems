import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AssignTrains {
    class Pair {
        int p;
        int t;
        Pair(int p, int t) {
            this.p = p;
            this.t = t;
        }
    }

    List<List<Pair>> assign(List<Integer> people, List<Integer> trains) {
        List<List<Pair>> result = new ArrayList<>();

        helper(people, 0, trains, new ArrayList<>(), result);
        return result;
    }

    private void helper(List<Integer> people, int index, List<Integer> trains, List<Pair> list, List<List<Pair>> result) {
        if (index == people.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = 0; j < trains.size(); j++) {
            list.add(new Pair(people.get(index), trains.get(j)));
            helper(people, index + 1, trains, list, result);
            list.remove(list.size() - 1);
        }

    }
    public static void main(String args[] ) throws Exception {
        AssignTrains at = new AssignTrains();
        Integer[] ppl = {11, 12};
        Integer[] ts = {90, 91};
        List<Integer> people = Arrays.asList(ppl);
        List<Integer> trains = Arrays.asList(ts);

        for(List<Pair> list : at.assign(people, trains)) {
            for (Pair pair : list) {
                System.out.print(pair.p + "--" + pair.t + "\t");
            }
            System.out.println();
        }
    }
}
