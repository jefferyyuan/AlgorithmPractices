import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int verticeCount;
	int[] degree;
	int[] xor;

	public void solve(){
		Scanner scan = new Scanner(System.in);
		int count = 0;
		//	get degrees and xor sum of adjacent vertices from standard input
		verticeCount = scan.nextInt();
		degree = new int[verticeCount];
		xor = new int[verticeCount];
		for (int i = 0; i < verticeCount; i++){
			degree[i] = scan.nextInt();
			count += degree[i];
			xor[i] = scan.nextInt();
		}
		System.out.println(count / 2);
		//	use a dfs scan to output
		for (int i = 0; i < verticeCount; i++){
			if(degree[i] != 1)
				continue;
			int index = i;
			while (degree[index] == 1){
				System.out.println(index + " " + xor[index]);
				degree[index] --;
				int nextIndex = xor[index];
				xor[nextIndex] ^= index;
				degree[nextIndex] --;
				xor[index] = 0;
				index = nextIndex;
			}
		}
		scan.close();
	}
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}
}