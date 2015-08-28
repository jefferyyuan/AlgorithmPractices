class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<vector<string>> record;
        for (int i = 0; i <= n; ++i) {
            vector<string> tempRecord;
            if (i == 0) {
                tempRecord.push_back("");
            } else {
                for (int j = 0; j < i; ++j) {
                    for (int m = 0; m < record[j].size(); ++m) {
                        for (int n = 0; n < record[i - j - 1].size(); ++n) {
                            tempRecord.push_back("(" + record[j][m] + ")" + record[i - j - 1][n]);
                        }
                    }
                }
            }
            record.push_back(tempRecord);
        }
        return record[n];
    }
};