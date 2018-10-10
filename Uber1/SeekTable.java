class SeekTable {
    static double seek(double[][] input, double id) {
        int start = 0, end = input.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (input[mid][0] == id) {
                return input[mid][1];
            } else if (input[mid][0] > id) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (input[start][0] == id) {
            return input[start][1];
        } else if (input[end][1] == id) {
            return input[end][1];
        } else {
            return (double)-1;
        }
    }

    public static void main(String[] args) {
        double[][] input = {{1.0, 3.0},{2.0, 3.6},{3.0, 3.3},{4.0, 4.0},{5.0, 4.5},{6.0, 3.2}};
        //double[][] input = {{1.0, 3.0},{6.0, 3.6},{3.0, 3.3},{10.0, 4.0},{15.0, 4.5},{2.0, 3.2}};// we assume id is sorted
        System.out.println(seek(input, 2.0));
    }
}
