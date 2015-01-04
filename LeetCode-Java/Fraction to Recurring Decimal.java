// edge cases: 
//      sign
//      overflow
//      "-0" -> "0"
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isPositive = (numerator < 0 && denominator < 0) || (numerator >= 0 && denominator >= 0);
        StringBuffer finalResult = new StringBuffer();
        if(!isPositive)
            finalResult.append('-');
        long newNumerator = Math.abs((long)numerator);
        long newDenominator = Math.abs((long)denominator);
        long left = newNumerator / newDenominator;
        long right = newNumerator % newDenominator;
        if(right == 0)
        {
            if(left == 0)
                return "0";
            finalResult.append(left);
            return finalResult.toString();
        }
        HashMap<Long,Integer> record = new HashMap<Long,Integer>();
        int index = 0;
        List<Long> result = new ArrayList<Long>();
        while(right != 0 && !record.containsKey(right))
        {
            record.put(right, index);
            right *= 10;
            result.add(right / newDenominator);
            right = right % newDenominator;
            index ++;
        }
        if(right == 0)
        {
            finalResult.append(left);
            finalResult.append('.');
            for(int i = 0;i < result.size();i ++)
                finalResult.append(result.get(i));
            return finalResult.toString();
        }
        else
        {
            int repeatIndex = record.get(right);
            finalResult.append(left);
            finalResult.append('.');
            for(int i = 0;i < repeatIndex;i ++)
                finalResult.append(result.get(i));
            finalResult.append('(');
            for(int i = repeatIndex;i < result.size();i ++)
                finalResult.append(result.get(i));
            finalResult.append(')');
            return finalResult.toString();
        }
    }
}