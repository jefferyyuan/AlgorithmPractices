public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() < 2)
            return 0;
        boolean[][] judgeRecord = new boolean[s.length()][s.length()];
        for(int i = 0;i < s.length();i ++)
        {
            for(int j = 0;j + i < s.length();j ++)
            {
                if(i == 0)
                    judgeRecord[j][j + i] = true;
                else if(i == 1)
                    judgeRecord[j][j + i] = (s.charAt(j) == s.charAt(j + i));
                else
                    judgeRecord[j][j + i] = (s.charAt(j) == s.charAt(j + i)) && judgeRecord[j + 1][j + i - 1];
            }
        }
        int[] minRecord = new int[s.length()];
        for(int i = s.length() - 1;i >= 0;i --)
        {
            if(judgeRecord[i][s.length() -1])
                minRecord[i] = 0;
            else
            {
                int tempResult = s.length() - i;
                for(int j = i;j < s.length() - 1;j ++)
                {
                    if(judgeRecord[i][j])
                        tempResult = Math.min(tempResult, minRecord[j + 1] + 1);
                }
                minRecord[i] = tempResult;
            }
        }
        return minRecord[0];
    }
}