public class Solution {
    public int findPeakElement(int[] num) {
        return  findPeakElementPart(num,0,num.length - 1);
    }
    public int findPeakElementPart(int[] num,int start,int end)
    {
        if(start == end) return start;
        if(num[start] > num[start + 1]) return start;
        if(num[end] > num[end - 1]) return end;
        int mid = (start + end)  / 2;
        if(num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) return mid;
        if(num[mid] > num[mid - 1]) return findPeakElementPart(num,mid + 1,end);
        else return findPeakElementPart(num,start,mid - 1);
    }

}