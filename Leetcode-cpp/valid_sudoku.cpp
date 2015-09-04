class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<vector<bool>> column(9, vector<bool>(9, false));
        vector<vector<bool>> row(9, vector<bool>(9, false));
        vector<vector<bool>> grid(9, vector<bool>(9, false));
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                int val = board[i][j] - '1';
                if (row[i][val]) return false;
                row[i][val] = true;
                if (column[j][val]) return false;
                column[j][val] = true;
                int grid_index = (i / 3) * 3 + (j / 3);
                if (grid[grid_index][val]) return false;
                grid[grid_index][val] = true;
            }
        }
        return true;
    }
};