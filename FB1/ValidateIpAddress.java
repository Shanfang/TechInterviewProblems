class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

// start of IPv4
    private boolean isIPv4(String IP) {
        if (countChar(IP, '.') != 3) {
            return false;
        }
        String[] tokens = IP.split("\\.");

        if (tokens.length != 4) {
            return false;
        }
        for (String token : tokens) {
            if (!isIPv4Token(token)) {
                return false;
            }
        }
        return true;
    }

    private int countChar(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    private boolean isIPv4Token(String token) {
        if (token.length() == 0 || token.length() > 3) {
            return false;
        }
        if (token.startsWith("0") && token.length() > 1) {
            return false;
        }
        if (!isNumeric(token)) {
            return false;
        }
        int num = Integer.parseInt(token);
        if (num < 0 || num > 255) {
            return false;
        }
        return true;
    }

    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    // end of IPv4

    // start of IPv6
    private boolean isIPv6(String IP){
        if (countChar(IP, ':') != 7) {
            return false;
        }
        String[] tokens = IP.split(":");
        if (tokens.length != 8) {
            return false;
        }

        for (String token : tokens) {
            if (!isIPv6Token(token)) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6Token(String token) {
        if (token.length() == 0 || token.length() > 4) {
            return false;
        }
        for (char c : token.toCharArray()) {
            if (!isHexDecimal(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isHexDecimal(char c) {
        return (c >= 'a' && c <= 'f')|| (c >= 'A' && c <= 'F') || Character.isDigit(c);
    }
}
