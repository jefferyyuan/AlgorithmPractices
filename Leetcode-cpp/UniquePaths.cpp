class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> record;
        for(int i = 0;i < m;i ++)
        {
            vector<int> tempVector(n,1);
            record.push_back(tempVector);
        }
        for(int i = 1;i < m;i ++)
        {
            for(int j = 1;j < n;j ++)
            {
                record[i][j] = record[i - 1][j] + record[i][j - 1];
            }
        }
        return record[m - 1][n - 1];
    }
};
