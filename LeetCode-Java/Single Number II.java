public class Solution {
    public int singleNumber(int[] A) {
        int low = 0,high = 0;
        for(int i = 0;i < A.length;i ++)
        {
            int newLow = ((~low) & (~high) & A[i]) | ((~high) & (low) & (~A[i]));
            int newHigh = (low & A[i] & (~high)) | ((high) & (~low) & (~A[i]));
            low = newLow;
            high = newHigh;
        }
        return low;
    }
}