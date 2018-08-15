class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null) {
            return result;
        }

        permutate(S, "", result, 0);
        return result;
    }

    private void permutate(String str, String cur, List<String> result, int start) {
        if (start == str.length()) {
            result.add(cur);
            return;
        }
        char c = str.charAt(start);
        if (Character.isDigit(c)) {
            permutate(str, cur + String.valueOf(c), result, start + 1);
        } else {
            permutate(str, cur + String.valueOf(Character.toUpperCase(c)), result, start + 1);
            permutate(str, cur + String.valueOf(Character.toLowerCase(c)), result, start + 1);
        }
    }
}
