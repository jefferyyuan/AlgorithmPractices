class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        int startIndex = 0, endIndex = m * n - 1;
        while (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            if (getValue(matrix, midIndex) < target)
                startIndex = midIndex + 1;
            else
                endIndex = midIndex;
        }
        return getValue(matrix, startIndex) == target;
    }
    int getValue(vector<vector<int>>& matrix, int index) {
        int n = matrix[0].size();
        return matrix[index / n][index % n];
    }
};