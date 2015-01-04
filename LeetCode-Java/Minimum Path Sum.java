public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = 0;
        if(m > 0)n = grid[0].length;
        int[][] record = new int[m][n];
        record[0][0] = grid[0][0];
        for(int i = 1;i < m;i ++) 
            record[i][0] = grid[i][0] + record[i - 1][0];
        for(int i = 1;i < n;i ++)
            record[0][i] = grid[0][i] + record[0][i - 1];
        for(int i = 1;i < m;i ++)
        {
            for(int j = 1;j < n;j ++)
            {
                record[i][j] = Math.min(record[i - 1][j],record[i][j - 1]) + grid[i][j];
            }
        }
        return record[m - 1][n - 1];
    }
}