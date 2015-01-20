//  first time
/*
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
*/

//  second time
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int value1 = 1;
        int value2 = 1;
        for(int i = 1;i < s.length(); i ++){
            int result = 0;
            int c0 = s.charAt(i) - '0';
            if(c0 != 0)
                result += value2;
            int c1 = s.charAt(i - 1) - '0';
            int value = c1 * 10 + c0;
            if(value >= 10 && value <= 26)
                result += value1;
            value1 = value2;
            value2 = result;
        }
        return value2;
    }
}
