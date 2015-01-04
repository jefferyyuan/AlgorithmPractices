public class OneArrayThreeStacks{
	int stackSize;
	int[] numbers;
	int[] pointers;

	public OneArrayThreeStacks(int tempLength){
		stackSize = tempLength;
		numbers = new int[3 * stackSize];
		pointers = new int[3];
		pointers[0] = 0;
		pointers[1] = stackSize;
		pointers[2] = 2 * stackSize;
	}

	int peek(int stackIndex) throws Exception{
		return numbers[pointers[stackIndex]];
	}
	int pop(int stackIndex) throws Exception{
		if(pointers[stackIndex] == stackIndex * stackSize)
			throw new Exception("Trying to pop an empty stack.");
		else{
			pointers[stackIndex] --;
			return numbers[pointers[stackIndex]];
		}
	}
	void push(int stackIndex, int value){
		if(pointers[stackIndex] >= (stackIndex + 1) * stackSize)
			throw new Exception("Out of space.");
		else{
			numbers[pointers[stackIndex]] = value;
			pointers[stackIndex] ++;
		}
	}

	boolean isEmpty(int stackIndex){
		return pointers[stackIndex] == stackIndex * stackSize;
	}

	int size(int stackIndex){
		return pointers[stackIndex] - stackIndex * stackSize;
	}

	void print(int stackIndex){
		System.out.println("Stack Index: " + stackIndex + "\nStack Size: " + size(stackIndex));
		for(int i = stackIndex * stackSize;i < pointers[stackIndex];i ++)
			System.out.print(numbers[i] + " ");
		System.out.println();
	}
}

public void test_1() throws Exception{
	OneArrayThreeStacks tempStacks = new OneArrayThreeStacks(4);
	tempStacks.push(0, 1);
	tempStacks.push(0, 2);
	tempStacks.push(0, 3);
	tempStacks.push(0, 4);
	tempStacks.print(0);
	tempStacks.pop(0);
	tempStacks.pop(0);
	tempStacks.print(0);
}