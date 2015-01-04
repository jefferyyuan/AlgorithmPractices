//	这里是最小堆的实现
//	最大堆的实现类似，替换比较方式即可
//	在不溢出的情况下，可以用max(source) - source[i]建立起最小堆，然后再还原回去的方式来实现最大堆
public class MinHeap{
	ArrayList<Integer> heap;
	public MinHeap(){
		heap = new ArrayList<Integer>();
	}

	/*
	 *	Initialize a min heap from an unsorted array using adjust
	 *	time complexity: O(n)
	 */
	public MinHeap(int[] source){
		heap = new ArrayList<Integer>();
		for(int i = 0;i < source.length;i ++){
			heap.add(source[i]);
		}
		this.adjust(source.length - 1);
	}

	/*
	 *	Add an element to min heap
	 *	1. add the element to the end of the arraylist
	 *	2. float the element if not valid
	 */
	public void add(int value){
		heap.add(value);
		int index = heap.size() - 1;
		while(index > 0 && heap.get(index) < heap.get((index + 1) / 2 - 1)){
			Collections.swap(heap, index, (index + 1) / 2 - 1);
			index = (index + 1) / 2 - 1;
		}
	}

	/*
	 *	Delete an element from min heap
	 *	1. swap the element and the last element
	 *	2. drop the element if not valid
	 */
	public void remove(int removeIndex){
		int lastIndex = heap.size() - 1;
		if(removeIndex > lastIndex)
			return;
		else if(removeIndex == lastIndex)
			heap.remove(removeIndex);
		else{
			Collections.swap(heap, removeIndex, lastIndex);
			heap.remove(lastIndex);
			heapDown(removeIndex, lastIndex);
		}
	}

	public void heapDown(int downIndex, int size){
		while(true){
			int childIndex = 2 * downIndex + 1;
			if(childIndex + 1 < size && heap.get(childIndex + 1) < heap.get(childIndex))
				childIndex ++;
			if(childIndex >= size || heap.get(downIndex) < heap.get(childIndex))
				break;
			else{
				Collections.swap(heap, downIndex, childIndex);
				downIndex = childIndex;
			}
		}
	}
	/*
	 *	Adjust the arraylist so that it is a min heap afterwards
	 *  From the last father node down to the first father node
	 * 	Change and swap the values if needed so that each father-left-right group satisfy the property of min heap
	 *	This method is used in both the initialization and the sort method
	 */
	public void adjust(int endIndex){
		endIndex = Math.min(endIndex, heap.size() - 1);
		if(endIndex < 1)
			return;
		int rootLength = (endIndex + 1) / 2 - 1;
		for(int i = rootLength;i >= 0;i --){
			heapDown(i, endIndex + 1);
		}
		return;
	}

	public void sort(){
		for(int i = 0;i < heap.size();i ++){
			Collections.swap(heap, 0, heap.size() - 1 -i);
			this.adjust(heap.size() - 1 - i - 1);
		}
		return;
	}

	public void print(){
		for(int i = 0;i < heap.size();i ++){
			System.out.print(heap.get(i) + " ");
		}
		System.out.println();
	}

}

public void test_1(){
	int[] source = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	MinHeap tempHeap = new MinHeap(source);
	tempHeap.print();
	tempHeap.remove(3);
	tempHeap.print();
	tempHeap.add(11);
	tempHeap.print();
	tempHeap.sort();
	tempHeap.print();
}