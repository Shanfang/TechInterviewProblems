/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     int index;
     char[] buffer;
    public int read(char[] buf, int n) {
        index = 0;
        buffer = new char[4];

        while (true) {
            int tail = read4(buffer);
            int head = 0;
            if (index == n || tail == 0) {
                break;
            }
            while (index < n && head < tail) {
                buf[index++] = buffer[head++];
            }

        }
        return index;
    }
}
