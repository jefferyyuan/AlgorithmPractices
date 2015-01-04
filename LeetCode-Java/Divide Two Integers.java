public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        long newDividend = dividend;
        long newDivisor = divisor;
        boolean isPositive = true;
        if(newDividend < 0)
        {
            newDividend = -newDividend;
            isPositive = !isPositive;
        }
        if(newDivisor < 0)
        {
            newDivisor = -newDivisor;
            isPositive = !isPositive;
        }
        long unit = newDivisor;
        long countUnit = 1;
        List<Long> record1 = new ArrayList<Long>();
        List<Long> record2 = new ArrayList<Long>();
        while( unit <= newDividend)
        {
            record1.add(unit);
            record2.add(countUnit);
            unit = unit + unit;
            countUnit = countUnit + countUnit;
        }
        long result = 0;
        for(int i = record1.size() - 1;i >= 0;i --)
        {
            if(newDividend >= record1.get(i))
            {
                result += record2.get(i);
                newDividend -= record1.get(i);
            }
        }
        if(!isPositive) result = -result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int)result;
        
    }
}