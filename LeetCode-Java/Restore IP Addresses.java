public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        restorePart(s, 0, 4, "", result);
        return result;
    }
    
    void restorePart(String s, int index, int count, String pre, List<String> result)
    {
        if(s.length() - index > 3 * count || s.length() - index < count)
            return;
        if(count == 1)
        {
            if(isValid(s.substring(index)))
            {
                String tempResult = pre + "." + s.substring(index);
                result.add(tempResult);
                return;
            }
            else
                return;
        }
        else
        {
            for(int i = index + 1;i <= Math.min(index + 3,s.length());i ++)
            {
                String tempString = new String(pre);
                if(count != 4)
                    tempString = tempString + ".";
                if(isValid(s.substring(index,i)))
                    restorePart(s,i,count - 1,tempString + s.substring(index,i), result);
            }
            return;
        }
    }
    
    boolean isValid(String val)
    {
        if(val.length() == 0 || val.length() > 3)
            return false;
        else if(val.charAt(0) == '0' && val.length() > 1)
            return false;
        else if(Integer.valueOf(val) <= 255)
            return true;
        else
            return false;
    }
}