class Solution {
public:
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int raw_area = abs(C - A) * abs(D - B) + abs(G - E) * abs(H - F);
        if (min(A, C) >= max(E, G) || max(A, C) <= min(E, G) ||
            min(B, D) >= max(F, H) || max(B, D) <= min(F, H) ) {
            return raw_area;       
        }
        vector<int> x = {A, C, E, G};
        vector<int> y = {B, D, F, H};
        sort(x.begin(), x.end());
        sort(y.begin(), y.end());
        return raw_area - (x[2] - x[1]) * (y[2] - y[1]);
    }
};