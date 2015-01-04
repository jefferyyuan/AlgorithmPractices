public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int oldIndex = 1, newIndex = 1;
        int dupliCount = 1;
        while(oldIndex < A.length)
        {
            if(A[oldIndex] == A[newIndex -1])
            {
                if(dupliCount == 1)
                {
                    dupliCount --;
                    if(oldIndex > newIndex)
                    {
                        int temp = A[oldIndex];
                        A[oldIndex] = A[newIndex];
                        A[newIndex] = temp;
                    }
                    oldIndex ++;
                    newIndex ++;
                }
                else if(dupliCount == 0)
                {
                    oldIndex ++;
                }
            }
            else
            {
                if(oldIndex > newIndex)
                {
                    int temp = A[oldIndex];
                    A[oldIndex] = A[newIndex];
                    A[newIndex] = temp;
                }
                oldIndex ++;
                newIndex ++;
                dupliCount = 1;
            }
        }
        return newIndex;
    }
}