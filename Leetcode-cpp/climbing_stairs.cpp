class Solution {
public:
    int climbStairs(int n) {
        vector<int> record(n + 1, 1);
        for (int i = 2; i <= n; ++i) {
            record[i] = record[i - 1] + record[i - 2];
        }
        return record[n];
    }
};