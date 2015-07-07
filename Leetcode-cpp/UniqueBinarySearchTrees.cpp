class Solution {
public:
    int numTrees(int n) {
        vector<int> result;
        result.push_back(1);
        for(int i = 1;i <= n;i ++)
        {
            int cResult = 0;
            for(int j = 1;j <= i;j ++)
            {
                cResult += result[j - 1] * result[i - j ];
            }
            result.push_back(cResult);
        }
        return result[n];
    }
};
