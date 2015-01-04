/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public class CustomComparator implements Comparator<Interval> 
    {
        @Override
        public int compare(Interval o1, Interval o2) 
        {
            if(o1.start < o2.start) return -1;
            else if(o1.start > o2.start) return 1;
            else
            {
                if(o1.end < o2.end) return -1;
                else if(o1.end > o2.end) return 1;
                else
                    return 0;
            }
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return result;
        Collections.sort(intervals, new CustomComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        int index = 0;
        while(index <= intervals.size())
        {
            if(index == intervals.size() || intervals.get(index).start > end)
            {
                result.add(new Interval(start, end));
                if(index < intervals.size())
                {
                    start = intervals.get(index).start;
                    end = intervals.get(index).end;
                }
                index ++;
            }
            else
            {
                end = Math.max(end, intervals.get(index).end);
                index ++;
            }
        }
        return result;
    }
}