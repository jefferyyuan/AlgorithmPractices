public class Solution {
    public boolean canJump(int[] A) {
        int currentMax = 0;
        for(int i = 0;i < A.length;i ++)
        {
            if(i > currentMax) return false;
            currentMax = Math.max(currentMax, i + A[i]);
            if(currentMax >= A.length - 1) return true;
        }
        return false;
    }
}