class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n == 0) return 0;
        int realIndex = 0;
        for(int i = 1;i < n;i ++)
        {
            if(A[i] == A[realIndex]) continue;
            else
            {
                realIndex ++;
                int temp = A[i];
                A[i] = A[realIndex];
                A[realIndex] = temp;
            }
        }
        return realIndex + 1;
        
    }
};
