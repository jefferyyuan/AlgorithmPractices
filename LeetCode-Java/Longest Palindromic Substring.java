public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() <= 1) return s;
        int m = s.length();
        boolean[][] record = new boolean[m][m];
        int maxStart = 0, maxEnd = 0;
        for(int i = 0;i < m;i ++)
        {
            for(int j = 0;j + i < m;j ++)
            {
                if(s.charAt(j) == s.charAt(j + i))
                {
                    if( j + i - 1 <= j + 1)
                        record[j][j + i] = true;
                    else
                        record[j][j + i] = record[j + 1][j + i - 1];
                }
                else
                {
                    record[j][j + i] = false;
                }
                if(record[j][j + i])
                {
                    maxStart = j;
                    maxEnd = j + i;
                }
                hasChange = hasChange || record[j][j + i];
                
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
    
}