class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<int> in_degree(numCourses, 0);
        vector<vector<int>> graph(numCourses, vector<int>());
        for (auto val : prerequisites) {
            in_degree[val.second]++;
            graph[val.first].push_back(val.second);
        }
        for (int i = 0; i < numCourses; ++i) {
            bool valid = false;
            for (int j = 0; j < numCourses; ++j) {
                if (in_degree[j] == 0) {
                    valid = true;
                    for (int k = 0; k < graph[j].size(); ++k) {
                        in_degree[graph[j][k]]--;
                    }
                    in_degree[j] = -1;
                    break;
                }
            }
            if (!valid) return false;
        }
        return true;
    }
};