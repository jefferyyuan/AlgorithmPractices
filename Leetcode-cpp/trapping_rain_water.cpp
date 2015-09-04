class Solution {
public:
    int trap(vector<int>& height) {
        int result = 0;
        stack<pair<int ,int>> record;
        for (int i = 0; i < height.size(); ++i) {
            int record_pos = i;
            while (!record.empty() && record.top().second < height[i]) {
                int pos = record.top().first;
                int val = record.top().second;
                record.pop();
                if (record.empty()) break;
                result += (i - pos) * (min(height[i], record.top().second) - val);
                record_pos = pos;
            }
            record.push(make_pair(record_pos, height[i]));
        }
        return result;
    }
};