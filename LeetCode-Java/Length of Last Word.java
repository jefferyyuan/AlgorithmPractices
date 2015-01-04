public class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int result = 0;
        while(index >= 0 && s.charAt(index) == ' ')
            index --;
        while(index >= 0)
        {
            if(s.charAt(index) == ' ')
                break;
            result ++;
            index --;
        }
        return result;
    }
}