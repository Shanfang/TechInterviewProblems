class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (logs == null || logs.size() == 0) {
            return result;
        }

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < logs.size(); i++) {
            String str = logs.get(i);
            String[] strs = str.split(":");
            int func = Integer.valueOf(strs[0]);
            int time = Integer.valueOf(strs[2]);
            if (strs[1].equals("start")) {
                stack.push(new int[]{func, time});
            } else {
                int diff = time + 1 - stack.pop()[1];
                result[func] += diff;
                if (!stack.isEmpty()) {
                    result[stack.peek()[0]] -= diff;
                }
            }
        }
        return result;
    }
}
