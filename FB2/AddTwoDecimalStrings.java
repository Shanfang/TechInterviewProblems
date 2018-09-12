public class AddTwoDecimalStrings {
    public String addTwoDecimalStrings(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int indexA = findDot(a);
        int indexB = findDot(b);
        if (indexA < 0) {
            a = a + ".";
        }
        if (indexB < 0) {
            b = b + ".";
        }
        System.out.println("index of dot in a " + indexA);
        System.out.println("index of dot in b " + indexB);

        int rightA = indexA < 0 ? 0 : a.length() - indexA - 1;
        int rightB = indexB < 0 ? 0 : b.length() - indexB - 1;
        System.out.println("length after dot in a " + rightA);
        System.out.println("length after dot in b " + rightB);

        if (rightA < rightB) {
            a = attachZero(a, rightB - rightA);
        } else if (rightB < rightA) {
            b = attachZero(b, rightA - rightB);
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j >= 0) {
            if (i >= 0 && a.charAt(i) == '.') {
                sb.append('.');
                i--;
                j--;
                continue;
            }
            int num1 = i < 0 ? 0 : a.charAt(i) - '0';
            int num2 = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = carry + num1 + num2;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
            System.out.println("current string builder " + sb.toString());
        }

        if(carry > 1) {
            sb.append('0' + carry);
        }
        int k = 0;
        while (k < sb.length()) {
            if (sb.charAt(k) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }
        if (k < sb.length() && sb.charAt(k) == '.') {
            sb.deleteCharAt(k);
        }
        return sb.reverse().toString();
    }

    private int findDot(String str) {
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '.') {
                return i;
            }
            i++;
        }
        return -1;
    }
    private String attachZero(String str, int count) {
        System.out.println("attach " + count + " zero to " + str);
        StringBuilder sb = new StringBuilder(str);
        while (count > 0) {
            sb.append("0");
            count--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        AddTwoDecimalStrings addStrs = new AddTwoDecimalStrings();
        String result = addStrs.addTwoDecimalStrings("12.45", "1.0000001");
        System.out.println(result);
    }
}
