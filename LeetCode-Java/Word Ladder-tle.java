public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        int m = dict.size() + 2;
        String[] bigDict = new String[m];
        bigDict[0] = start;
        bigDict[m - 1] = end;
        int index = 1;
        for(String s : dict)
        {
            bigDict[index ++] = s;
        }
        List<List<Integer>> record = new ArrayList<List<Integer>>();
        for(int i = 0;i < m;i ++)
        {
            ArrayList<Integer> tempRecord = new ArrayList<Integer>();
            for(int j = 0;j < m;j ++)
            {
                if(j == i) continue;
                String s1 = bigDict[i];
                String s2 = bigDict[j];
                if(s1.length() != s2.length())
                    continue;
                else
                {
                    int diffCount = 0;
                    for(int k = 0;k < s1.length();k ++)
                    {
                        if(s1.charAt(k) != s2.charAt(k))
                        {
                            diffCount ++;
                            if(diffCount > 1) break;
                        }
                    }
                    if(diffCount == 1)
                        tempRecord.add(j);
                }
            }
            record.add(tempRecord);
        }
        int[] result = new int[m];
        for(int i = 1;i < m;i ++)
            result[i] = -1;
        result[0] = 0;
        Stack<Integer> wordStack = new Stack<Integer>();
        wordStack.push(0);
        int count = 1;
        while(count > 0)
        {
            int newCount = 0;
            while(count > 0)
            {
                count --;
                int tempWord = wordStack.pop();
                for(int i = 0;i < record.get(tempWord).size();i ++)
                {
                    index = record.get(tempWord).get(i);
                    if(result[index] < 0  )
                    {
                        newCount ++;
                        result[index] = result[tempWord] + 1;
                        wordStack.push(index);
                        if(index == m - 1)
                            return result[index];
                    }
                }
            }
            count = newCount;
        }
        return -1;
        
    }
}