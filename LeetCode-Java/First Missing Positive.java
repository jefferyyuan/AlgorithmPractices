public class Solution {
    public int firstMissingPositive(int[] A) {
        int index = 0;
        while(index < A.length)
        {
            if(A[index] <= 0 || A[index] > A.length)
            {
                A[index] = -1;
                index ++;
            }
            else if(A[index] == index + 1)
            {
                index ++;
            }
            else if(A[index] != index + 1)
            {
                if(A[A[index] - 1] == A[index])
                {
                    A[index] = -1;
                    index ++;
                }
                else
                {
                    int temp = A[index];
                    A[index] = A[A[index] - 1];
                    A[temp - 1] = temp;
                }
            }
        }
        for(index = 0;index < A.length;index ++)
        {
            if(A[index] != index + 1)
                return index + 1;
        }
        return index + 1;
    }
}