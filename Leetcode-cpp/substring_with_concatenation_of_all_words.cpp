class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        map<string, int> count_map;
        for (auto val : words) {
            count_map[val] ++;
        }
        vector<pair<string, int>> ref;
        for (auto val : count_map) ref.push_back(val);
        
        unordered_map<string, int> pos_ref;
        for (int i = 0; i < ref.size(); ++i) {
            pos_ref[ref[i].first] = i;
        }
        
        vector<int> record(s.length(), -1);
        int k = words[0].length();
        for (int i = 0; i + k <= s.length(); ++i) {
            string temp = s.substr(i, k);
            if (pos_ref.find(temp) != pos_ref.end()) {
                record[i] = pos_ref[temp];
            }
        }
        vector<int> used(ref.size(), 0);
        vector<int> result;
        for (int i = 0; i + k * words.size() <= s.length(); ++i) {
            for (int j = 0; j < ref.size(); ++j) {
                used[j] = ref[j].second;
            }
            bool valid = true;
            for (int j = i; j < i + k * words.size(); j += k) {
                if (record[j] == -1 || used[record[j]] == 0) {
                    valid = false;
                    break;
                }
                used[record[j]]--;
            }
            if (valid) result.push_back(i);
        }
        return result;
    }
};