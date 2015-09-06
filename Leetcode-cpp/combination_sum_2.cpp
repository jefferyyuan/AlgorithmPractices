class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> record;
        map<int, int> map_ref;
        for (auto val : candidates) map_ref[val]++;
        vector<pair<int, int>> ref(map_ref.begin(), map_ref.end());
        search(result, record, ref, 0, target);
        return result;
    }
    
    void search(vector<vector<int>>& result, vector<int>& record, vector<pair<int, int>>& ref, int index, int target) {
        if (target == 0) {
            result.push_back(vector<int>(record.begin(), record.end()));
            return;
        }
        if (target < 0 || index >= ref.size()) return;
        for (int i = 0; i <= ref[index].second; ++i) {
            search(result, record, ref, index + 1, target - i * ref[index].first);
            record.push_back(ref[index].first);
        }
        record.erase(record.end() - ref[index].second - 1, record.end());
    }
};