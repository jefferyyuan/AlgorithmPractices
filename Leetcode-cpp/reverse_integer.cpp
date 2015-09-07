class Solution {
public:
    int reverse(int x) {
        bool isNegative = x < 0;
        long long input = (long)x;
        if (isNegative) input = -input;
        long long result = 0;
        while (input > 0) {
            result = result * 10 + input % 10;
            input /= 10;
        }
        if (isNegative) result = -result;
        if (result > (long)INT_MAX || result < (long)INT_MIN) {
            return 0;
        } else {
            return (int)result;
        }
    }
};