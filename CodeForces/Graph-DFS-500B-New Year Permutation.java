import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Solution{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] numbers = new int[size];
		for(int i = 0;i < size;i ++)
			numbers[i] = scan.nextInt();
		boolean[][] route = new boolean[size][size];
		for(int i = 0;i < size;i ++){
			String input = scan.next();
			for(int j = 0;j < size;j ++){
				if(input.charAt(j) == '0')
					route[i][j] = false;
				else
					route[i][j] = true;
			}
		}
		int iterationCount = 0;
		int[] iterationRecord = new int[size];
		Arrays.fill(iterationRecord, 0);
		Stack<Integer> nodeStack = new Stack<Integer>();
		for(int i = 0;i < size;i ++){
			if(iterationRecord[i] > 0)
				continue;
			//	find strong connection component
			iterationCount ++;
			nodeStack.push(i);
			ArrayList<Integer> tempNumbers = new ArrayList<Integer>();
			while(!nodeStack.empty()){
				int index = nodeStack.pop();
				if(iterationRecord[index] > 0)
					continue;
				iterationRecord[index] = iterationCount;
				tempNumbers.add(numbers[index]);
				//	using array will O(n)
				//	sparse graph should use adjacent list
				for(int j = 0;j < size;j ++){
					if(route[index][j] && iterationRecord[j] == 0)
						nodeStack.push(j);
				}
			}
			// sort the connection component elements in original
			Collections.sort(tempNumbers);
			int sortIndex = 0;
			for(int j = 0;j < size;j ++){
				if(iterationRecord[j] == iterationCount){
					numbers[j] = tempNumbers.get(sortIndex);
					sortIndex ++;
				}
			}
		}
		for(int i = 0;i < size;i ++){
			System.out.print(numbers[i] + " ");
		}
		scan.close();
	}
}