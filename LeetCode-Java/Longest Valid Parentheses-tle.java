public class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int m = s.length();
        boolean[][] record = new boolean[m][m];
        for(int i = 1;i < m;i += 2)
        {
            for(int j = 0; j + i < m;j ++)
            {
                if(s.charAt(j) == '(' && s.charAt(j + i) == ')')
                {
                    if(j + 1 >= j + i -1 || record[j + 1][j + i - 1])
                    {
                        record[j][j + i] = true;
                        maxLength = Math.max(maxLength, i + 1);
                    }
                    else
                        record[j][j + i] = false;
                }
                else
                    record[j][j + i] = false;
            }
        }
        return maxLength;
    }
}