class Solution {
public:
    int mySqrt(int x) {
        long long input = (long long) x;
        long long start = 0, end = x;
        while (start < end ) {
            long long mid = (start + end) / 2;
            if (mid * mid == input) return mid;
            if (mid * mid < input) start = mid + 1;
            else end = mid - 1;
        }
        if (start * start > input) start--;
        return (int)start;
    }
};