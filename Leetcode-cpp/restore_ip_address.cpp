class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> result;
        vector<string> record;
        search(result, record, s, 0);
        return result;
    }
    
    void search(vector<string>& result, vector<string>& record, string s, int index) {
        if (index == s.length() && record.size() == 4) {
            result.push_back(record[0] + "." + record[1] + "." + record[2] + "." + record[3]);
        } else if (index < s.length() && record.size() < 4) {
            for (int i = index; i <= min(index + 2, (int)s.length() - 1); ++i) {
                if (is_valid(s, index, i)) {
                    record.push_back(s.substr(index, i - index + 1));
                    search(result, record, s, i + 1);
                    record.pop_back();
                }
            }
        }
    }
    
    bool is_valid(string& s, int start, int end) {
        if (s[start] == '0') return start == end;
        string test_input = s.substr(start, end - start + 1);
        int val = stoi(test_input);
        return val > 0 && val <= 255;
    }
};