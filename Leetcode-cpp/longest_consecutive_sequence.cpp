class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, bool> record;
        for(int val : nums) record.insert(make_pair(val, false));
        int global_max = 0;
        for(auto val : record) {
            if (!val.second) {
                record[val.first] = true;
                int lnumber = val.first - 1;
                while (record.find(lnumber) != record.end()) {
                    record[lnumber--] = true;
                }
                int hnumber = val.first + 1;
                while (record.find(hnumber) != record.end()) {
                    record[hnumber++] = true;
                }
                global_max = max(global_max, hnumber - lnumber - 1);
            }
        }
        return global_max;
    }
};