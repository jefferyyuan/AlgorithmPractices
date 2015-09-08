class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        vector<vector<bool>> column(9, vector<bool>(9, false));
        vector<vector<bool>> row(9, vector<bool>(9, false));
        vector<vector<bool>> grid(9, vector<bool>(9, false));
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 9; ++y) {
                if(board[x][y] != '.') {
                    int grid_index = (x / 3) * 3 + y / 3;
                    int val = board[x][y] - '1';
                    row[x][val] = true;
                    column[y][val]= true;
                    grid[grid_index][val] = true;
                }
            }
        }
        search(board, column, row, grid, 0);
    }
    bool search(vector<vector<char>>& board, vector<vector<bool>>& column,
                vector<vector<bool>>& row, vector<vector<bool>>& grid, int index) {
        int n = board.size(), m = board[0].size();
        if (index == n * m) return true;
        int x = index / m, y = index % m;
        if(board[x][y] != '.') {
            return search(board, column, row, grid, index + 1);
        } else {
            int grid_index = (x / 3) * 3 + y / 3;
            for (int i = 0; i < 9; ++i) {
                if (!row[x][i] && !column[y][i] && !grid[grid_index][i]) {
                    row[x][i] = true;
                    column[y][i]= true;
                    grid[grid_index][i] = true;
                    board[x][y] = '1' + i;
                    if (search(board, column, row, grid, index + 1)) return true;
                    row[x][i] = false;
                    column[y][i]= false;
                    grid[grid_index][i] = false;
                    board[x][y] = '.';
                }
            }
            return false;
        }
    }
};