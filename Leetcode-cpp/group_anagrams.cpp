class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, int> record;
        vector<vector<string>> result;
        for (auto val : strs) {
            string temp(val);
            sort(temp.begin(), temp.end());
            if (record.find(temp) == record.end()) {
                vector<string> temp_result;
                result.push_back(temp_result);
                record[temp] = record.size() - 1;
            }
            result[record[temp]].push_back(val);
        }
        for (int i = 0; i < result.size(); ++i) {
            sort(result[i].begin(), result[i].end());
        }
        return result;
    }
};