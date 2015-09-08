class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        vector<vector<bool>> record(s1.length() + 1, vector<bool>(s2.length() + 1, true));
        for (int i = 0; i < s1.length(); ++i) {
            record[i + 1][0] = (s1[i] == s3[i] && record[i][0]);
        }
        for (int i = 0; i < s2.length(); ++i) {
            record[0][i + 1] = (s2[i] == s3[i] && record[0][i]);
        }
        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                if ((s1[i] == s3[i + j + 1] && record[i][j + 1]) || 
                    (s2[j] == s3[i + j + 1] && record[i + 1][j])) {
                    record[i + 1][j + 1] = true;
                } else {
                    record[i + 1][j + 1] = false;
                }
            }
        }
        return record[s1.length()][s2.length()];
    }
};