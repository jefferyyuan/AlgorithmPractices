class Solution {
public:
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        vector<vector<int>> record (s.length(), vector<int>(s.length(), 0));
        return search(wordDict, s, record, 0, s.length() - 1);
    }
    
    bool search(unordered_set<string>& wordDict, string s, vector<vector<int>>& record, int start, int end) {
        if (start > end) return true;
        if (record[start][end] != 0) return record[start][end] > 0;
        for (int i = start; i <= end; ++i) {
            string temp = s.substr(start, i - start + 1);
            if (wordDict.find(temp) != wordDict.end() && search(wordDict, s, record, i + 1, end)) {
                record[start][end] = 1;
                return true;
            }
        }
        record[start][end] = -1;
        return false;
    } 
};