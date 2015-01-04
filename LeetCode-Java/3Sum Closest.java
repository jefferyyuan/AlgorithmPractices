public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) return Integer.MIN_VALUE;
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        for(int i = 0;i < num.length - 2;i ++)
        {
            int tempResult = threeSumClosest(num, i, target);
            if(Math.abs(tempResult - target) < Math.abs(result - target))
                result = tempResult;
        }
        return result;
    }
    
    public int threeSumClosest(int[] num,int index,int target)
    {
        int start = index + 1, end = num.length - 1;
        int result = num[index] + num[index + 1] + num[num.length - 1];
        while(start < end)
        {
            int tempValue = num[index] + num[start] + num[end];
            if(Math.abs(tempValue - target) < Math.abs(result - target))
                result = tempValue;
            if(tempValue < target) start ++;
            else end --;
        }
        return result;
    }
}