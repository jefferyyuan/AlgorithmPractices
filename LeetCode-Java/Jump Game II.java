public class Solution {
    public int jump(int[] A) {
        int currentStep = 0;
        int maxIndex = 0,startIndex = 0;
        while(maxIndex < A.length - 1)
        {
            int newMaxIndex = maxIndex;
            for(int i = startIndex;i <= maxIndex;i ++)
            {
                newMaxIndex = Math.max(newMaxIndex, i + A[i]);
            }
            startIndex = maxIndex + 1;
            maxIndex = newMaxIndex;
            currentStep ++;
        }
        return currentStep;
    }
}