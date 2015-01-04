public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)
            return 0;
        char c = s.charAt(0);
        int index = 1;
        while(index < s.length() && s.charAt(index) == c)
            index ++;
        if(index == s.length())
            return s.length();
        char t = s.charAt(index);
        int lastC = index - 1;
        int lastT = index;
        int result = 0;
        int start = 0;
        for(int i = index + 1;i < s.length();i ++){
            if(s.charAt(i) == c)
                lastC = i;
            else if(s.charAt(i) == t)
                lastT = i;
            else{
                int tempResult = i - start;
                result = Math.max(result, tempResult);
                if(lastC < lastT){
                    c = s.charAt(i);
                    start = lastC + 1;
                    lastC = i;
                }
                else{
                    t=  s.charAt(i);
                    start = lastT + 1;
                    lastT = i;
                }
            }
        }
        result = Math.max(result, s.length() - start);
        return result;
    }
}