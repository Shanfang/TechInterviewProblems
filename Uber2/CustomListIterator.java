import java.util.*;

public class CustomListIterator implements Iterable<String>, Iterator<String> {
    private int index;
    private final ArrayList<String> list;
    CustomListIterator (List<String> l) {
        this.index = 0;
        this.list = l;
    }

    public Iterator<String> iterator() {
        index = 0;
        return this;
    }
    public String next() {
        if (hasNext()) {
            index++;
            return list.get(index - 1);
        }
        throw new Exception("No more element");
    }

    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        return false;
    }

// class List implements Iterable<String> {
//     private int index;
//     private List<String> list;
//     List() {
//         this.list = new ArrayList<>();
//     }
//     public Iterator<String> Iterator() {
//         return new ListIterator<String>(this);
//     }
// }
    public static void main(String args[] ) throws Exception {
        String[] strs = {"a", "b", "c"};
        // List<String> list = new ArrayList<>();
        // list.add("a");
        // list.add("b");
        // list.add("c");
        ArrayList<String> list = new ArrayList(Arrays.asList(strs));
        //ListIterator<String> it = list.Iterator();
        CustomListIterator custom = new CustomListIterator(list);
        Iterator it = custom.iterator();

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
