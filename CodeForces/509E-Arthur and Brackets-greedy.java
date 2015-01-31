import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int[] left;
	int[] right;
	int[] start;
	int n;
	public void solve(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		left = new int[n];
		right = new int[n];
		start = new int[n];
		for(int i = 0; i < n; i++){
			left[i] = scan.nextInt();
			right[i] = scan.nextInt();
		}
		StringBuffer resultBuffer = new StringBuffer();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < n; i++){
			resultBuffer.append('(');
			start[i] = resultBuffer.length() - 1;
			stack.push(i);
			while(!stack.empty() && start[stack.peek()] + left[stack.peek()] <= resultBuffer.length()){
				if(start[stack.peek()] + right[stack.peek()] < resultBuffer.length()){
					System.out.println("IMPOSSIBLE");
					scan.close();
					return;
				}
				resultBuffer.append(')');
				stack.pop();
			}
		}
		if(!stack.empty()){
			System.out.println("IMPOSSIBLE");
		} else{
			System.out.println(resultBuffer.toString());
		}		
		scan.close();
		return;
	}
	public static void main(String[] args){
		Solution tool = new Solution();
		tool.solve();
	}
}