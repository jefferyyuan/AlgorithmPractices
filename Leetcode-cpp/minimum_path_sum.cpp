class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> record;
        for (int i = 0; i < 2; ++i) record.push_back(vector<int>(n, 0));
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += grid[0][i];
            record[0][i] = sum;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0) {
                    record[i % 2][j] = record[(i + 1) % 2][j] + grid[i][j];
                } else {
                    record[ i % 2][j] = min(record[(i + 1) % 2][j], record[i % 2][j - 1]) + grid[i][j];
                }
            }
        }
        return record[(m - 1) % 2][n - 1];
    }
};