public class Solution {
    public String getPermutation(int n, int k) {
        int[] unit = new int[n + 1];
        unit[0] = 1;
        for(int i = 1;i <= n;i ++)
        {
            unit[i] = i * unit[i - 1];
        }
        k = (k - 1) % unit[n];
        boolean[] record = new boolean[n];
        for(int i = 0;i < n;i ++)
            record[i] = true;
        char[] resultArray = new char[n];
        for(int i = 0;i < n;i ++)
        {
            int val = k / unit[n - 1 - i];
            k = k % unit[n - 1 - i];
            char c = '1';
            for(int j = 0;j < n;j ++)
            {
                if(record[j]) 
                {
                    if(val == 0)
                    {
                        c = (char)((int)'1' + j);
                        record[j] = false;
                        break;
                    }
                    else
                    {
                        val --;
                    }
                }
            }
            resultArray[i] = c;
            
        }
        return String.valueOf(resultArray);
    }
}