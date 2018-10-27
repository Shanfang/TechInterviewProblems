import java.util.*;

class CustomListIterator implements Iterable<String>, Iterator<String> {
    private int index;
    private List<String> list;
    CustomListIterator () {
        this.index = 0;
        this.list = new ArrayList<>();
    }
    public void add(String str) {
        list.add(str);
        index++;
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
        return "No more element";
    }

    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        CustomListIterator custom = new CustomListIterator();
        custom.add("a");
        custom.add("b");
        custom.add("c");
        Iterator it = custom.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
