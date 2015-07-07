class Solution {
public:
    int climbStairs(int n) {
        vector<int> record;
        record.push_back(1);
        record.push_back(2);
        for(int i = 2;i < n;i ++)
        {
            record.push_back(record[i-1] + record[i-2]);
        }
        return record[n - 1];
    }
};
