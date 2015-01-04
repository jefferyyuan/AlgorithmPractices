public class Solution {
    public int atoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        long result = 0;
        boolean isValid = true;
        boolean isPositive = true;
        int index = 0;
        
        //ignore white space
        while(index < str.length() && str.charAt(index) == ' ') index ++;
            
        //check first character
        if(index >= str.length())
            return (int)result;
        else if(str.charAt(index) == '-')
        {
            isPositive = false;
            index ++;
        }
        else if(str.charAt(index) == '+')
        {
            index ++;
        }
        else if(str.charAt(index) < '0' || str.charAt(index) > '9')
            return (int)result;
        
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9')
        {
            result = result * 10 + (int)str.charAt(index) - (int)'0';
            if(isPositive && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(!isPositive && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            
            index ++;
        }
        if(!isPositive) result = -result;
        return (int)result;
    }
}