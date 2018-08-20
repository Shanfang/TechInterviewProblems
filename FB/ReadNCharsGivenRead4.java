/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int index = 0;
        while (true) {
            int readSize = read4(buffer);
            for (int i = 0; i < readSize && index < n; i++) {
                buf[index++] = buffer[i];
            }
            if (readSize == 0 || index == n) {
                return index;
            }
        }
    }
}
