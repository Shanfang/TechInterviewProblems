class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 0; i < n - 1; i++) {
            long head= set.pollFirst();
            set.add(head * 2);
            set.add(head * 3);
            set.add(head * 5);
        }
        return set.pollFirst().intValue();
    }
}
