public class HanoiTower{
	int stackCount;
	List<Stack<Integer>> towers;
	public HanoiTower(int t_count){
		stackCount = t_count;
		towers = new ArrayList<Stack<Integer>>();
		for(int i = 0;i < stackCount;i ++)
			towers.add(new Stack<Integer>());
	}

	public void solve(int n){
		for(int i = n;i >= 1;i --)
			towers.get(0).push(i);
		print();

		solvePart(0, 1, 2,  n);

		print();

	}
	public void print(){
		for(int i = 0;i < stackCount;i ++){
			System.out.print("Tower " + i + ": ");
			Stack<Integer> record = new Stack<Integer>();
			Stack<Integer> tempStack = towers.get(i);
			while(!tempStack.empty()){
				int value = tempStack.pop();
				record.push(value);
				System.out.print(value + " ");
			}
			System.out.println();
			while(!record.empty()){
				tempStack.push(record.pop());
			}
		}
	}
	public void solvePart(int start, int mid, int target, int count){
		if(count == 0)
			return;
		solvePart(start, target, mid, count - 1);
		int value = towers.get(start).pop();
		towers.get(target).push(value);
		solvePart(mid, start, target, count - 1);
	}
}

public void test_1(){
	HanoiTower tempTower = new HanoiTower(3);
	tempTower.solve(10);
}