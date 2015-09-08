class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> record;
        for(auto token : tokens) {
            if (token.compare("+") == 0) {
                int v1 = record.top();
                record.pop();
                int v2 = record.top();
                record.pop();
                record.push(v1 + v2);
            } else if(token.compare("-") == 0) {
                int v1 = record.top();
                record.pop();
                int v2 = record.top();
                record.pop();
                record.push(v2 - v1);
            } else if(token.compare("*") == 0) {
                int v1 = record.top();
                record.pop();
                int v2 = record.top();
                record.pop();
                record.push(v1 * v2);
            } else if(token.compare("/") == 0) {
                int v1 = record.top();
                record.pop();
                int v2 = record.top();
                record.pop();
                record.push(v2 / v1);
            } else {
                record.push(stoi(token));
            }
        }
        return record.top();
    }
};