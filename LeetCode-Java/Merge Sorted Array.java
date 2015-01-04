public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int AIndex = m - 1, BIndex = n - 1;
        int finalIndex = m + n - 1;
        while(finalIndex >= 0)
        {
            if(AIndex < 0)
            {
                while(BIndex >= 0)
                {
                    A[finalIndex] = B[BIndex];
                    finalIndex --;
                    BIndex --;
                }
            }
            else if(BIndex < 0)
            {
                while(AIndex >= 0)
                {
                    A[finalIndex] = A[AIndex];
                    finalIndex --;
                    AIndex --;
                }
            }
            else
            {
                if(A[AIndex] <= B[BIndex])
                {
                    A[finalIndex] = B[BIndex];
                    finalIndex --;
                    BIndex --;
                }
                else
                {
                    A[finalIndex] = A[AIndex];
                    finalIndex --;
                    AIndex --;
                }
            }
        }
        return;
    }
}