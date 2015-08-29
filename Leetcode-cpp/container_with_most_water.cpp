class Solution {
public:
    int maxArea(vector<int>& height) {
        int startIndex = 0, endIndex = height.size() - 1;
        int globalMax = 0;
        while (startIndex < endIndex) {
            globalMax = max(globalMax, (endIndex - startIndex) * min(height[startIndex], height[endIndex]));
            if (height[startIndex] < height[endIndex]) startIndex++;
            else endIndex--;
        }
        return globalMax;
    }
};