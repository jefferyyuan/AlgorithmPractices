// notice that my solution can also handle duplicates
// if not, code could be simpler
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = null;
        int[] sortS = S.clone();
        Arrays.sort(sortS);
        int val = sortS[0], count = 1;
        for(int i = 1;i <= sortS.length;i ++)
        {
            while(i < sortS.length && sortS[i] == val)
            {
                i ++;
                count ++;
            }
            if(result == null)
            {
                result = subsetsPart(val,count);
            }
            else
            {
                result = multiplyList(result,subsetsPart(val,count));
            }
            if(i < sortS.length)
            {
                val = sortS[i];
                count = 1;
            }
        }
        return result;
    }
    
    List<List<Integer>> subsetsPart(int val, int count)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i <= count;i ++)
        {
            List<Integer> tempResult = new ArrayList<Integer>();
            for(int j = 0;j < i;j ++)
            {
                tempResult.add(val);
            }
            result.add(tempResult);
        }
        return result;
    }
    
    List<List<Integer>> multiplyList(List<List<Integer>> list1, List<List<Integer>> list2)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i < list1.size();i ++)
        {
            for(int j = 0;j < list2.size();j ++)
            {
                List<Integer> tempResult = new ArrayList<Integer>(list1.get(i));
                tempResult.addAll(list2.get(j));
                result.add(tempResult);
            }
        }
        return result;
    }
}