public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(true)
        {
            ArrayList<Integer> tempResult = new ArrayList<Integer>();
            for(int i = 0;i < num.length;i ++)
                tempResult.add(num[i]);
            result.add(tempResult);
            if(!nextPermutation(num))
                break;
        }
        return result;
    }
    
    public boolean nextPermutation(int[] num) {
        int index = num.length - 2;
        while(index >= 0 && num[index] >= num[index + 1])
            index --;
        if(index < 0) return false;
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
        return true;
    }
}