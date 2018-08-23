class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int index = 0;
        int len = citations.length;
        while (index < len && citations[len - 1 - index] > index) {
            index++;
        }
        return index;
    }
}
