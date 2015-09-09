class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (board.size() == 0) return false;
        int n = board.size(), m = board[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (search(board, visited, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    bool search(vector<vector<char>>& board, vector<vector<bool>>& visited, string word, int index, int x, int y) {
        if (index == word.length()) return true;
        int n = board.size(), m = board[0].size();
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (visited[x][y] || board[x][y] != word[index]) return false;
        int step[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        visited[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            if (search(board, visited, word, index + 1, x + step[i][0], y + step[i][1])) return true;
        }
        visited[x][y] = false;
        return false;
    }
};