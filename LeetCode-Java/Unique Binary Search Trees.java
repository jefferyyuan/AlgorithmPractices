public class Solution {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        for(int i = 0;i <= n;i ++)
        {
            if(i == 0 || i == 1) result[i] = 1;
            else
            {
                result[i] = 0;
                for(int j = 1; j <= i;j ++)
                {
                    result[i] += result[j - 1] * result[i - j];
                }
            }
        }
        return result[n];
    }
}