public class MinStack{
	Stack<Integer> completeStack;
	Stack<Integer> minStack;

	public MinStack(){
		completeStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	public int pop(){
		int value = completeStack.pop();
		if(value == minStack.peek())
			minStack.pop();
		return value;
	}

	public void push(int value){
		completeStack.push(value);
		if(minStack.empty() || value <= minStack.peek())
			minStack.push(value);
	}

	public int getMin(){
		return minStack.peek();
	}
	public boolean isEmpty(){
		return completeStack.empty();
	}
}

public void test_1(){
	MinStack tempStack = new MinStack();
	tempStack.push(3);
	tempStack.push(2);
	tempStack.push(1);
	System.out.println(tempStack.getMin());
	tempStack.pop();
	System.out.println(tempStack.getMin());
	tempStack.pop();
	System.out.println(tempStack.getMin());
}