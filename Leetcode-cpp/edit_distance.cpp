class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> record(word1.length() + 1, vector<int>(word2.length() + 1, 0));
        for (int i = 0; i <= word1.length(); ++i) {
            record[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); ++j) {
            record[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                if (word1[i - 1] == word2[j - 1]) {
                    record[i][j] = record[i - 1][j - 1];
                } else {
                    record[i][j] = min(record[i][j - 1], record[i - 1][j]);
                    record[i][j] = min(record[i][j], record[i - 1][j - 1]);
                    record[i][j]++;
                }
            }
        }
        return record[word1.length()][word2.length()];
    }
};