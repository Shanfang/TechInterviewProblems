class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator >= 0) ^ (denominator >= 0)) {
            sb.append("-");
        }
        long num = Math.abs((long)(numerator));
        long den = Math.abs((long)(denominator));
        long frac = num / den;
        sb.append(frac);
        num = num % den;
        if (num == 0) {
            return sb.toString();
        }

        Map<Long, Integer> map = new HashMap<>();
        sb.append(".");
        while (num != 0) {
            map.put(num, sb.length());
            num = num * 10;
            long digit = num / den;
            sb.append(digit);
            num = num % den;
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
