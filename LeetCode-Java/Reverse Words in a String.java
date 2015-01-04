public class Solution {
    public String reverseWords(String s) {
        String result = "";
        int startIndex = s.length()-1;
        int endIndex = startIndex;
        while(startIndex >= 0)
        {
            while(startIndex >= 0 && s.charAt(startIndex) == ' ')
            {
                startIndex --;
            }
            if(startIndex < 0) break;
            endIndex = startIndex - 1;
            while(endIndex >= 0 && s.charAt(endIndex) != ' ')
                endIndex --;
            if(result.length() == 0)
                result += s.substring(endIndex + 1, startIndex + 1);
            else
                result += " " + s.substring(endIndex + 1, startIndex + 1);
            startIndex = endIndex;
        }
        return result;
    }
}