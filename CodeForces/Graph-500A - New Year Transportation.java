import java.util.Scanner;
import java.util.Arrays;
public class Solution{
	int length;
	int endIndex;
	int[] connect;

	public void inital(){
		Scanner scan = new Scanner(System.in);
		length = scan.nextInt();
		endIndex = scan.nextInt() - 1;
		connect = new int[length - 1];
		for(int i = 0;i < connect.length;i ++){
			connect[i] = scan.nextInt() + i;
		}
		scan.close();
		return;
	}
	public boolean hasRoute(){
		boolean[] record = new boolean[length];
		Arrays.fill(record, false);
		int index = 0;
		while(!record[index]){
			record[index] = true;
			if(index == endIndex)
				return true;
			if(index == length - 1)
				return false;
			index = connect[index];
		}
		return false;
	}

	public static void main(String[] args){
		Solution tempSolution = new Solution();
		tempSolution.inital();
		if(tempSolution.hasRoute())
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
