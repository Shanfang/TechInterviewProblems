class Solution {
    public static String[] units = new String[]{"", "Thousand", "Million", "Billion"} ;
    public static String[] withinTwenty = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six",
                            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] withinHundred = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) {
            String triplet = helper(num % 1000);
            if (triplet != "") {
                sb.insert(0, triplet + " " + units[i] + " ");
            }
            num /= 1000;
            i++;
        }
        return sb.toString().trim();
    }

    // this helper is used to process number under 1000
    private String helper(int num) {
        if (num < 20) {
            return withinTwenty[num];
        } else if (num < 100) {
            String str = withinTwenty[num % 10];
            if (str != "") {
                return  withinHundred[num / 10] + " " + str;
            } else {
                return withinHundred[num / 10];
            }
        } else {
            String str = helper(num % 100);
            if (str != "") {
                return withinTwenty[num / 100] + " Hundred " + str;
            } else {
                return withinTwenty[num / 100] + " Hundred";
            }
        }
    }
}
