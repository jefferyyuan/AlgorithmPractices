public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null)
            return result;
        if(digits.length() == 0)
        {
            result.add("");
            return result;
        }
        String[] source = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] record = new char[digits.length()];
        letterCombinationsPart(source,digits,0,record,result);
        return result;
    }
    
    void letterCombinationsPart(String[] source,String digits, int index, char[] record, List<String> result)
    {
        int numberIndex = Character.compare(digits.charAt(index),'0');
        String choice = source[numberIndex];
        if(choice.length() <= 0)
            return;
        for(int i = 0;i < choice.length(); i ++)
        {
            char c = choice.charAt(i);
            record[index] = c;
            if(index == digits.length() - 1)
            {
                String tempResult = String.valueOf(record);
                result.add(tempResult);
            }
            else
            {
                letterCombinationsPart(source,digits,index + 1, record,result);
            }
        }
        return;
    }
}