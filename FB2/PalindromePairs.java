class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String str1 = word.substring(0, j);
                String str2 = word.substring(j);

                if (isPalindrome(str1)) {
                    StringBuilder sb = new StringBuilder(str2);
                    String revStr2 = sb.reverse().toString();
                    if (map.containsKey(revStr2) && map.get(revStr2) != i) {
                        result.add(Arrays.asList(map.get(revStr2), i));
                    }
                }
                if (j != word.length() && isPalindrome(str2)) {
                    StringBuilder sb = new StringBuilder(str1);
                    String revStr1 = sb.reverse().toString();
                    if (map.containsKey(revStr1) && map.get(revStr1) != i) {
                        result.add(Arrays.asList(i, map.get(revStr1)));
                    }
                }
             }
        }

        return result;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
         }
         return true;
    }
}
