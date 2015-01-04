public class Solution {
    public String convert(String s, int nRows) {
        if(s == null || s.length() <= 1 || nRows <= 1)
            return s;
        List<List<Character>> record = new ArrayList<List<Character>>();
        for(int i = 0;i < nRows;i ++)
        {
            record.add(new ArrayList<Character>());
        }
        int index = 0, rowIndex = 0;
        int direction = 1;
        while(index < s.length())
        {
            char c = s.charAt(index);
            record.get(rowIndex).add(c);
            rowIndex += direction;
            if(rowIndex == nRows - 1 || rowIndex == 0)
                direction = 0 - direction;
            index ++;
        }
        char[] resultArray = new char[s.length()];
        index = 0;
        for(int i = 0;i < record.size();i ++)
        {
            for(int j = 0;j < record.get(i).size();j ++)
            {
                resultArray[index] = record.get(i).get(j);
                index ++;
            }
        }
        return String.valueOf(resultArray);
    }
}