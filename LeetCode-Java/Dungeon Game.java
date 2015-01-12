//  storage could be optimized
//  DP from destination back to start point
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = 0;
        if(m > 0)
            n = dungeon[0].length;
        int[][] record = new int[m][n];
        record[m - 1][n - 1] = Math.max(1, 1 - (dungeon[m - 1][n - 1]));
        for(int i = m - 2;i >= 0;i --)
            record[i][n - 1] = Math.max(1, record[i + 1][n - 1] - dungeon[i][n - 1]);
        for(int i = n - 2;i >= 0;i --)
            record[m - 1][i] = Math.max(1, record[m - 1][i + 1] - dungeon[m- 1][i]);
        for(int i = n - 2;i >= 0;i --){
            for(int j = m - 2;j >= 0;j --){
                record[j][i] = Math.max(1, Math.min(record[j + 1][i], record[j][i + 1]) - dungeon[j][i]);
            }
        }
        if(record[0][0] <= 0)
            return 1;
        else
            return record[0][0];
    }
}