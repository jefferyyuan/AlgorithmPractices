class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> result;
        for(int i = 0;i < powInt(n);i ++)
        {
            int observe = 1;
            int tempResult = 0;
            for(int j = 0;j < n;j ++)
            {
                tempResult += rules(i / observe) * observe;
                observe *= 2;
            }
            result.push_back(tempResult);
        }
        return result;
    }
    int rules(int k)
    {
        if(k % 4 == 0 || k % 4 == 3) return 0;
        else return 1;
    }
    int powInt(int k)
    {
        int result = 1;
        for(int i = 0;i < k;i ++)
        {
            result *= 2;
        }
        return result;
    }
};
