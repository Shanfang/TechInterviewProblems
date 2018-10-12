class ValidTriangle {
    static String checkTriangle (int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Invalid";
        } else if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b== c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public static void main(String[] args) {
        int a = 1, b = 1, c = 1;
        System.out.println("This triangle is: " + checkTriangle(a, b, c));
    }
}
