import java.util.*;

class ShuffleCards {
    static char[] shuffle(char[] cards, int[] indexes){
        char[] result = new char[cards.length];
        for (int i = 0; i < cards.length; i++) {
            result[i] = cards[indexes[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        char[] cards = {'A', 'B', 'C'};
        int[] indexes = {2, 0, 1};
        for (char c : shuffle(cards, indexes)) {
            System.out.println(c);
        }
    }
}
