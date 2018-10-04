import java.util.*;

class MinMaxProd {
    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        TreeSet<Integer> set = new TreeSet<>();

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).equals("push")) {
                set.add(x.get(i));
                result.add((long)(set.first() * set.last()));
            } else {
                set.remove(x.get(i));
                result.add((long)(set.first() * set.last()));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"push","push","push","push","push","pop","pop"};
        List<String> ops = new ArrayList<String>(Arrays.asList(arr));
        List<Integer> x = new ArrayList<>(Arrays.asList(3,1,5,8,6,1,8));
        for (long num : maxMin(ops, x)) {
            System.out.println(num);
        }
    }
}
