class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String[] units = {"", "Thousand", "Million", "Billion"};
        String result = "";
        int i = 0;
        while (num > 0) {
            String str = helper(num % 1000);
            if (!str.equals("")) {
                result = str + " " + units[i]  + " " + result;
            }
            num /= 1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num) {
        String[] underTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                                "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] aboveTwenty = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";
        if (num >= 100) {
            result = underTwenty[num / 100] + " Hundred ";
            num %= 100;
        }
        if (num >= 20) {
            result = result + aboveTwenty[num / 10] + " " + underTwenty[num % 10];
        } else {
            result = result + underTwenty[num];
        }
        return result.trim();
    }
}
