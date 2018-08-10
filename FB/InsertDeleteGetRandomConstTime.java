class RandomizedSet {
    Map<Integer, Integer> hash;
    List<Integer> list;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hash = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hash.containsKey(val)) {
            return false;
        }
        hash.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hash.containsKey(val)) {
            return false;
        }
        int index = hash.get(val);

        if (index < hash.size() - 1 ) {
            int lastone = list.get(list.size() - 1 );
            list.set( index , lastone );
            hash.put(lastone, index);
        }

        hash.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randIdx = rand.nextInt(list.size());
        return list.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
