public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int result = -1;
        for(int i = 0;i < haystack.length() - needle.length() + 1;i ++)
        {
            boolean isValid = true;
            for(int j = 0;j < needle.length();j ++)
            {
                if(Character.compare(haystack.charAt(i + j), needle.charAt(j)) != 0)
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
            {
                result = i;
                break;
            }
        }
        return result;
    }
}