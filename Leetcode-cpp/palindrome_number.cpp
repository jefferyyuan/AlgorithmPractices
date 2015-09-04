class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        int mod = 1;
        while (x / 10 >= mod) mod *= 10;
        while (x > 0) {
            if (x % 10 != x / mod) return false;
            x = (x % mod) / 10;
            mod /= 100;
        }
        return true;
    }
};