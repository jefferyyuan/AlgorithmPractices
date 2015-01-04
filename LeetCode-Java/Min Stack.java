class MinStack {
    Stack<Integer> realStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        if(minStack.empty() || x <= minStack.peek())
            minStack.push(x);
        realStack.push(x);
    }

    public void pop() {
        if(realStack.peek().equals(minStack.peek()))
            minStack.pop();
        realStack.pop();
    }

    public int top() {
        return realStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
