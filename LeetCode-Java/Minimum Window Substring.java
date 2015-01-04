public class Solution {
    public String minWindow(String S, String T) {
        int minStartIndex = -1, minEndIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0, endIndex = 0;
        int diffCount = 0;
        HashMap<Character, Integer> record = new HashMap<Character, Integer>();
        for(int i = 0;i < T.length();i ++)
        {
            char c = T.charAt(i);
            if(!record.containsKey(c))
            {
                record.put(c, 1);
                diffCount ++;
            }
            else
            {
                int val = record.get(c);
                record.put(c, val + 1);
            }
        }
        while(endIndex < S.length())
        {
            char c = S.charAt(endIndex);
            if(!record.containsKey(c))
                endIndex ++;
            else
            {
                int val = record.get(c);
                record.put(c, val - 1);
                if(val - 1 == 0)
                    diffCount --;
                if(diffCount == 0)
                {
                    while(diffCount == 0)
                    {
                        char t = S.charAt(startIndex);
                        startIndex ++;
                        if(record.containsKey(t))
                        {
                            int tempVal = record.get(t);
                            record.put(t, tempVal + 1);
                            if(tempVal == 0)
                                diffCount ++;
                        }
                    }
                    if(endIndex - startIndex + 2 < minLength)
                    {
                        minLength = endIndex - startIndex + 2;
                        minStartIndex = startIndex - 1;
                        minEndIndex = endIndex;
                    }
                }
                endIndex ++;
            }
        }
        if(minStartIndex < 0)
            return new String("");
        else
            return S.substring(minStartIndex, minEndIndex + 1);
    }
}