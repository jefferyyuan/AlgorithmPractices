public class Solution {
    public int trap(int[] A) {
        int left = 0,right = A.length - 1;
        int result = 0;
        while(left < right)
        {
            while(left < right && A[left] <= A[left + 1]) left ++;
            while(right > left && A[right] <= A[right - 1]) right --;
            if(left >= right) break;
            if(A[left] < A[right])
            {
                int startHeight = A[left];
                left ++;
                while(left < right && A[left] < startHeight )
                {
                    result += startHeight - A[left];
                    left ++;
                }
            }
            else
            {
                int startHeight = A[right];
                right --;
                while(right > left && A[right] < startHeight)
                {
                    result += startHeight - A[right];
                    right --;
                }
            }
        }
        return result;
    }
}