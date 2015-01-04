public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length())
            return false;
        if(m == 0) return s2.compareTo(s3) == 0;
        if(n == 0) return s1.compareTo(s3) == 0;
        boolean[][] record = new boolean[m + 1][n + 1];
        for(int i = m ;i >= 0;i --)
        {
            // use flag to terminate the iteration when no possible solution exists
            boolean tempResult = false;
            for(int j = n ;j >= 0;j --)
            {
                if(i == m && j == n)
                {   
                    record[i][j] = true;
                    tempResult = true;
                    continue;
                }
                int index = i + j;
                record[i][j] = false;
                if(i < m && s3.charAt(index) == s1.charAt(i) && record[i + 1][j])
                {
                    record[i][j] = true;
                    tempResult = true;
                    continue;
                }
                if(j < n && s3.charAt(index) == s2.charAt(j) && record[i][j + 1])
                    record[i][j] = true;
            }
            if(!tempResult) return false;
        }
        return record[0][0];
    }
}