class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String[] units = {"", "Thousand", "Million", "Billion"};
        String result = "";
        int i = 0;
        while (num > 0) {
            String subRst = helper(num % 1000);
            if (!subRst.equals("")) {
                result = subRst + " " + units[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num1) {
        String[] underTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                                "Twelve", "Thirteen", "Fourteen","Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] aboveTwenty = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String result = "";
        if (num1 >= 100) {
            result = underTwenty[num1 / 100] + " Hundred ";
        }

        if (num1 % 100 < 20) {
            result += underTwenty[num1 % 100];
        } else {
            num1 = num1 % 100;
            result += aboveTwenty[num1 / 10] + " " + underTwenty[num1 % 10];
        }
        return result.trim();
    }
}
