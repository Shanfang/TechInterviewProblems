/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */


// if we call read4 API only once, we need to know when to stop(either task completed, or no more to read from the stream).
// if we call read4 API multiple times, we need to know when to continue(no chars in the buffer).
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
          if (head == tail) { // no more remaining chars from last calling read4, so call it again
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
            while (index < n && head < tail) {
                buf[index++] = buffer[head++];
            }
            if (index == n) {
                break;
            }
            tail = read4(buffer);
            head = 0;
            if (tail == 0) {
                break;
            }
        }
        return index;
    }
}
