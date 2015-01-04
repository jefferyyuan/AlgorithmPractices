public class StackInfo{
	int start;
	int capacity;
	int pointer;
	int totalSize;
	public StackInfo(int t_start, int t_capacity, int t_total){
		start = t_start;
		capacity = t_capacity;
		totalSize = t_total;
		pointer = (start - 1 + totalSize) % totalSize;
	}
	public boolean isEmpty(){
		return pointer == (start + totalSize - 1) % totalSize;
	}

	public int nextElement(){
		return (pointer + 1) % totalSize;
	}

	public int prevElement(){
		return (pointer - 1 + totalSize) % totalSize;
	}

	public int size(){
		return (pointer + 1 + totalSize - start) % totalSize;
	}

	public boolean isInRange(int index){
		if(start + capacity <= totalSize){
			if(index >= start && index < start + capacity)
				return true;
			else
				return false;
		}
		else{
			if(index >= start || index < (start + capacity) % totalSize)
				return true;
			else
				return false;
		}
	}
}

public class OneArrayThreeStacks{
	int totalSize;
	int defaultSize;
	int[] numbers;
	StackInfo[] stacks;
	int stackCount = 3;

	public OneArrayThreeStacks(int t_total, int t_default)throws Exception{
		totalSize = t_total;
		defaultSize = t_default;
		if(totalSize < defaultSize * stackCount)
			throw new Exception("Not enough space.");
		numbers = new int[totalSize];
		stacks = new StackInfo[3];
		for(int i = 0;i < stackCount;i ++){
			int tempSize = defaultSize;
			if(i == stackCount - 1)
				tempSize = totalSize - (stackCount - 1) * defaultSize;
			stacks[i] = new StackInfo(i * defaultSize, tempSize, totalSize);
		}
	}

	public void push(int stackIndex, int value) throws Exception{
		checkStackIndex(stackIndex);

		if(isFull())
			throw new Exception("Not enough space for push operation.");
		StackInfo tempStack = stacks[stackIndex];
		if(tempStack.size() == tempStack.capacity){
			int nextIndex = (stackIndex + 1) % stackCount;
			shiftRight(nextIndex);
			tempStack.capacity ++;
		}
		tempStack.pointer = tempStack.nextElement();
		numbers[tempStack.pointer] = value;
	}

	public void shiftRight(int stackIndex) throws Exception{
		checkStackIndex(stackIndex);

		StackInfo tempStack = stacks[stackIndex];
		if(tempStack.size() == tempStack.capacity){
			int nextIndex = (stackIndex + 1) % stackCount;
			shiftRight(nextIndex);
			for(int i = tempStack.start + tempStack.capacity; i >= tempStack.start; i --)
				numbers[i % totalSize] = numbers[(i - 1) % totalSize];
			tempStack.start = (tempStack.start + 1) % totalSize;
			tempStack.pointer = (tempStack.pointer + 1) % totalSize;
		}
		else{
			for(int i = tempStack.pointer; i != (tempStack.start - 1 + totalSize) % totalSize; i = (i - 1 + totalSize) % totalSize){
				numbers[(i + 1) % totalSize] = numbers[i];
			}
			tempStack.start = (tempStack.start + 1) % totalSize;
			tempStack.pointer = (tempStack.pointer + 1) % totalSize;
			tempStack.capacity --;
		}
	}

	public int pop(int stackIndex) throws Exception{
		checkStackIndex(stackIndex);

		StackInfo tempStack = stacks[stackIndex];
		if(tempStack.isEmpty())
			throw new Exception("Trying to pop an empty stack.");
		int result = numbers[tempStack.pointer];
		tempStack.pointer = tempStack.prevElement();
		return result;
	}

	public int peek(int stackIndex) throws Exception{
		checkStackIndex(stackIndex);

		StackInfo tempStack = stacks[stackIndex];
		if(tempStack.isEmpty())
			throw new Exception("Trying to peek an empty stack.");
		return numbers[tempStack.pointer];
	}

	public void checkStackIndex(int stackIndex) throws Exception{
		if(stackIndex < 0 || stackIndex >= stackCount)
			throw new Exception("Invalid stack index.");
	}
	public boolean isFull(){
		int sizeCount = 0;
		for(int i = 0;i < stackCount;i ++)
			sizeCount += stacks[i].size();

		return sizeCount == totalSize;
	}

	public boolean isEmpty(){
		for(int i = 0;i < stackCount;i ++){
			if(!stacks[i].isEmpty())
				return false;
		}
		return true;
	}

	void print(int stackIndex) throws Exception{
		checkStackIndex(stackIndex);
		StackInfo tempStack = stacks[stackIndex];
		System.out.println("Stack Index: " + stackIndex + "\nStack Size: " + tempStack.size());
		System.out.println("Stack Capacity: " + tempStack.capacity);
		for(int i = tempStack.start;i < tempStack.start + tempStack.size();i ++)
			System.out.print(numbers[i % totalSize] + " ");
		System.out.println();
	}
}

public void test_1() throws Exception{
	OneArrayThreeStacks tempStacks = new OneArrayThreeStacks(20,4);
	tempStacks.push(0, 1);
	tempStacks.push(0, 2);
	tempStacks.push(1, 1);
	tempStacks.push(1, 2);
	tempStacks.push(1, 3);
	tempStacks.push(1, 4);
	tempStacks.push(1, 5);
	tempStacks.push(1, 6);
	tempStacks.push(1, 7);
	tempStacks.push(2, 1);
	tempStacks.push(2, 2);
	tempStacks.push(2, 3);
	tempStacks.push(2, 4);
	tempStacks.push(2, 5);
	tempStacks.push(2, 6);
	tempStacks.push(2, 7);
	tempStacks.push(2, 8);
	tempStacks.push(2, 9);
	tempStacks.push(2, 10);
	tempStacks.push(2, 11);
	tempStacks.print(0);
	tempStacks.print(1);
	tempStacks.print(2);
	tempStacks.pop(1);
	tempStacks.pop(1);
	tempStacks.print(1);
	tempStacks.push(2, 14);
	tempStacks.push(2, 15);
	tempStacks.print(2);
	tempStacks.print(1);
}