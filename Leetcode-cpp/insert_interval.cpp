/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> result;
        bool valid = true;
        for (auto val : intervals) {
            if (!valid || newInterval.start > val.end) {
                result.push_back(Interval(val.start, val.end));
            } else if (newInterval.end < val.start) {
                result.push_back(Interval(newInterval.start, newInterval.end));
                result.push_back(Interval(val.start, val.end));
                valid = false;
            } else {
                newInterval.start = min(newInterval.start, val.start);
                newInterval.end = max(newInterval.end, val.end);
            }
        }
        if (valid) {
            result.push_back(Interval(newInterval.start, newInterval.end));
        }
        return result;
    }
};