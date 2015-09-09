class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<bool> column(n, false);
        vector<bool> diag1(2 * n + 1, false);
        vector<bool> diag2(2 * n + 1, false);
        vector<vector<string>> result;
        vector<int> record;
        search(result, record, column, diag1, diag2, 0);
        return result;
    }
    
    void search(vector<vector<string>>& result, vector<int>& record, vector<bool>& column,
                vector<bool>& diag1, vector<bool>& diag2, int rowIndex) {
        int n = column.size();
        if (rowIndex ==n) {
            vector<string> tempResult;
            for (int i = 0; i < n; ++i) {
                string rowString = "";
                for (int j = 0; j < n; ++j) {
                    if (record[i] == j) rowString += "Q";
                    else rowString += ".";
                }
                tempResult.push_back(rowString);
            }
            result.push_back(tempResult);
        } else {
            for (int i = 0; i < n; ++i) {
                if (!column[i] && !diag1[rowIndex + i] && !diag2[rowIndex + n - 1 - i]) {
                    column[i] = true;
                    diag1[rowIndex + i] = true;
                    diag2[rowIndex + n - 1 - i] = true;
                    record.push_back(i);
                    search(result, record, column, diag1, diag2, rowIndex + 1);
                    column[i] = false;
                    diag1[rowIndex + i] = false;
                    diag2[rowIndex + n - 1 - i] = false;
                    record.erase(record.end() - 1);
                }
            }
        } 
    }
};