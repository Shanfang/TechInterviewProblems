class Solution {
    public boolean isUgly(int num) {
        if (num == 0){
            return false;
        }
        while (num != 1) {
            while (num != 1 && num % 2 == 0) {
                num = num / 2;
            }
            while (num != 1 && num % 3 == 0) {
                num = num / 3;
            }
            while (num != 1 && num % 5 == 0) {
                num = num / 5;
            }
            if (num != 1) {
                return false;
            }
        }
        return true;
    }
}
