class TwoSum {
    Map<Integer, Integer> map;
    List<Integer> list;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int count = map.getOrDefault(number, 0);
        map.put(number, count + 1);
        if (count == 0) {
            list.add(number);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if ((map.containsKey(value - num) && value != 2 * num) ||
                (value == 2 * num && map.get(num) > 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
