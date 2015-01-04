public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> source = new HashMap<String, Integer>();
        for(int i = 0;i < L.length;i ++)
        {
            if(!source.containsKey(L[i]))
                source.put(L[i], 1);
            else
            {
                int val = source.get(L[i]);
                source.put(L[i], val + 1);
            }
        }
        
        int unit = 0;
        if(L.length > 0)
            unit = L[0].length();
        HashMap<String, Integer> record = new HashMap<String, Integer>();
        for(int index = 0;index + unit * L.length  <= S.length(); index ++)
        {
            record.clear();
            boolean isValid = true;
            for(int i = index; i < index + unit * L.length;i += unit)
            {
                String temp = S.substring(i, i + unit);
                if(!source.containsKey(temp))
                {
                    isValid = false;
                    break;
                }
                int val = 0;
                if(record.containsKey(temp))
                    val = record.get(temp);
                if(val + 1 > source.get(temp))
                {
                    isValid = false;
                    break;
                }
                record.put(temp, val + 1);
            }
            if(isValid)
            {
                result.add(index);
            }
        }
        return result;
    }
}