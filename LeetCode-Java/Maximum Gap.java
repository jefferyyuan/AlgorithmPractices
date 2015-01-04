public class Solution {
    public int maximumGap(int[] num) {
        if(num == null || num.length <= 1)
            return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0;i < num.length;i ++)
        {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        int interval = (max - min - 1) / (num.length - 1) ;
        int bucketCount = (max - min) / (interval + 1) + 1;
        int[] minRecord = new int[bucketCount];
        int[] maxRecord = new int[bucketCount];
        boolean[] setRecord = new boolean[bucketCount];
        for(int i = 0;i < setRecord.length; i ++)
        {
            setRecord[i] = false;
            minRecord[i] = Integer.MAX_VALUE;
            maxRecord[i] = Integer.MIN_VALUE;
        }
        for(int i = 0;i < num.length;i ++)
        {
            int bucket = (num[i] - min) / (interval + 1);
            if(!setRecord[bucket])
                setRecord[bucket] = true;
            maxRecord[bucket] = Math.max(maxRecord[bucket], num[i]);
            minRecord[bucket] = Math.min(minRecord[bucket], num[i]);
        }
        int result = 0;
        int preMax = min;
        int index = 0;
        while(index < bucketCount)
        {
            if(setRecord[index])
            {
                result = Math.max(result, minRecord[index] - preMax);
                preMax = maxRecord[index];
            }
            index ++;
        }
        return result;
    }
}