// to check the result returned from helper method. use str.equals()!!!  str == "" does not work
class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String[] units = {"", "Thousand", "Million", "Billion"};

        int i = 0;
        String result = "";
        while (num > 0) {
            int num1 = num % 1000;
            num = num / 1000;
            String str1 = withinThousand(num1);
            if (!str1.equals("")) {
                result = str1 + " " +  units[i] + " " + result;
            }
            i++;
        }
        return result.trim();
    }

    private String withinThousand(int num1) {
        String[] underTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",                                    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] aboveTwenty = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String  result = "";

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
