class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
        vector<bool> record(n, false);
        generateCominbation(result, record, 0, k);
        return result;
    }
    void generateCominbation(vector<vector<int>>& result, vector<bool>& record, int index, int k) {
        if (k == 0) {
            vector<int> tempResult;
            for (int i = 0; i < record.size(); ++i) {
                if (record[i]) tempResult.push_back(i + 1);
            }
            result.push_back(tempResult);
        } else if (index < record.size()) {
            generateCominbation(result, record, index + 1, k);
            record[index] = true;
            generateCominbation(result, record, index + 1, k - 1);
            record[index] = false;
        }
    }
};