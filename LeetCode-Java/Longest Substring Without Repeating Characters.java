public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        HashMap<Character,Integer> record = new HashMap<Character,Integer>();
        int currentMax = 1;
        int result = 1;
        record.put(s.charAt(0), 0);
        for(int i = 1;i < s.length();i ++)
        {
            char val = s.charAt(i);
            int lastIndex = -1;
            if(record.containsKey(val))
                lastIndex = record.get(val);
            currentMax = Math.min(currentMax + 1, i - lastIndex);
            result = Math.max(currentMax, result);
            record.put(val, i);
        }
        return result;
    }
}