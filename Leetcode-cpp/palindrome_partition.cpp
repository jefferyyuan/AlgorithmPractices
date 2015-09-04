class Solution {
public:
    vector<vector<string>> partition(string s) {
        int n = s.length();
        vector<vector<bool>> record(n, vector<bool>(n, false));
        for (int i = 0; i < n; ++i) {
            int left = i, right = i;
            while (left >= 0 && right < n && s[left] == s[right]) record[left--][right++] = true;
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s[left] == s[right]) record[left--][right++] = true;
        }
        vector<pair<int, int>> tempResult;
        vector<vector<string>> result;
        search(s, result, record, tempResult, 0);
        return result;
        
    }
    
    void search(string& s, vector<vector<string>>& result, vector<vector<bool>>& record, vector<pair<int, int>>& tempResult, int startIndex) {
        if (startIndex == record.size()) {
            vector<string> current_result;
            for (int i = 0; i < tempResult.size(); ++i) {
                current_result.push_back(s.substr(tempResult[i].first, tempResult[i].second));
            }
            result.push_back(current_result);
        } else {
            for (int endIndex = startIndex; endIndex < record.size(); ++endIndex) {
                if (record[startIndex][endIndex]) {
                    tempResult.push_back(make_pair(startIndex, endIndex - startIndex + 1));
                    search(s, result, record, tempResult, endIndex + 1);
                    tempResult.erase(tempResult.end() - 1);
                }
            }
        }
    }
};