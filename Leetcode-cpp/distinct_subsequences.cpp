class Solution {
public:
    int numDistinct(string s, string t) {
        if (s.length() == 0 || t.length() == 0) return 0;
        vector<vector<int>> record(s.length(), vector<int>(t.length(), 0));
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= min((int)t.length() - 1, i); ++j) {
                if (i > 0) record[i][j] += record[i - 1][j];
                if (s[i] == t[j]) {
                    if (i > 0 && j > 0) record[i][j] += record[i - 1][j - 1];
                    else record[i][j]++;
                }
            }
        }
        return record[s.length() - 1][t.length() - 1];
    }
};