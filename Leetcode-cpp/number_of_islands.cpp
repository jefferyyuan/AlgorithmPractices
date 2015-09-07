class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0) return 0;
        int result = 0;
        int n = grid.size(), m = grid[0].size();
        vector<vector<bool>> record(n, vector<bool>(m, false));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1' && !record[i][j]) {
                    result++;
                    search(grid, record, i, j);
                }
            }
        }
        return result;
    }
    
    void search(vector<vector<char>>& grid, vector<vector<bool>>& record, int x, int y) {
        int n = grid.size(), m = grid[0].size();
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (record[x][y] || grid[x][y] != '1') return;
        record[x][y] = true;
        search(grid, record, x - 1, y);
        search(grid, record, x + 1, y);
        search(grid, record, x, y + 1);
        search(grid, record, x, y - 1);
    }
};