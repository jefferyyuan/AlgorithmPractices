import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	boolean[][] board;
	int n, m, k;
	public void solve(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		board = new boolean[n + 2][m + 2];
		for(int i = 0; i < n; i++){
			Arrays.fill(board[i], false);
		}
		int index = 0;
		for(int i = 0; i < k; i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			if(judge(x, y)){
				index = i + 1;
				break;
			}
		}
		System.out.println(index);
		scan.close();
		return;
	}

	public boolean judge(int x, int y){
		if(board[x][y])
			return false;
		board[x][y] = true;
		if(judgeSingle(x - 1, y - 1) || judgeSingle(x - 1, y) || judgeSingle(x, y - 1) || judgeSingle(x, y))
			return true;
		else 
			return false;
	}

	public boolean judgeSingle(int x, int y){
		if(board[x][y] && board[x + 1][y] && board[x][y + 1] && board[x + 1][y + 1])
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		Solution tool = new Solution();
		tool.solve();
	}
}