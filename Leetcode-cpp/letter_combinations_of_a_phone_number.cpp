class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> result;
        if (digits.length() == 0) return result;
        vector<char> record;
        search(result, record, digits, 0);
        return result;
    }
    void search(vector<string>& result, vector<char>& record, const string& digits, int index) {
        if (index == digits.length()) {
            result.push_back(string(record.begin(), record.end()));
            return;
        }
        char low [] = {'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        char high [] = {'c', 'f', 'i', 'l', 'o', 's', 'v', 'z'};
        if (digits[index] >= '2' && digits[index] <= '9') {
            for (char c = low[digits[index] - '2']; c <= high[digits[index] - '2']; c++) {
                record.push_back(c);
                search(result, record, digits, index + 1);
                record.erase(record.end() - 1);
            }
        }
    }
};