class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];

        for (String log : logs) {
            String[] strings = log.split(":");
            int time = Integer.valueOf(strings[2]);
            int func = Integer.valueOf(strings[0]);

            if (strings[1].equals("start")) {
                stack.push(new int[]{func, time});
            } else {
                int period = time + 1 - stack.pop()[1];
                result[func] += period;
                if (!stack.isEmpty()) {
                    result[stack.peek()[0]] -= period;
                }
            }
        }
        return result;
    }
}
