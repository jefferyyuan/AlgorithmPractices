public class Solution {
    public boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> record = new HashMap<String, Boolean>();
        return isScramblePart(s1, 0 ,s1.length() - 1, s2, 0, s2.length() - 1, record);
    }
    
    boolean isScramblePart(String s1, int start1, int end1, String s2, int start2, int end2, HashMap<String, Boolean> record)
    {
        if(end1 - start1 != end2 - start2)
            return false;
        if(start1 > end1)
            return true;
        if(start1 == end1)
            return (s1.charAt(start1) == s2.charAt(start2));
        else
        {
            String testString = s1.substring(start1, end1 + 1) + s2.substring(start2, end2 + 1);
            if(record.containsKey(testString))
                return record.get(testString);
            HashMap<Character,Integer> record1 = new HashMap<Character,Integer>();
            HashMap<Character,Integer> record2head = new HashMap<Character,Integer>();
            HashMap<Character,Integer> record2tail = new HashMap<Character,Integer>();
            int countHead = 0;
            int countTail = 0;
            for(int i =  start1, j = start2, k = end2; i < end1; i ++, j ++ ,k --)
            {
                char c= s1.charAt(i);
                countHead += statusChange(c, record1, record2head);
                countTail += statusChange(c, record1, record2tail);
                add(c, record1);
                
                c = s2.charAt(j);
                countHead += statusChange(c, record2head, record1);
                add(c, record2head);
                
                c = s2.charAt(k);
                countTail += statusChange(c, record2tail, record1);
                add(c, record2tail);
                
                if(countHead == 0)
                {
                    boolean tempResult = isScramblePart(s1, start1, i, s2, start2, j, record) && isScramblePart(s1, i + 1, end1, s2, j + 1, end2, record);
                    if(tempResult) 
                    {
                        record.put(testString, true);
                        return true;
                    }
                }
                
                if(countTail == 0)
                {
                    boolean tempResult = isScramblePart(s1, start1, i, s2, k,  end2, record) && isScramblePart(s1, i + 1, end1, s2, start2, k - 1, record);
                    if(tempResult) 
                    {
                        record.put(testString, true);
                        return true;
                    }
                }
            }
            record.put(testString, false);
            return false;
        }
    }
    
    void add(char c,HashMap<Character,Integer> map1)
    {
        if(map1.containsKey(c))
        {
            map1.put(c, map1.get(c) + 1);
        }
        else
            map1.put(c, 1);
        return;
    }
    int statusChange(char c,HashMap<Character,Integer> map1, HashMap<Character,Integer> map2)
    {
        int val1 = 0;
        if(map1.containsKey(c))
            val1 = map1.get(c);
        int val2 = 0;
        if(map2.containsKey(c))
            val2 = map2.get(c);
        if(val1 == val2) return 1;
        else if(val1 + 1 == val2) return -1;
        else return 0;
    }
}