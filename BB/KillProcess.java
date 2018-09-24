class Solution {
    class Node {
        int val;
        List<Node> children;
        Node(int value) {
            this.val = value;
            children = new ArrayList<>();
        }
    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        if (pid == null || ppid == null || pid.size() == 0 || ppid.size() == 0) {
            return result;
        }
        Map<Integer, Node> map = new HashMap<>();
        for (int id : pid) {
            map.put(id, new Node(id));
        }

        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                Node parent = map.get(ppid.get(i));
                parent.children.add(map.get(pid.get(i)));
            }
        }

        killChildren(map.get(kill), result);
        return result;
    }

    private void killChildren(Node cur, List<Integer> result) {
        result.add(cur.val);
        if (cur.children.size() == 0) {
            return;
        }
        for (Node child : cur.children) {
            killChildren(child, result);
        }
    }
}

/* TLE
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        if (pid == null || ppid == null || pid.size() == 0 || ppid.size() == 0) {
            return result;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int head = queue.poll();
            result.add(head);
            List<Integer> indexes = findIndex(head, ppid);
            if (indexes.size() != 0) {
                for (int index : indexes) {
                    queue.offer(pid.get(index));
                }
            }
        }
        return result;
    }

    private List<Integer> findIndex(int num, List<Integer> ppid) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i < ppid.size()) {
            if (ppid.get(i) == num) {
                result.add(i);
            }
            i++;
        }
        return result;
    }
}
*/
