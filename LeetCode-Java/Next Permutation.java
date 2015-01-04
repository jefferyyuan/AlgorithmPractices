public class Solution {
    public void nextPermutation(int[] num) {
        int index = num.length - 2;
        while(index >= 0 && num[index] >= num[index + 1])
            index --;
        if(index >= 0)
        {
            for(int i = num.length - 1;i > index ; i --)
            {
                if(num[i] > num[index])
                {
                    int temp = num[index];
                    num[index] = num[i];
                    num[i] = temp;
                    break;
                }
            }
        }
        Arrays.sort(num,index + 1, num.length);
        return;
    }
}