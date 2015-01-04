// O(n) complexity should remind me of HashMap ( which I don't, I thought HashMap can't be treated as O(1) complexity)
// the core trick was the left and right, updating values in HashMap, so there will not be any further visit.
// ref: http://fisherlei.blogspot.com/2013/02/leetcode-longest-consecutive-sequence.html
public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        for(int i = 0;i < num.length;i ++)
        {
            record.put(num[i],i);
        }
        int result = 0;
        for(int i = 0;i < num.length;i ++)
        {
            if(record.get(num[i]) < 0) continue;
            int tempLength = 1;
            int value = num[i] - 1;
            while(record.containsKey(value))
            {
                record.put(value, -1);
                value --;
                tempLength ++;
            }
            value = num[i] + 1;
            while(record.containsKey(value))
            {
                record.put(value, -1);
                value ++;
                tempLength ++;
            }
            result = Math.max(result, tempLength);
        }
        return result;
    }
}