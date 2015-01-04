public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int record = A[0];
        for(int i = 1;i < A.length;i ++)
        {
            if(record > 0) record += A[i];
            else record = A[i];
            max = max > record ? max : record;
        }
        return max;
    }
}