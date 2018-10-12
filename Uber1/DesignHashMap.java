class MyHashMap {
    int[] array;
    int capacity;
    /** Initialize your data structure here. */
    public MyHashMap() {
        capacity = 100000;
        array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % capacity;
        array[index] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % capacity;
        return array[index];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % capacity;
        array[index] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
