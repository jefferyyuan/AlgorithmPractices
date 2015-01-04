public class Solution {
    public List<Integer> grayCode(int n) {
        List<Long> powerList = new ArrayList<Long>();
        int temp = 1;
        for(int i = 0;i < 32;i ++)
        {
            powerList.add((long)temp);
            temp *= 2;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i < powerList.get(n);i ++)
        {
            int tempResult = 0;
            for(int j = 0;j < n;j ++)
            {
                int num = i / powerList.get(j).intValue();
                tempResult += judgeBit(num) * powerList.get(j).intValue();
            }
            result.add(tempResult);
        }
        return result;
    }
    
    int judgeBit(int num)
    {
        if(num % 4 == 0 || num % 4 == 3)
        {
            return 0;
        }
        else 
        {
            return 1;
        }
    }
}