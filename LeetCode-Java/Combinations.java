public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> record = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k > n) return result;
        combinePart(n, k, 1, record, result);
        return result;
    }
    
    public void combinePart(int n, int k, int start, List<Integer> record, List<List<Integer>> result)
    {
        if( n - start + 1 < k) return;
        if(k == 0)
        {
            ArrayList<Integer> tempResult = new ArrayList<Integer>(record);
            result.add(tempResult);
        }
        else
        {
            for(int i = start; i <= n - k + 1;i ++)
            {
                record.add(i);
                int length = record.size();
                combinePart(n, k - 1, i + 1, record, result);
                record.remove(length - 1);
            }
        }
        return;
    }
}