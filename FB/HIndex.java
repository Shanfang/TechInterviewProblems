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


// with more intuitive approach, counting sort
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int[] counts = new int[len + 1];
        for (int citation : citations) {
            if (citation > len) {
                counts[len]++;
            } else {
                counts[citation]++;
            }
        }
        int count = 0;
        for (int i = len; i>= 0; i--) {
            count += counts[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
