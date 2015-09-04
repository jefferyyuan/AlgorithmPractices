class Solution {
public:
    vector<int> getRow(int row_index) {
        vector<int> result;
        for (int i = 0; i <= row_index; ++i) {
            if (i == 0) result.push_back(1);
            else if (i == 1) result.push_back(row_index);
            else if (i <= row_index / 2) {
                long old_value = result[i - 1];
                old_value *= (row_index - (i - 1));
                old_value /= i;
                result.push_back((int)old_value);
            } else {
                result.push_back(result[row_index - i]);
            }
        }
        return result;
    }
};