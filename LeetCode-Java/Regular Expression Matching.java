public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatchPart(s, 0, p ,0);
    }
    
    public boolean isMatchPart(String s, int index1, String p, int index2)
    {
        if(index1 >= s.length() && index2 >= p.length()) return true;
        if(index1 >= s.length())
        {
            while(index2 < p.length())
            {
                if(index2 + 1 >= p.length() || Character.compare(p.charAt(index2 + 1),'*') != 0)
                    return false;
                index2 += 2;
            }
            return true;
        }
        if(index2 >= p.length())
            return false;
        
        // four different cases
        // first: normal
        if(p.charAt(index2) != '.' && (index2 == p.length() - 1 || p.charAt(index2 + 1) != '*'))
        {
            if(s.charAt(index1) == p.charAt(index2))
                return isMatchPart(s,index1 + 1, p, index2 + 1);
            else
                return false;
        }
        // second: normal + *
        else if(p.charAt(index2) != '.' && p.charAt(index2 + 1) == '*')
        {
            
            if(isMatchPart(s, index1, p, index2 + 2))
                return true;
            if(s.charAt(index1) == p.charAt(index2))
                return isMatchPart(s,index1 + 1, p, index2);
            else
                return false;
        }
        // third : .
        else if(p.charAt(index2) == '.' && (index2 == p.length() - 1 || p.charAt(index2 + 1) != '*'))
        {
            return isMatchPart(s, index1 + 1, p, index2 + 1);
        }
        // fourth: . + *
        else
        {
            if(isMatchPart(s, index1, p, index2 + 2))
                return true;
            else
            {
                while(true)
                {
                    index1 ++;
                    if(isMatchPart(s, index1, p, index2 + 2))
                        return true;
                    if(index1 >= s.length())
                        break;
                }
                return false;
            }
        }
    }

}