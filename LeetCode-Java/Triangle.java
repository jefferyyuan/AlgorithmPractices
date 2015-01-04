public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] record = new int[2][m];
        int turn = 0;
        record[0][0] = triangle.get(0).get(0);
        for(int i = 1;i < m;i ++)
        {
            List<Integer> tempList = triangle.get(i);
            int[] current = record[turn];
            int[] next = record[1 - turn];
            for(int j = 0;j <= i;j ++)
            {
                if(j == 0)
                {
                    next[j] = current[j] + tempList.get(j);
                }
                else if(j == i)
                {
                    next[j] = current[j - 1] + tempList.get(j);
                }
                else
                {
                    next[j] = Math.min(current[j], current[j - 1]) + tempList.get(j);
                }
            }
            turn = 1 - turn;
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0;i < m;i ++)
        {
            result = Math.min(record[turn][i], result);
        }
        return result;
    }
}