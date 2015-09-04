class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<vector<int>> record(2, vector<int>(n + 1, INT_MAX));
        int current_index = 0;
        record[current_index][1] = triangle[0][0];
        for (int i = 2; i <= n; ++i) {
            int pre_index = current_index;
            current_index = 1 - current_index;
            for (int j = 1; j <= i; ++j) {
                record[current_index][j] = min(record[pre_index][j - 1], record[pre_index][j]) + triangle[i -1][j - 1];
            }
        }
        int result = INT_MAX;
        for (int i = 1; i<= n; ++i) {
            result = min(result, record[current_index][i]);
        }
        return result;
    }
    
};