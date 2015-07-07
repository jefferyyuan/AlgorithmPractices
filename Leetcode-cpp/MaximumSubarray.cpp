class Solution {
public:
    int maxSubArray(int A[], int n) {
        int pre = 0;
        int max = A[0];
        for(int i = 1;i <= n;i ++)
        {
            if(pre >= 0) pre += A[i - 1];
            else pre = A[i- 1];
            max = max > pre ? max : pre;
        }
        return max;
    }
};
