class Solution {
    public static final Character[] vowels = new Character[]{'a','e','i','o','u','A','E','I','O','U'};
    public static final Set<Character> set = new HashSet<>(Arrays.asList(vowels));
    public String toGoatLatin(String S) {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (String word : S.split(" ")) {
            if (index != 0) {
                sb.append(" ");
            }
            char firstChar = word.charAt(0);
            if (set.contains(firstChar)) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.substring(0, 1));
            }
            sb.append("ma");

            for (int i = 0; i <= index; i++) {
                sb.append("a");
            }
            index++;
        }
        return sb.toString();
    }
}
