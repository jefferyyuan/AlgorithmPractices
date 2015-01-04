public class Solution {
    public int numDistinct(String S, String T) {
        if(S == null || T == null || S.length() == 0 || T.length() == 0)
            return 0;
        int m = S.length(), n = T.length();
        int[][] record = new int[m + 1][n + 1];
        for(int i = 0;i <= m;i ++)
            record[i][n] = 1;
        for(int i = 0;i < n;i ++)
            record[m][i] = 0;
        for(int i = m - 1;i >= 0; i --)
        {
            for(int j = n - 1;j >= 0;j --)
            {
                if(S.charAt(i) == T.charAt(j))
                    record[i][j] = record[i + 1][j + 1] + record[i + 1][j];
                else
                    record[i][j] = record[i + 1][j];
            }
        }
        return record[0][0];
    }
}