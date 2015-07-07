class Solution {
public:
    int searchInsert(int A[], int n, int target) {
       int head = 0,tail = n - 1;
       while(head < tail)
       {
           int mid = (head + tail) / 2;
           if(A[mid] == target) return mid;
           if(A[mid] < target)
           {
               head = mid + 1;
           }
           else
           {
               tail = mid - 1;
           }
       }
       if(A[head] < target) return head + 1;
       else return head;
    }
};
