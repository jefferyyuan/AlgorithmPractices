public class Solution {
    public class Element implements Comparable
    {
        int val;
        int position;
        public Element(int v, int p)
        {
            val = v;
            position = p;
        }
        
        @Override
        public int compareTo(Object right) 
        {
            /* For Ascending order*/
            return this.val - ((Element)right).val;
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        ArrayList<Element> record = new ArrayList<Element>();
        for(int i = 0;i < numbers.length; i ++)
        {
            record.add(new Element(numbers[i],i + 1));
        }
        Collections.sort(record);
        int startIndex = 0, endIndex = numbers.length - 1;
        while(startIndex < endIndex)
        {
            int val = record.get(startIndex).val + record.get(endIndex).val;
            if(val == target)
                break;
            if(val > target) endIndex --;
            if(val < target) startIndex ++;
        }
        int[] result = new int[2];
        result[0] = record.get(startIndex).position;
        result[1] = record.get(endIndex).position;
        if(result[0] > result[1])
        {
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        return result;
    }
}