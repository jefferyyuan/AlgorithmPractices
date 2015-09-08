class Solution {
public:
    int longestValidParentheses(string s) {
        stack<int> record;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] == '(') {
                record.push(i);
            } else if (!record.empty() && s[record.top()] == '(') {
                record.pop();
            } else {
                record.push(i);
            }
        }
        int current = s.length() - 1;
        while (!record.empty()) {
            result = max(result, current - record.top());
            current = record.top() - 1;
            record.pop();
        }
        result = max(result, current + 1);
        return result;
    }
};