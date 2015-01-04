public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int m = s.length();
        int[] val = new int[m];
        for(int i = 0;i < m;i ++)
            val[i] = (int)s.charAt(i) - (int)'0';
        int[] record = new int[m];
        for(int i = 0;i < m;i ++)
        {
            int tempResult = 0;
            if(val[i] > 0)
            {
                if(i - 1 >= 0)
                    tempResult += record[i - 1];
                else
                    tempResult += 1;
            }
            if(i - 1 >= 0 && 10 * val[i - 1] + val[i] >= 10 && 10 * val[i - 1] + val[i] <= 26)
            {
                if(i - 2 >= 0)
                    tempResult += record[i - 2];
                else
                    tempResult += 1;
            }
            record[i] = tempResult;
        }
        return record[m - 1];
    }
}