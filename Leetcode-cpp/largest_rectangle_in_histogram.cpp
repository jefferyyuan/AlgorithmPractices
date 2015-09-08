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
};