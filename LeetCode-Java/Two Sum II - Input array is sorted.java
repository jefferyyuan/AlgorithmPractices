public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while(start < end){
            int value = numbers[start] + numbers[end];
            if(value == target)
                break;
            else if(value < target)
                start ++;
            else
                end --;
        }
        int[] result = new int[2];
        result[0] = start + 1;
        result[1] = end + 1;
        return result;
    }
}