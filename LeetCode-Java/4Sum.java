public class Solution {
     public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length <= 0)
            return result;
        HashMap<Integer,List<Integer>> record = new HashMap<Integer,List<Integer>>();
        HashMap<Integer,Integer> countRecord = new HashMap<Integer,Integer>();
        
        Arrays.sort(num);
        
        // set values for countRecord
        int preValue = num[0], count = 1;
        for(int i = 1;i <= num.length;i ++)
        {
            if(i == num.length || num[i] != preValue)
            {
                countRecord.put(preValue, count);
                count = 1;
                if(i != num.length)
                    preValue = num[i];
            }
            else
                count ++;
        }
        
        // set values for record
        for(int i = 0;i < num.length;i ++)
        {
            if(i > 0 && num[i] == num[i - 1])
                continue;
            for(int j = i + 1;j < num.length;j ++)
            {
                if(j > i + 1 && num[j] == num[j - 1])
                    continue;
                
                int sum = num[i] + num[j];
                List<Integer> tempRecord = null;
                if(record.containsKey(sum))
                    tempRecord = record.get(sum);
                else
                    tempRecord = new ArrayList<Integer>();
                tempRecord.add(num[i]);
                tempRecord.add(num[j]);
                record.put(sum, tempRecord);
            }
        }
        
        // search
        boolean searchEqual = false;
        for(Integer val: record.keySet())
        {
            int left = val.intValue();
            int right = target - left;
            if(right < left) continue;
            if(right == left && searchEqual) continue;
            if(right == left) searchEqual = true;
            if(record.containsKey(right))
            {
                List<Integer> leftList = record.get(left);
                List<Integer> rightList = record.get(right);
                for(int i = 0;i < leftList.size();i += 2)
                {
                    int leftVal1 = countRecord.get(leftList.get(i));
                    if(leftVal1 <= 0)
                        continue;
                    countRecord.put(leftList.get(i), leftVal1 - 1);
                    int leftVal2 = countRecord.get(leftList.get(i + 1));
                    if(leftVal2 <= 0)
                    {
                    	countRecord.put(leftList.get(i), leftVal1);
                    	continue;                   	
                    }         
                    countRecord.put(leftList.get(i + 1), leftVal2 - 1);
                    int startIndex = 0;
                    if(left == right)
                    	startIndex = i;
                    for(int j = startIndex;j < rightList.size();j += 2)
                    {
                        if(rightList.get(j) < leftList.get(i + 1))
                            continue;
                        int rightVal1 = countRecord.get(rightList.get(j));
                        if(rightVal1 <= 0)
                            continue;
                        countRecord.put(rightList.get(j), rightVal1 - 1);
                        int rightVal2 = countRecord.get(rightList.get(j + 1));
                        if(rightVal2 <= 0)
                        {
                        	countRecord.put(rightList.get(j), rightVal1);
                        	continue;
                        }                        
                        countRecord.put(rightList.get(j + 1), rightVal2 - 1);
                        List<Integer> newResult = new ArrayList<Integer>();
                        newResult.add(leftList.get(i));
                        newResult.add(leftList.get(i + 1));
                        newResult.add(rightList.get(j));
                        newResult.add(rightList.get(j + 1));
                        result.add(newResult);                       
                        countRecord.put(rightList.get(j + 1), rightVal2);
                        countRecord.put(rightList.get(j), rightVal1);
                    }
                    countRecord.put(leftList.get(i + 1), leftVal2);
                    countRecord.put(leftList.get(i), leftVal1);
                }
            }
        }
        return result;
    }
}