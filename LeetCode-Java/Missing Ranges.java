public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int pre = lower;
        for(int i = 0;i <= A.length;i ++){
            int value = upper + 1;
            if(i < A.length)
                value = A[i];
            if(value - pre == 1){
                String tempResult = "" + pre;
                result.add(tempResult);
            }
            else if(value - pre > 1){
                String tempResult = pre + "->" + (value - 1);
                result.add(tempResult);
            }
            pre = value + 1;
            if(pre > upper)
                break;
        }
        return result;
    }
}