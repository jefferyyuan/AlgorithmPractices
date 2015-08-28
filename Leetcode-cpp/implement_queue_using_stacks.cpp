class Queue {
public:
    // Push element x to the back of queue.
    void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    void pop(void) {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
        outStack.pop();
    }

    // Get the front element.
    int peek(void) {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
        return outStack.top();
    }

    // Return whether the queue is empty.
    bool empty(void) {
        return outStack.empty() && inStack.empty();
    }
private:
    stack<int> inStack;
    stack<int> outStack;
};