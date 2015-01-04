public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int[] record = new int[s.length()];
        for(int i = 0;i < s.length();i ++)
            record[i] = 0;
        return wordBreakPart(s, 0, dict, record);
    }
    
    boolean wordBreakPart(String s,int index, Set<String> dict,int[] record)
    {
        if(index >= s.length())
            return true;
        if(record[index] > 0)
            return true;
        if(record[index] < 0)
            return false;
        int head = index;
        for(;index < s.length();index++)
        {
            String tempString = s.substring(head,index + 1);
            if(dict.contains(tempString) && wordBreakPart(s, index + 1, dict, record) )
            {
                record[head] = 1;
                return true;
            }
        }
        record[head] = -1;
        return false;
    }
}