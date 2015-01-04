public class Solution {
    public String multiply(String num1, String num2) {
        int[] val1 = getDigitArray(num1);
        int[] val2 = getDigitArray(num2);
        int[] resultArray = new int[val1.length + val2.length];
        for(int i = 0;i < resultArray.length;i ++)
        {
            resultArray[i] = 0;
        }
        for(int i = 0;i < val1.length;i ++)
        {
            for(int j = 0;j < val2.length;j ++)
            {
                resultArray[i + j] += val1[i] * val2[j];
            }
        }
        return getDigitString(resultArray);
    }
    
    int[] getDigitArray(String val)
    {
        int[] result = new int[val.length()];
        for(int i = 0;i < result.length;i ++)
        {
            result[i] = Character.compare(val.charAt(result.length - 1 - i),'0');
        }
        return result;
    }
    String getDigitString(int[] val)
    {
        int up = 0;
        for(int i = 0;i < val.length ;i ++)
        {
            val[i] += up;
            up = val[i] / 10;
            val[i] = val[i] % 10;
        }
        int index = val.length - 1;
        while(index >= 0 && val[index] == 0)
            index --;
        if(index < 0) return "0";
        else
        {
            char[] resultArray = new char[index + 1];
            for(int i = 0;i < index + 1;i ++)
            {
                resultArray[i] = (char)(val[index - i] + (int)'0');
            }
            return String.valueOf(resultArray);
        }
    }
}