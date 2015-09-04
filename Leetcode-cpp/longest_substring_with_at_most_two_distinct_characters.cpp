class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        unordered_map<char, int> record;
        int global_max = 0, start_index = 0;
        for (int i = 0; i < s.length(); ++i) {
            record[s[i]] = i;
            if (record.size() > 2) {
                char chosen_c = 'a';
                int chosen_value = 100000;
                for (auto key_value : record) {
                    if (key_value.second < chosen_value) {
                        chosen_c = key_value.first;
                        chosen_value = key_value.second;
                    }
                }
                global_max = max(global_max, i - start_index);
                start_index= chosen_value + 1;
                record.erase(chosen_c);
            }
        }
        global_max = max(global_max, (int)s.length() - start_index);
        return global_max;
    }
};