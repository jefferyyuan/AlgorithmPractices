class Solution {
public:
    void sortColors(int A[], int n) {
        int white_start = 0;
        int white_end = n - 1;
        for(int i = 0;i < n;i ++)
        {
            if(i > white_end) break;
            if(A[i] == 0)
            {
                if(i == white_start)
                {
                    white_start ++;
                }
                else
                {
                    int temp = A[i];
                    A[i] = A[white_start];
                    A[white_start] = temp;
                    white_start ++;
                    i --;
                }
            }
            else if(A[i] == 2)
            {
                if(i == white_end)
                {
                    white_end --;
                }
                else
                {
                    int temp = A[i];
                    A[i] = A[white_end];
                    A[white_end] = temp;
                    white_end --;
                    i --;  
                }
            }
        }
    }
};
