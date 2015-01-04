public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        int m = s.length();
        if(m <= 1) return 0;
        int[] record = new int[m];
        record[0] = -1;
        for(int i = 1;i < m;i ++)
        {
            if(record[i - 1] == -1)
            {
                int tempResult = -1;
                if( s.charAt(i) == ')' && s.charAt(i - 1) == '(')
                {
                    tempResult = i - 1;
                    if(i - 2 >= 0 && record[i - 2] >= 0)
                        tempResult = record[i - 2];
                }
                record[i] = tempResult;
            }
            else
            {
                int index = record[i - 1] - 1;
                if(index < 0 || !(s.charAt(index) == '(' && s.charAt(i) == ')'))
                    record[i] = -1;
                else
                {
                    record[i] = index;
                    if(index - 1 >= 0 && record[index - 1] >= 0)
                        record[i] = record[index  - 1];
                }
            }
        }
        int maxLength = 0;
        for(int i = 0;i < m;i ++)
        {
            if(record[i] >= 0)
                maxLength = Math.max(maxLength, i - record[i] + 1);
        }
        return maxLength;
    }
}