class Solution {
public:
    int largestRectangleArea(vector<int>& height) {
        stack<pair<int, int>> record;
        int result = 0;
        for (int i = 0; i < height.size(); ++i) {
            int new_index = i;
            while (!record.empty() && record.top().first > height[i]) {
                result = max(result, (i - record.top().second) * record.top().first);
                new_index = record.top().second;
                record.pop();
            }
            if (record.empty() || height[i] > record.top().first) {
                record.push(make_pair(height[i], new_index));
            } 
        }
        int n = height.size();
        while (!record.empty()) {
            result = max(result, (n - record.top().second) * record.top().first);
            record.pop();
        }
        return result;
    }
    int maximalRectangle(vector<vector<char>>& matrix) {
        if (matrix.size() == 0) return 0;
        int n = matrix.size();
        int m = matrix[0].size();
        vector<int> record(m, 0);
        int result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '1') record[j]++;
                else record[j] = 0;
            }
            result = max(result, largestRectangleArea(record));
        }
        return result;
    }
};