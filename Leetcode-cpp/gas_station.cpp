class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        int start_index = 0, end_index = 1 % n;
        int current_gas = gas[0] - cost[0];
        do {
            if (current_gas < 0) {
                start_index = (start_index - 1 + n) % n;
                current_gas += gas[start_index] - cost[start_index];
            } else {
                current_gas += gas[end_index] - cost[end_index];
                end_index = (end_index + 1) % n;
            }
        } while (start_index != end_index);
        if (current_gas < 0) return -1;
        return start_index;
    }
};