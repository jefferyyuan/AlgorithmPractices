class Solution {
public:
    vector<int> grayCode(int n) {
        int ref[] = {0, 1, 1, 0};
        vector<int> result;
        for (int i = 0; i < (1 << n); ++i) {
            int tempResult = 0;
            for (int j = 0; j < n; ++j) {
                tempResult += (1 << j) * ref[(i / (1 << j)) % 4];
            }
            result.push_back(tempResult);
        }
        return result;
    }
};