/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if (node == nullptr) return nullptr;
        step_1(node);
        step_2(node);
        int n = node->neighbors.size();
        UndirectedGraphNode* result = node->neighbors[n - 3];
        step_3(node);
        return result;
    }
    
    void step_1(UndirectedGraphNode* node) {
        if (node->neighbors.size() < 2 || node->neighbors[node->neighbors.size() - 1] != nullptr) {
            node->neighbors.push_back(new UndirectedGraphNode(node->label));
            node->neighbors.push_back(nullptr);
            for (int i = 0; i < node->neighbors.size() - 2; ++i) {
                step_1(node->neighbors[i]);
            }
        }
    }

    void step_2(UndirectedGraphNode* node) {
        if (node->neighbors.size() >= 2 && node->neighbors[node->neighbors.size() - 2] != nullptr) {
            node->neighbors.push_back(nullptr);
            UndirectedGraphNode* current = node->neighbors[node->neighbors.size() - 3];
            int n = node->neighbors.size();
            for (int i = 0; i < n - 3; ++i) {
                UndirectedGraphNode* temp = node->neighbors[i];
                int index = temp->neighbors.size() - 1;
                while (index >= 0 && temp->neighbors[index] == nullptr) index--;
                current->neighbors.push_back(temp->neighbors[index]);
            }
            for (int i = 0; i < n - 3; ++i) {
                step_2(node->neighbors[i]);
            }
        }
    }
    
    void step_3(UndirectedGraphNode* node) {
        int n = node->neighbors.size();
        if (n >= 1 && node->neighbors[n - 1] == nullptr) {
            node->neighbors.erase(node->neighbors.end() - 3, node->neighbors.end());
            for (int i = 0; i < n - 3; ++i) {
                step_3(node->neighbors[i]);
            }
        }
    }
};
