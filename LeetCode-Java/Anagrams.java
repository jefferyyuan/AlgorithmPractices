public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap<String,String> record = new HashMap<String,String>();
        List<String> result = new ArrayList<String>();
        for(int i = 0;i < strs.length;i ++)
        {
            String tempString = sortString(strs[i]);
            if(record.containsKey(tempString))
            {
                result.add(strs[i]);
                if(record.get(tempString) != null)
                {
                    result.add(record.get(tempString));
                    record.put(tempString,null);
                }
            }
            else
            {
                record.put(tempString, strs[i]);
            }
        }
        return result;
    }
    
    String sortString(String input)
    {
        int[] record = new int[26];
        for(int i = 0;i < 26;i ++)
            record[i] = 0;
        for(int i = 0;i < input.length();i ++)
        {
            char c = input.charAt(i);
            int index = Character.compare(c, 'a');
            record[index] = record[index] + 1;
        }
        char[] resultArray = new char[input.length()];
        int index = 0;
        for(int i = 0;i < 26;i ++)
        {
            char c = (char)(((int)'a') + i);
            for(int j = 0;j < record[i];j ++)
            {
                resultArray[index] = c;
                index ++;
            }
        }
        return String.valueOf(resultArray);
    }
}