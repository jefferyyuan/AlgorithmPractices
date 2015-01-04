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
        int totalLength = unit * L.length;
        for(int start = 0;start < unit;start ++)
        {
            record.clear();
            int index = start;
            int realStart = start;
            int searchStart = realStart;
            while(realStart + totalLength <= S.length())
            {
                boolean isValid = true;
                for(int i = searchStart; i < realStart + totalLength; i += unit)
                {
                    String temp = S.substring(i, i + unit);
                    if(!source.containsKey(temp))
                    {
                        record.clear();
                        realStart = i + unit;
                        searchStart = i + unit;
                        isValid = false;
                        break;
                    }
                    else
                    {
                        int val = 0;
                        if(record.containsKey(temp))
                            val = record.get(temp);
                        record.put(temp, val + 1);
                        if(val + 1 > source.get(temp))
                        {
                            for(int j = realStart;j <= i;j += unit)
                            {
                                String newStr = S.substring(j, j + unit);
                                int newVal = record.get(newStr);
                                record.put(newStr, newVal - 1);
                                if(newStr.compareTo(temp) == 0)
                                {
                                    realStart = j + unit;
                                    break;
                                }
                            }
                            searchStart = i + unit;
                            isValid = false;
                            break;
                        }
                    }
                }
                if(isValid)
                {
                    String oldStr = S.substring(realStart, realStart + unit);
                    int tempVal = record.get(oldStr);
                    record.put(oldStr, tempVal - 1);
                    result.add(realStart);
                    realStart += unit;
                    searchStart = realStart + totalLength - unit;
                }
                else
                {
                    continue;
                }
            }
        }
        return result;
    }
}