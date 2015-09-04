class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> result;
        map<int, int> record;
        for (auto val : nums) record[val]++;
        vector<int> tempResult;
        search(result, record, record.begin(), tempResult);
        return result;
    }
    
    void search(vector<vector<int>>& result, map<int, int>& record, map<int, int>::iterator it, vector<int>& tempResult) {
        if (it == record.end()) {
            vector<int> current_result(tempResult.begin(), tempResult.end());
            result.push_back(current_result);
        } else {
            int val = it->first;
            int count = it->second;
            int pre_size = tempResult.size();
            for (int i = 0; i <= count; i++) {
                search(result, record, next(it, 1), tempResult);
                tempResult.push_back(val);
            }
            int after_size = tempResult.size();
            tempResult.erase(tempResult.begin() + pre_size, tempResult.begin() + after_size);
        }
    }
};