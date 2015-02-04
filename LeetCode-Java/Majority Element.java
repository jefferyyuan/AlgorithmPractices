//  1st
public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer,Integer> record = new HashMap<Integer,Integer>();
        for(int i = 0;i < num.length;i ++)
        {
            if(record.containsKey(num[i]))
            {
                record.put(num[i],record.get(num[i]) + 1);
            }
            else
            {
                record.put(num[i],1);
            }
            if(record.get(num[i]) >= (num.length + 1) / 2)
                return num[i];
        }
        return -1;
    }
}

//  2nd: hint from online blogs
public class Solution {
    public int majorityElement(int[] num) {
        int result = num[0];
        int count = 1;
        for(int i = 1; i < num.length; i++){
            if(result == num[i])
                count++;
            else if(count == 0){
                result = num[i];
                count++;
            } else
                count--;
        }
        return result;
    }
}