class Solution {
public:
    int trailingZeroes(int n) {
        return count(n, 5);
    }
    
    int count(int n, int factor) {
        int result = 0;
        while (n > 0) {
            result += n / factor;
            n /= factor;
        }
        return result;
    }
};