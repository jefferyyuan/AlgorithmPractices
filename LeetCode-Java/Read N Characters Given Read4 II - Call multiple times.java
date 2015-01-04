/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int lastStart = 0;
    private int lastEnd = -1;
    char[] record = new char[4];
    public int read(char[] buf, int n) {
        if(lastEnd < lastStart){
            lastStart = 0;
            lastEnd = -1;
        }
        int last = lastEnd + 1 - lastStart;
        if(last >= n){
            for(int i = 0;i < n;i ++){
                buf[i] = record[lastStart];
                lastStart ++;
            }
            return n;
        }

        
        int count = 0;
        while(lastStart <= lastEnd){
            buf[count] = record[lastStart];
            count ++;
            lastStart ++;
        }
        while(count < n){
            int tempCount = read4(record);
            int length = Math.min(n - count, tempCount);
            for(int i = 0;i < length;i ++)
                buf[count + i] = record[i];
            if(tempCount >= n - count){
                lastStart = n - count;
                lastEnd = tempCount - 1;
            }
            count += length;
            if(length < 4)
                break;
        }
        return count;
    }
}