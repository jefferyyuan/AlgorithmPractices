public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
        int top = rowIndex, bottom = 1;
        long value = 1;
        result.add(1);
        while(top > 0)
        {
            value = value * top / bottom;
            int tempValue = (int)value;
            result.add(tempValue);
            top --;
            bottom ++;
        }
        return result;
    }
}