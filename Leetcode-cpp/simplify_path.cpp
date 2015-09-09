class Solution {
public:
    string simplifyPath(string path) {
        stack<string> record;
        int pre = 0;
        while (pre < path.length() && path[pre] == '/') pre++;
        for (int i = pre; i <= path.length(); ++i) {
            if (i == path.length() || path[i] == '/') {
                string temp = path.substr(pre, i - pre);
                if (temp.length() == 0) {
                } else if (temp.compare("..")== 0) {
                    if (!record.empty()) {
                        record.pop();
                    }
                } else if (temp.compare(".") != 0) {
                    record.push(temp);
                }
                pre = i + 1;
            }
        }
        string result = "";
        if (record.empty()) return "/";
        while (!record.empty()) {
            result = "/" + record.top() + result;
            record.pop();
        }
        return result;
    }
};