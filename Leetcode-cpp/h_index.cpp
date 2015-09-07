class Solution {
public:
    int hIndex(vector<int>& citations) {
        vector<int> record(citations.size(), 0);
        for (auto val : citations) {
            if (val > 0) {
                record[min(val, (int)citations.size()) - 1]++;
            }
        }
        int count = 0;
        for (int i = record.size() - 1; i >= 0; --i) {
            count += record[i];
            if (count >= i + 1) return i + 1;
        }
        return 0;
    }
};