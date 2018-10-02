class Fibonacci {
    static void  printFib(int n) {
        if (n < 1) {
            return;
        }
        int first = 0;
        int second = 1;
        for (int i = 1; i <= n; i++) {
            System.out.println(second);
            int next = first + second;
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        printFib(n);
    }
}
