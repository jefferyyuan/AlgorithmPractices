public class Solution {
    public int[][] generateMatrix(int n) {
        int[] addX = { 0, 1, 0, -1};
        int[] addY = { 1, 0, -1, 0};
        int mod = 4;
        int start = 0;
        int[][] result = new int[n][n];
        for(int i = 0;i < n;i ++)
        {
            for(int j = 0;j < n;j ++)
            {
                result[i][j] = -1;
            }
        }
        int x = 0,y = 0;
        for(int i = 0;i < n * n;i ++)
        {
            result[x][y] = i + 1;
            if( x + addX[start] >= n
                || x + addX[start] < 0
                || y + addY[start] >= n
                || y + addY[start] < 0
                || result[x + addX[start]][y + addY[start]] >= 0 )
            {
                start = (start + 1) % mod;
            }
            x += addX[start];
            y += addY[start];
        }
        return result;
    }
}