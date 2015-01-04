/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] record = new char[4];
        int count = 0;
        while(count < n){
            int tempCount = read4(record);
            int length = Math.min(n - count, tempCount);
            for(int i = 0;i < length;i ++)
                buf[count + i] = record[i];
            count += length;
            if(length < 4)
                break;
        }
        return count;
    }
}