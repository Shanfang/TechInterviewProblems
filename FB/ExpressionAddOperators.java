class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if(num == null || num.length() == 0) return result;
        dfs(result, "", num, target, 0, 0, 0);
        return result;
    }
    public void dfs(List<String> result, String path, String num, int target, int pos, long evaluation, long multed){
        if(pos == num.length()){
            if(target == evaluation)
                result.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                dfs(result, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                dfs(result, path + "+" + cur, num, target, i + 1, evaluation + cur , cur);

                dfs(result, path + "-" + cur, num, target, i + 1, evaluation -cur, -cur);

                dfs(result, path + "*" + cur, num, target, i + 1, evaluation - multed + multed * cur, multed * cur );
            }
        }
    }
}
