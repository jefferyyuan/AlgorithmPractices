class Solution {
public:
    int jump(vector<int>& nums) {
        int start_index = 0, last_index = 0, count = 0;
        while (last_index < nums.size() - 1 && start_index <= last_index) {
            int opt = last_index;
            while (start_index <= last_index) {
                opt = max(opt, start_index + nums[start_index]);
                start_index++;
            }
            start_index = last_index + 1;
            last_index = opt;
            count++;
        }
        return count;
    }
};