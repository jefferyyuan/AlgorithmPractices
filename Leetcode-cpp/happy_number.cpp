class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> record;
        while (record.find(n) == record.end()) {
            record.insert(n);
            int result = 0;
            while (n > 0) {
                result += (n % 10) * (n % 10);
                n /= 10;
            }
            n = result;
        }
        return n == 1;
    }
};