/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     char[] buffer = new char[4];
     int head = 0;
     int tail = 0;

    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (head == tail) {
                tail = read4(buffer);
                head = 0;
                if (tail == 0) {
                    break;
                }
            }

            while (index < n && head != tail) {
                buf[index++] = buffer[head++]; // is n < 4, result after read4 is stored in buffer, but not into buf yet
            }
        }
        return index;
    }
}
