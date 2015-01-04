public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int unit = 1;
        for(int i = s.length() -1 ;i >= 0;i --)
        {
            result += (s.charAt(i) - 'A' + 1) * unit;
            unit *= 26;
        }
        return result;
    }
}