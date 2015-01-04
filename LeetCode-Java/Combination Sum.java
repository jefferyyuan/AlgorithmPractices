public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] record = new int[candidates.length];
        for(int i = 0;i < record.length;i ++)
        {
            record[i] = 0;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationSumPart(candidates,record,0, target,result);
        return result;
    }
        void combinationSumPart(int[] candidates,int[] record, int index, int target, List<List<Integer>> result)
        {
            if(index >= record.length) return;
            while(target >= 0)
            {
                if(target == 0)
                {
                    List<Integer> tempResult = new ArrayList<Integer>();
                    for(int i = 0;i < record.length;i ++)
                    {
                        for(int j = 0;j < record[i];j ++)
                        {
                            tempResult.add(candidates[i]);
                        }
                    }
                    result.add(tempResult);
                    break;
                }
                else
                {
                    combinationSumPart(candidates,record,index + 1,target,result);
                    record[index] = record[index] + 1;
                    target -= candidates[index];
                }
            }
            record[index] = 0;
            return;
        }
}