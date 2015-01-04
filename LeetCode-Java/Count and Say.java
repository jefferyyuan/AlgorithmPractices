public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        while(n > 1)
        {
            String newResult = "";
            int count = 1;
            char preChar = result.charAt(0);
            for(int i = 1;i <= result.length();i ++)
            {
                if(i == result.length() || result.charAt(i) != preChar)
                {
                    newResult += String.valueOf(count);
                    newResult += String.valueOf(preChar);
                    if(i != result.length())
                    {
                        count = 1;
                        preChar = result.charAt(i);
                    }
                }
                else
                    count ++;
            }
            result = newResult;
            n --;
        }
        return result;
    }
}