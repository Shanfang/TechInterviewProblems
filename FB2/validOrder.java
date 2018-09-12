/*
Input: Words = ['a', 'aa', 'cb', 'bc']
           Order = ['a', 'c', 'b']
Output: True

Input: Words = ['a', 'aa', 'cb', 'bc']
           Order = ['c', 'a', 'b']
Output: False (cb -> a  -> aa -> bc)

*/
public boolean validOrder(String[] words, String[] order) {
    if (words == null || words.length <= 1) {
        return true;
    }

    Map<String, order> map = new HashMap<>();
    int w = 0;
    for (String str : order) {
        map.put(str, w++);
    }
    for (int i = 0; i < word.length - 1; i++) {
        int len1 = words[i].length();
        int len2 = words[i + 1].length();
        int j = 0;
        int minLen = Math.min(len1, len2);
        while (j < minLen) {
            char c1 = words[i].charAt(j);
            char c2 = words[i + 1].charAt(j);
            if (c1! = c2) {
                if (map.get(c1) > map.get(c2)) {
                    return false;
                }
                break;
            }
            j++;
        }
    }
    return true;
}
