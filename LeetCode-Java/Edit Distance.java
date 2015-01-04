public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] record = new int[m + 1][n + 1];
        record[0][0] = 0;
        for(int i = 1;i <= m;i ++)
        {
            record[i][0] = i;
        }
        for(int i = 1;i <= n;i ++)
        {
            record[0][i] = i;
        }
        for(int i = 1;i <= m;i ++)
        {
            for(int j = 1;j <= n;j ++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    record[i][j] = record[i - 1][j - 1];
                else
                {
                    int val = record[i - 1][j - 1];
                    val = Math.min(val, record[i][j - 1]);
                    val = Math.min(val, record[i - 1][j]);
                    record[i][j] = val + 1;
                }
            }
        }
        return record[m][n];
    }
}