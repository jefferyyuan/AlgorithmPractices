public class Solution {
   public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length <= 0)
            return result;
        Arrays.sort(num);
        ArrayList<Integer> value = new ArrayList<Integer>();
        ArrayList<Integer> record = new ArrayList<Integer>();
        int preValue = num[0];
        int count = 1;
        for(int i = 1;i <= num.length;i ++)
        {
            if(i == num.length  || num[i] != preValue)
            {
            	value.add(preValue);
            	record.add(count);
            	if(i < num.length)
            	{
            		preValue = num[i];
                	count = 1;
            	}
            }
            else
            {
                count ++;
            }
        }
        List<Integer> tempResult = new ArrayList<Integer>();
        combinantionSum2Part(value,record,0,target,result, tempResult);
        return result;
    }
    
    void combinantionSum2Part(ArrayList<Integer> value, ArrayList<Integer> count, int index, int target, List<List<Integer>> result,
                                List<Integer> tempResult)
    {
        if(target == 0)
        {
            List<Integer> cloneResult = new ArrayList<Integer>(tempResult);
            result.add(cloneResult);
            return;
        }
        else if(target < 0 || index >= value.size())
        {
            return;
        }
        else
        {
            int addCount = 0;
            while(target >= 0)
            {
                combinantionSum2Part(value, count, index + 1, target, result, tempResult);
                if(addCount >= count.get(index))
                    break;
                target -= value.get(index);
                tempResult.add(value.get(index));
                addCount ++;
                
            }
            int length = tempResult.size() - 1;
            while(addCount > 0)
            {
                tempResult.remove(length);
                length --;
                addCount --;
            }
            return;
        }
    }
}