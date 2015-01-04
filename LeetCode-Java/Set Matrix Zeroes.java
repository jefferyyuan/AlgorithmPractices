public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = 0;
        if(m > 0) n = matrix[0].length;
        int recordM = -1, recordN = -1;
        for(int i = 0;i < m;i ++)
        {
            for(int j = 0;j < n;j ++)
            {
                if(matrix[i][j] == 0 && recordM < 0 && recordN < 0)
                {
                    recordM = i;
                    recordN = j;
                    break;
                }
                else if(matrix[i][j] == 0)
                {
                    matrix[i][recordN] = 0;
                    matrix[recordM][j] = 0;
                }
            }
        }
        if(recordM < 0 || recordN < 0)
            return;
        for(int i = 0;i < m;i ++)
        {
            if(i == recordM) continue;
            for(int j = 0;j < n;j ++)
            {
                if(j == recordN) continue;
                if(matrix[i][recordN] == 0 || matrix[recordM][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        for(int i = 0;i < m;i ++)
        {
            matrix[i][recordN] = 0;
        }
        for(int j = 0;j < n;j ++)
        {
            matrix[recordM][j] = 0;
        }
        return;
    }
}