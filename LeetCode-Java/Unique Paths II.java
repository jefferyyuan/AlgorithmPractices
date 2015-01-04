public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = 0;
        if(m > 0)n = obstacleGrid[0].length;
        int[] record = new int[n];
        //initialize
        record[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for(int i = 1;i < n;i ++) 
        {
            record[i] = obstacleGrid[0][i] == 0 ? record[i - 1] : 0;
        }
        for(int i = 1;i < m;i ++)
        {
            record[0] = obstacleGrid[i][0] == 0 ? record[0] : 0;
            for(int j = 1;j < n;j ++)
            {
                record[j] = obstacleGrid[i][j] == 0? (record[j] + record[j - 1]) : 0;
            }
        }
        return record[n - 1];
    }
}