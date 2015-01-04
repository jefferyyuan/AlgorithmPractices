// pruning is very important, to ignore duplicate search
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        boolean[] isPossible = new boolean[s.length()];
        for(int i = 0;i < isPossible.length;i ++)
            isPossible[i] = true;
        if(s == null || s.length() == 0 || dict.isEmpty())
            return result;
        List<String> record = new ArrayList<String>();
        wordBreakPart(s, 0, dict, record, result,isPossible);
        return result;
    }
    
    public void wordBreakPart(String s,int index,Set<String> dict, List<String> record, List<String> result, boolean[] isPossible)
    {
        if(index == s.length())
        {
            StringBuffer tempResult = new StringBuffer();
            for(int i = 0;i < record.size();i ++)
            {
                if(i > 0)
                    tempResult.append(" ");
                tempResult.append(record.get(i));
            }
            result.add(tempResult.toString());
        }
        else
        {
            if(!isPossible[index]) return;
            int preSize = result.size();
            for(int i = index + 1;i <= s.length();i ++)
            {
                String temp = s.substring(index, i);
                if(dict.contains(temp))
                {
                    record.add(temp);
                    wordBreakPart(s, i, dict, record, result,isPossible);
                    record.remove(record.size() - 1);
                }
            }
            if(preSize == result.size())
                isPossible[index] = false;
        }
    }
}