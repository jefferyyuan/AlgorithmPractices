// using long
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

// without using long
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else if (dividend == 0) {
            return 0;
        }
        
        // since abs(Integer.MIN_VALUE) > abs(Integer.MAX_VALUE)
        // We should change to negative instead of changing into positive
        if (dividend > 0 && divisor > 0) {
            return divideHelper(-dividend, -divisor);
        } else if(dividend < 0 && divisor < 0) {
            return divideHelper(dividend, divisor);
        } else if(dividend < 0) {
            return -divideHelper(dividend, -divisor);
        } else {
            return -divideHelper(-dividend, divisor);
        }
    }
    
    public int divideHelper(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int tempDivisor = divisor;
        while (tempDivisor + tempDivisor < 0 && tempDivisor > dividend) {
            tempDivisor = tempDivisor + tempDivisor;
        }
        int result = 0;
        while (tempDivisor <= divisor) {
            result = result << 1;
            if(dividend <= tempDivisor) {
                result += 1;
                dividend -= tempDivisor;
            }
            tempDivisor = (tempDivisor + 1) >> 1; // see how negative / 2 should be coded
        }
        return result;
        
    }
}