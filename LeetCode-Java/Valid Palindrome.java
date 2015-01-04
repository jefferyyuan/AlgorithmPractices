public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return true;
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while(start < end)
        {
            if(!isValid(s.charAt(start)))
                start ++;
            else if(!isValid(s.charAt(end)))
                end --;
            else
            {
                if(Character.compare(s.charAt(start), s.charAt(end)) != 0)
                    return false;
                else
                {
                    start ++;
                    end --;
                }
            }
        }
        return true;
    }
    
    boolean isValid(char c)
    {
        if((Character.compare(c, 'a') >= 0 && Character.compare(c, 'z') <= 0)
            || (Character.compare(c, '0') >= 0 && Character.compare(c, '9') <= 0))
            return true;
        else
            return false;
    }
}