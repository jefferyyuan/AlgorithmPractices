public class Solution {
    public int maxSubArray(int[] A) {
        if(A == null || A.length == 0) {
            throw new RuntimeException("Invalid input.");
        }
        int result = A[0];
        int current = A[0];
        for (int i = 1; i < A.length; i++) {
            if (current >= 0) {
                current += A[i];
            } else {
                current = A[i];
            }
            result = Math.max(result, current);
        }
        return result;
    }
}