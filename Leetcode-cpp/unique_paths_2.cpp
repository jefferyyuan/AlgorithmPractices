class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        vector<int> record(n, 0);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    record[j] = 1 - obstacleGrid[i][j];
                } else if (i == 0) {
                    record[j] = record[j - 1] > 0 && obstacleGrid[i][j] == 0 ? 1 : 0;
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        record[j] = 0;
                    }  else {
                        record[j] += record[j - 1];
                    }
                }
            }
        }
        return record[n - 1];
    }
};