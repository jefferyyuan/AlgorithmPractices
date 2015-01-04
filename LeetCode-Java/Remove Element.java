public class Solution {
    public int removeElement(int[] A, int elem) {
        int oldIndex = 0;
        int newIndex = -1;
        while(oldIndex < A.length)
        {
            if(A[oldIndex] != elem)
            {
                if(newIndex >= 0)
                {
                    A[newIndex] = A[oldIndex];
                    newIndex ++;
                }
            }
            else
            {
                if(newIndex < 0)
                {
                    newIndex = oldIndex;
                }
            }
            oldIndex ++;
        }
        
        return newIndex < 0 ? A.length : newIndex;
    }
}