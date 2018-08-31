class Solution {
    class UnionFind {
        Map<Integer, Integer> parents;
        UnionFind() {
            parents = new HashMap<>();
        }

        public void union(int id1, int id2) {
            int root1 = find(id1);
            int root2 = find(id2);
            if (root1 != root2) {
                parents.put(root1, root2);
            }
        }

        public int find(int id) {
            List<Integer> path = new ArrayList<>();
            while (parents.containsKey(id)) {
                path.add(id);
                id = parents.get(id);
            }
            for (int num : path) {
                parents.put(num, id);
            }
            return id;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return result;
        }

        UnionFind uf = new UnionFind();

        Map<String, List<Integer>> emailToIds = getEmailToIds(accounts);
        // union ids with the same email
        for (String email : emailToIds.keySet()) {
            List<Integer> ids = emailToIds.get(email);
            for (int i = 1; i < ids.size(); i++) {
                uf.union(ids.get(i), ids.get(0));
            }
        }

        Map<Integer, Set<String>> idToEmails = getIdToEmails(accounts, uf); // ids belong to the same group are mereged
        for (int id : idToEmails.keySet()) {
            List<String> account = new ArrayList<>(idToEmails.get(id));
            Collections.sort(account);
            account.add(0, accounts.get(id).get(0));// add user name
            result.add(account);
        }
        return result;
    }

    private Map<String, List<Integer>> getEmailToIds(List<List<String>> accounts) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                List<Integer> ids = map.getOrDefault(email, new ArrayList<>());
                ids.add(i);
                map.put(email, ids);
            }
        }
        return map;
    }

    private Map<Integer, Set<String>> getIdToEmails(List<List<String>> accounts, UnionFind uf) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int root = uf.find(i);
            Set<String> emails = map.getOrDefault(root, new HashSet<>());
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                emails.add(account.get(j));
            }
            map.put(root, emails);
        }
        return map;
    }
}
