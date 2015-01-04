public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0,end = 1 % gas.length;
        int gasLeft = gas[0] - cost[0];
        while(start != end)
        {
            if(gasLeft < 0)
            {
                start = (start + gas.length - 1) % gas.length;
                gasLeft = gasLeft + gas[start] - cost[start];
            }
            else
            {
                gasLeft = gasLeft + gas[end] - cost[end];
                end = (end + 1) % gas.length;
            }
        }
        if(gasLeft >= 0) 
            return start;
        else
            return -1;
    }
}