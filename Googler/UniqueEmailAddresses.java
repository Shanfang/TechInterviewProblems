class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String emailAddress = processEmailAddress(email);
            set.add(emailAddress);
        }
        return set.size();
    }

    private String processEmailAddress(String email) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (email.charAt(i) != '@') {
            char c = email.charAt(i);
            i++;
            if (c == '.') {
                continue;
            }
            if (c == '+') {
                break;
            }
            sb.append(c);
        }
        while (email.charAt(i) != '@') {
            i++;
        }
        sb.append(email.charAt(i));
        while(i < email.length()) {
            sb.append(email.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
