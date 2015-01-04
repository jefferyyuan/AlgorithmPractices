public class Solution {
    public int reverse(int x) {
        long result = 0;
        int sign = 1;
        if(x < 0)
        {
            sign = -1;
            x = -x;
        }
        while(x != 0)
        {
            result = result * 10 + x % 10;
            x /= 10;
        }
        result *= sign;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        else
            return (int)result;
    }
}