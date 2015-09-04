class Solution {
public:
    bool isValid(string s) {
        stack<char> record;
        unordered_map<char, char> ref;
        ref[')'] = '(';
        ref['}'] = '{';
        ref[']'] = '[';
        for (auto val : s) {
            if (ref.find(val) == ref.end()) {
                record.push(val);
            } else {
                if (record.empty() || ref[val] != record.top()) {
                    return false;
                } else {
                    record.pop();
                }
            }
        }
        return record.empty();
    }
};