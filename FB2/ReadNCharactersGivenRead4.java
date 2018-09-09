/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */


// this one makes more sense
// we stop reading file for two cases:
// 1. we have read n characters
// 2. there is no more to read even though we have read < n characters


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

// based on the two cases that we will stop calling the API
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int index = 0;
        int start = 0;
        while (index < n) {
            int count = read4(buffer);
            if (count == 0) {
                break;
            }
            while (index < n && start < count) {
                buf[index++] = buffer[start++];
            }
            if (index == n) {
                break;
            }
            start = 0;
        }
        return index;
    }
}

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
