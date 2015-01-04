public class Solution {
    public int[] plusOne(int[] digits) {
        int count = 0;
        for(int i = digits.length - 1;i >= 0;i --)
        {
            if(digits[i] == 9) count ++;
            else
                break;
        }
        if(count == digits.length)
        {
            int[] result = new int[count + 1];
            result[0] = 1;
            for(int i = 1;i <= count;i ++)
                result[i] = 0;
            return result;
        }
        else
        {
            int[] result = new int[digits.length];
            for(int i = 0; i < digits.length - count;i ++)
            {
                result[i] = digits[i];
            }
            result[digits.length - count - 1] = result[digits.length - count - 1] + 1;
            for(int i = digits.length - count; i < digits.length;i ++)
            {
                result[i] = 0;
            }
            return result;
        }
    }
}