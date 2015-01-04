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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        boolean status = false;
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        for(int i = 0;i < intervals.size();i ++)
        {
            Interval tempInterval = intervals.get(i);
            if( tempInterval.end < newInterval.start)
            {
                result.add(tempInterval);
                continue;
            }
            else if( tempInterval.start > newInterval.end)
            {
                if(!status)
                {
                    Interval addInterval = new Interval(newStart,newEnd);
                    status = true;
                    result.add(addInterval);
                }
                result.add(tempInterval);
            }
            else
            {
                newStart = Math.min(newStart, tempInterval.start);
                newEnd = Math.max(newEnd, tempInterval.end);
            }
        }
        if(!status)
        {
            Interval addInterval = new Interval(newStart,newEnd);
            status = true;
            result.add(addInterval);
        }        
        return result;
    }
}