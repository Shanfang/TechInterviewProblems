class IsPossible {
    static boolean isPossible (int a, int b, int c, int d) {
        if (a == c && b == d) {
            return true;
        }
        // set this condition as the four params are positive
        if (a > c || b > d) {
            return false;
        }

        return isPossible (a + b, b, c, d) || isPossible(a, a + b, c, d);
    }

    public static void main(String[] args) {
        boolean result = isPossible(1, 4, 5, 15);
        System.out.println(result);
    }
}
