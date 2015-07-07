class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int realIndex = -1;
        for(int i = 0;i < n;i ++)
        {
            if(A[i] != elem)
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
