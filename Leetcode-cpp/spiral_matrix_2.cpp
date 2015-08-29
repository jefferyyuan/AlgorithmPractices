class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> result(n, vector<int>(n, 0));
        int direction[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int current_direction = 0;
        int current_x = 0, current_y = 0;
        for (int i = 1; i <= n * n; ++i) {
            result[current_x][current_y] = i;
            if (!isValid(current_x + direction[current_direction][0], current_y + direction[current_direction][1], result, n)) {
                 current_direction = (current_direction + 1) % 4;   
            } 
            current_x += direction[current_direction][0];
            current_y += direction[current_direction][1];
        }
        return result;
    }
    
    bool isValid(int x, int y, vector<vector<int>>& result, int n) {
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= n) return false;
        if (result[x][y] > 0) return false;
        return true;
    }
};