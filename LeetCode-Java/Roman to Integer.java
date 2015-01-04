public class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> valueMap = new HashMap<Character,Integer>();
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);
        int result = 0;
        for(int i = 0;i < s.length();i ++)
        {
            if(i == s.length() - 1 || valueMap.get(s.charAt(i)) >= valueMap.get(s.charAt(i + 1)))
                result += valueMap.get(s.charAt(i));
            else
            {   
                result += valueMap.get(s.charAt(i + 1)) - valueMap.get(s.charAt(i));
                i ++;
            }
        }
        return result;
        
    }
}