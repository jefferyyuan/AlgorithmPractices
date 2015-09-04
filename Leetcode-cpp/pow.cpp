class Solution {
public:
    double myPow(double x, int n) {
        double result = 1;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        while (n > 0) {
            if (n & 1) result *= x;
            x = x * x;
            n = n >> 1;
        }
        return result;
    }
};