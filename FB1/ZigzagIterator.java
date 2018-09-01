public class ZigzagIterator {
    Deque<Iterator<Integer>> deque;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
         deque = new LinkedList<>();
         if (!v1.isEmpty()) {
             deque.offer(v1.iterator());
         }
         if(!v2.isEmpty()) {
             deque.offer(v2.iterator());
         }
    }

    public int next() {
        Iterator<Integer> it = deque.poll();
        int result = it.next();
        if(it.hasNext(()) {
            deque.offer(it);
        }
        return result;
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }
}


/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
