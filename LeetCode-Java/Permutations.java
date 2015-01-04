public class Solution {
    public List<List<Integer>> permute(int[] num) {
        Arrays.sort(num);
        HashMap<Integer,Integer> record = new HashMap<Integer,Integer>();
        for(Integer key : num)
        {
            if(record.containsKey(key))
            {
                int value = record.get(key);
                value ++;
                record.put(key,value);
            }
            else
            {
                record.put(key,1);
            }
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        ArrayList<Integer> midResult = new ArrayList<Integer>();
        permutePart(resultList,record,midResult,num.length);
        return resultList;
    }
    public void permutePart(List<List<Integer>> resultList,HashMap<Integer,Integer> record,ArrayList<Integer> midResult,int size)
    {
        for(Integer key: record.keySet())
        {
            int value = record.get(key);
            if(value == 0) continue;
            record.put(key, value -1);
            int length = midResult.size();
            midResult.add(key);
            if(size - 1 == 0)
            {
                ArrayList<Integer> tempResult = new ArrayList<Integer>(midResult);
                resultList.add(tempResult);
            }
            else
            {
                permutePart(resultList,record,midResult,size - 1);
            }
            midResult.remove(length);
            record.put(key, value);
        }
    }
}