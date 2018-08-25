/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
     char[] buffer = new char[4];
     int head = 0, tail = 0;
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (head == tail) {
                tail = read4(buffer); //for the read4 API, buffer is the place to store the chars
                head = 0;
                if (tail == 0) {
                    break; //there is no more character to read in the file
                }
            }
            while (index < n && head < tail) {
                buf[index++] = buffer[head++];
            }
        }
        return index;
    }
}
