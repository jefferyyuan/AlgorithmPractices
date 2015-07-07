class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        for(int i = m + n - 1, a = m - 1, b = n - 1;i >= 0;i --)
        {
            if(b < 0 || (a >= 0 && A[a] > B[b]))
            {
                A[i] = A[a];
                a --;
            }
            else
            {
                A[i] = B[b];
                b --;
            }
        }
    }
};
