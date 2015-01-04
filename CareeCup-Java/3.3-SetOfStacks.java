public class SetOfStacks{
	List<Stack<Integer>> stackList;
	int stackSize;
	int count;
	public SetOfStacks(int t_size){
		stackSize = t_size;
		stackList = new ArrayList<Stack<Integer>>();
		count = stackSize;
	}

	public int pop(){
		int stackIndex = stackList.size() - 1;
		int result = stackList.get(stackIndex).pop();
		if(stackList.get(stackIndex).empty()){
			stackList.remove(stackIndex);
			count = stackSize;
		}
		else
			count --;
		return result;
	}

	public void push(int value){
		if(count == stackSize){
			Stack<Integer> tempStack = new Stack<Integer>();
			stackList.add(tempStack);
			count = 0;
		}
		int stackIndex = stackList.size() - 1;
		stackList.get(stackIndex).push(value);
		count ++;
	}

	public int peek(){
		int stackIndex = stackList.size() - 1;
		int result = stackList.get(stackIndex).peek();
		return result;
	}

	public boolean isEmpty(){
		return stackList.size() == 0;
	}
}

public void test_1(){
	SetOfStacks tempStacks = new SetOfStacks(3);
	tempStacks.push(1);
	tempStacks.push(2);
	tempStacks.push(3);
	tempStacks.push(4);
	tempStacks.push(5);
	tempStacks.push(6);
	System.out.println(tempStacks.pop());
	System.out.println(tempStacks.pop());
	System.out.println(tempStacks.pop());
	System.out.println(tempStacks.pop());
	System.out.println(tempStacks.pop());
	System.out.println(tempStacks.pop());

}