import java.util.*;

class ParseEmail {
    static int duplicateEmails(List<String> emails) {
        if (emails == null || emails.size() == 0) {
            return 0;
        }

        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < emails.size(); i++) {
            String email = parseEmail(emails.get(i));
            System.out.println("Parsed an email " + email);
            if (!map.containsKey(email)) {
                map.put(email, 1);
            } else {
                map.put(email, map.get(email) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                count++;
            }
        }
        return count;
    }

    static String parseEmail(String email) {
        int i = 0;
        boolean seeAt = false;
        StringBuilder sb = new StringBuilder();

        while (i < email.length()) {
            char c = email.charAt(i);
            if (c == '.') {
                if (i == 0 || (i + 1 < email.length() && email.charAt(i + 1) == '@')) {
                    sb.append(c);
                } else if (seeAt) {
                    sb.append(c);
                }
            } else if (c == '+') {
                while (i < email.length() && email.charAt(i) != '@') {
                    i++;
                }
                if (email.charAt(i) == '@') {
                    seeAt = true;
                    sb.append(email.charAt(i));
                }
            } else {
                if (c == '@') {
                    seeAt = true;
                }
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] emails = {"..ab.c+d@gmail.com", ".ab.c@gmail.com", ".ab.cd.@gmail.com", "..ab.c.d.@gmail.com",
                            "a@.gmail.com","a.+d@.gmail.com"};

        List<String> list = Arrays.asList(emails);
        System.out.println(duplicateEmails(list));
    }
}
