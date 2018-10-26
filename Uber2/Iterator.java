import java.util.*;

private static final class ListIterator implements Iterator<String> {
    private final int index;
    private final List<String> list;
    ListIterator (List<String> l) {
        this.index = 0;
        this.list = l;
    }
    public String next() throws Exception {
        if (hasNext()) {
            index++;
            return list.get(index - 1);
        }
        throw new NoMoreElementException("No more element");
    }

    public boolean hasNext() {
        if (this.index < this.list.size()) {
            return true;
        }
        return false;
    }
}

class List implements Iterable<String> {
    private int index;
    private List<String> list;
    List() {
        this.list = new ArrayList<>();
    }
    public Iterator<String> Iterator() {
        return new ListIterator<String>(this);
    }
}
public class Iterator {
    public static void main(String args[] ) throws Exception {
        String[] strs = {"a", "b", "c"};
        List<String> list = new ArrayList(Arrays.asList(strs));
        ListIterator<String> it = list.Iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        try {
            it.next();
        } catch( Exception e) {
            System.out.println(e);
        }

        // Iterator it = new Iterator(Arrays.asList(strs));
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }
        //
        // try {
        //     it.next();
        // } catch( Exception e) {
        //     System.out.println(e);
        // }
        //
        //
        // 1,2,3
        // 4,5
        // 6,6
    }
}
