public class SortedStack{
	Stack<Integer> record;
	public SortedStack(){
		record = new Stack<Integer>();
	}

	public void push(int value){
		if(record.empty() || value >= record.peek())
			record.push(value);
		else{
			Stack<Integer> tempStack = new Stack<Integer>();
			while(!record.empty() && record.peek() > value)
				tempStack.push(record.pop());
			record.push(value);
			while(!tempStack.empty())
				record.push(tempStack.pop());
		}
	}

	public int pop(){
		return record.pop();
	}

	public void print(){
		Stack<Integer> tempStack = new Stack<Integer>();
		while(!record.empty()){
			int value = record.pop();
			System.out.print(value + " ");
			tempStack.push(value);
		}
		System.out.println();
		while(!tempStack.empty())
			record.push(tempStack.pop());
		return;
	}
}

public void test_1(){
	SortedStack tempStack = new SortedStack();
	tempStack.push(3);
	tempStack.push(2);
	tempStack.push(1);
	tempStack.print();
	tempStack.pop();
	tempStack.print();

}