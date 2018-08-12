// bfs approachs
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean findLongest = false;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (validStr(str)) {
                result.add(str);
                findLongest = true;
                continue;
            }
            if(findLongest) {
                continue;
            }
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;
                }
                String newStr = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(newStr)) {
                    queue.add(newStr);
                    visited.add(newStr);
                }
            }
        }
        return result;
    }

    private boolean validStr(String str) {
        int leftCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftCount++;
            } else if (str.charAt(i) == ')') {
                leftCount--;
                if(leftCount < 0) {
                    return false;
                }
            }
        }
        return leftCount == 0;
    }
}


// dfs approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int leftP = 0, rightP = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftP++;
            }
            if (s.charAt(i) == ')') {
                if (leftP > 0) {
                    leftP--;
                } else {
                    rightP++;
                }
            }
        }

        dfs(result, 0, leftP, rightP, s);
        return result;
    }

    private void dfs(List<String> result, int start, int leftP, int rightP, String s) {
        if (leftP == 0 && rightP == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (s.charAt(i) == '(' && leftP > 0) {
                dfs(result, i, leftP - 1, rightP, s.substring(0, i) + s.substring(i + 1));
            }
            if (s.charAt(i) == ')' && rightP > 0) {
                dfs(result, i, leftP, rightP - 1, s.substring(0, i) + s.substring(i + 1));
            }
        }
    }

    private boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            if (str.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
