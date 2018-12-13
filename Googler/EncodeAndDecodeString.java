public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList();
        int index = 0;
        while (index < s.length()) {
            int tokenIndex = s.indexOf("#", index);
            int len = Integer.valueOf(s.substring(index, tokenIndex));
            list.add(s.substring(tokenIndex + 1, tokenIndex + len + 1));
            index = tokenIndex + len + 1;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
