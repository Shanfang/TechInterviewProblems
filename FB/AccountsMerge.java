class Solution {
    Map<Integer, Integer> parents;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new HashMap<>();

        Map<String, List<Integer>> emailToIds = getEmailToIds(accounts);
        for (String email : emailToIds.keySet()) {
            List<Integer> ids = emailToIds.get(email);
            for (int i = 1; i < ids.size(); i++) {
                union(ids.get(i), ids.get(0)); // find a root for the group of ids mapping to same email
            }

        }

        Map<Integer, Set<String>> idToEmails = getIdToEmails(accounts);
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int id : idToEmails.keySet()) {
            List<String> emails = new ArrayList<>(idToEmails.get(id));
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            mergedAccounts.add(emails);
        }
        return mergedAccounts;
    }

    private Map<String, List<Integer>> getEmailToIds(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToIds = new HashMap<>();
        for (int index = 0; index < accounts.size(); index++) {
            List<String> account = accounts.get(index);
            for (int i = 1; i < account.size(); i++) {
                List<Integer> ids = emailToIds.getOrDefault(account.get(i), new ArrayList<>());
                ids.add(index);
                emailToIds.put(account.get(i), ids);
            }
        }
        return emailToIds;
    }

    private Map<Integer, Set<String>> getIdToEmails(List<List<String>> accounts) {
        Map<Integer, Set<String>> idToEmails = new HashMap<>();
        for (int index = 0; index < accounts.size(); index++) {
            int rootIdx = find(index);
            Set<String> emailSet = idToEmails.getOrDefault(rootIdx, new HashSet<String>());
            List<String> account = accounts.get(index);
            for (int i = 1; i < account.size(); i++) {
                emailSet.add(account.get(i));
            }
            idToEmails.put(rootIdx, emailSet);
        }
        return idToEmails;
    }

    private int find(int id) {
        // make id a root
        List<Integer> path = new ArrayList<>();
        while (parents.containsKey(id)) {
            path.add(id);
            id = parents.get(id);
        }

        //  compress the path while
        for (int i : path) {
            parents.put(i, id);
        }
        return id;
    }

    private void union(int id1, int id2) {
        int root1 = find(id1);
        int root2 = find(id2);
        if (root1 != root2) {
            parents.put(root1, root2);
        }
    }
}
