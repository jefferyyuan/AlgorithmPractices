//greedy practices
//minHeap implementation
//挑战程序设计竞赛 p47
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
public class MinHeap{
	int maxSize = 20005;
	int size;
	int[] data;
	public MinHeap(){
		size = 0;
		data = new int[maxSize];
	}
	public void add(int val){
		data[size ++] = val;
		int index = size - 1;
		while(index > 0 && data[(index + 1) / 2 - 1] > data[index]){
			int temp = data[index];
			data[index] = data[(index + 1) / 2 - 1];
			data[(index + 1) / 2 - 1] = temp;
			index = (index + 1) / 2 - 1;
		}
	}

	public int pop(){
		int result = data[0];
		size --;
		if(size > 0){
			data[0] = data[size];
			//	drop down top node to satisfy definition
			int index = 0;
			while(index < size){
				int leftIndex = 2 * index + 1;
				int rightIndex = 2 * index + 2;
				int leftValue = leftIndex >= size ? Integer.MAX_VALUE : data[leftIndex];
				int rightValue = rightIndex >= size ? Integer.MAX_VALUE : data[rightIndex];
				int minIndex = index;
				if(data[minIndex] > leftValue)
					minIndex = leftIndex;
				if(rightValue < data[minIndex])
					minIndex = rightIndex;
				if(minIndex == index)
					break;
				else{
					int temp = data[minIndex];
					data[minIndex] = data[index];
					data[index] = temp;
					index = minIndex;
				}
			}
		}
		return result;
	}
}

public long solve(){
	Scanner scan = new Scanner(System.in);
	MinHeap heap = new MinHeap();
	int woodCount = scan.nextInt();
	for(int i = 0; i < woodCount; i++){
		heap.add(scan.nextInt());
	}
	scan.close();
	long result = 0;
	while(heap.size > 1){
		int min = heap.pop();
		int min2 = heap.pop();
		int newValue = min + min2;
		result += newValue;
		heap.add(newValue);
	}
	return result;
}
public static void main(String[] args){
	Main solution = new Main();
	System.out.println(solution.solve());
}
}