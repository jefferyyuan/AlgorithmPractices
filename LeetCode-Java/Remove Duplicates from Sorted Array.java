public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length <= 0) return 0;
        int oldIndex = 1, newIndex = 1, current = A[0];
        while(oldIndex < A.length)
        {
            if(A[oldIndex] != current)
            {
                current = A[oldIndex];
                if(oldIndex > newIndex)
                {
                    int temp = A[oldIndex];
                    A[oldIndex] = A[newIndex];
                    A[newIndex] = temp;
                }
                newIndex ++;
            }
            oldIndex ++;
        }
        return newIndex;
    }
}