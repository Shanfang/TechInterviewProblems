import java.util.*;

class SortColors {
    static void sort(String[] colors) {
        if (colors == null || colors.length == 0) {
            return;
        }
        int start = 0, end = colors.length - 1, i = 0;
        while (i < end) {
            if (colors[i].equals("Red")) {
                swap(start, i, colors);
                start++;
                i++;
            } else if (colors[i].equals("Blue")) {
                swap(i, end, colors);
                end--;
                i++;
            } else {
                i++;
            }
        }
    }

    private static void swap(int i, int j, String[] colors) {
        String temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }

    public static void main(String[] args) {
        String[] colors = {"Blue", "Red", "White", "Red", "Blue", "White"};
        sort(colors);
        for (String color : colors) {
            System.out.println(color);
        }
    }
}
