// a lot of duplicate operations, should be optimized later...
public class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
        {
             List<List<String>> result = new ArrayList<List<String>>();
             return result;
        }
        int n = s.length();
        boolean[][] record = new boolean[n][n];
        for(int i = 0;i < n;i ++)
        {
            record[i][i] = true;
        }
        for(int i = 1;i <= n - 1;i ++)
        {
            for(int j = 0; j + i < n;j ++)
            {
                record[j][j + i] = (s.charAt(j) == s.charAt(j + i));
                if(i > 1)
                    record[j][j + i] = (record[j][j + i] && record[j + 1][j + i - 1]);
            }
        }
        return partitionPart(s, 0, record);
        
    }
    
    List<List<String>> partitionPart(String s, int index,boolean[][] record)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        int n = s.length();
        for(int i = index;i < n;i ++)
        {
            if(record[index][i])
            {
                if(i == n - 1)
                {
                    List<String> tempResult = new ArrayList<String>();
                    tempResult.add(s.substring(index));
                    result.add(tempResult);
                }
                else
                {
                    List<List<String>> nextResult = partitionPart(s, i + 1,record);
                    for(int j = 0;j < nextResult.size(); j ++)
                    {
                        List<String> tempResult = new ArrayList<String>();
                        tempResult.add(s.substring(index,i + 1));
                        tempResult.addAll(nextResult.get(j));
                        result.add(tempResult);
                    }
                }
            }
        }
        return result;
    }
}