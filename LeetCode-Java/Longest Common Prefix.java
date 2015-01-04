public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return new String("");
        int start = 0, end = strs[0].length();
        while(start < end)
        {
            int mid = (start + end) / 2;
            if(isCommonPrefix(strs, strs[0].substring(0, mid + 1)))
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        return strs[0].substring(0, start);
        
    }
    public boolean isCommonPrefix(String[] strs, String val)
    {
        for(int i = 0;i < strs.length;i ++)
        {
            if(!strs[i].startsWith(val))
                return false;
        }
        return true;
    }
}