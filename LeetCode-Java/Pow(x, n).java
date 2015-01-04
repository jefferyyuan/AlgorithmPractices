public class Solution {
    public double pow(double x, int n) {
        double result = 1;
        boolean isNegative = (n < 0);
        if(isNegative)
            n = -n;
        while(n > 0)
        {
            if((n & 1) == 1)
                result *= x;
            n = n >> 1;
            x = x * x;
        }
        if(isNegative)
            result = 1 / result;
        return result;
    }
}