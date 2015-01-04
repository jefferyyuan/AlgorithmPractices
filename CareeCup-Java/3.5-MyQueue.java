public class MyQueue{
	Stack<Integer> source;
	Stack<Integer> output;
	public MyQueue(){
		source = new Stack<Integer>();
		output = new Stack<Integer>();
	}

	public int pop(){
		if(output.empty()){
			while(!source.empty())
				output.push(source.pop());
		}
		return output.pop();
	}

	public void push(int value){
		source.push(value);
	}

	public boolean isEmpty(){
		return source.empty() && output.empty();
	}
}

public void test_1(){
	MyQueue tempQueue = new MyQueue();
	tempQueue.push(1);
	tempQueue.push(2);
	tempQueue.push(3);
	System.out.println(tempQueue.pop());
	System.out.println(tempQueue.pop());
	System.out.println(tempQueue.pop());
}