public class Solution {
    public void sortColors(int[] A) {
        int redStart = 0, blueStart = A.length - 1, index = 0;
        while(index <= blueStart)
        {
            if(A[index] == 0)
            {
                int temp = A[index];
                A[index] = A[redStart];
                A[redStart] = temp;
                index ++;
                redStart ++;
            }
            else if(A[index] == 1)
            {
                index ++;
            }
            else
            {
                int temp = A[index];
                A[index] = A[blueStart];
                A[blueStart] = temp;
                blueStart --;
            }
        }
    }
}