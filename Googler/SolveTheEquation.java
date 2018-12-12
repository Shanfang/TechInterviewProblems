class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        String leftPart = parts[0];
        String rightPart = parts[1];
        int[] leftVals = eval(leftPart);
        int[] rightVals = eval(rightPart);
        int xCnt = leftVals[0] - rightVals[0];
        int val = rightVals[1] - leftVals[1];
        if (xCnt == 0 && val != 0) {
            return "No solution";
        }
        if (xCnt == 0) {
            return "Infinite solutions";
        }
        int result = val / xCnt;
        return "x=" + result;
    }

    private int[] eval(String str) {
        int[] result = new int[2];
        int count = 0, val = 0;
        String[] strs = str.split("(?=[+-])");
        for (String s : strs) {
            if (s.equals("x") || s.equals("+x")) {
                count++;
            } else if (s.equals("-x")) {
                count--;
            } else if (s.contains("x")) {
                count += Integer.valueOf(s.substring(0, s.indexOf("x")));
            } else  {
                val += Integer.valueOf(s);
            }
        }
        result[0] = count;
        result[1] = val;
        return result;
    }
}
