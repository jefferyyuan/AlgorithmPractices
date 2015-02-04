import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	char[][] board;
	int[][] dis;
	int n, m;
	public void init(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		board = new char[n][m];
		dis = new int[n][m];
		for(int i = 0; i < n; i++){
			Arrays.fill(dis[i], -1);
		}
		scan.nextLine();
		for(int i = 0; i < n; i++){
			String line = scan.nextLine();
			for(int j = 0; j < m; j++){
				board[i][j] = line.charAt(j);
			}
		}
		scan.close();
	}

	public void solve(){
		boolean result = false;
		for(int i = 0; i < n; i++){
			if(result)
				break;
			for(int j = 0; j < m; j++){
				result = dfs(board[i][j], i, j, i, j, 0);
				if(result)
					break;
			}
		}
		if(result)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public boolean dfs(char color, int x, int y, int targetX, int targetY, int curDistance){
		if(x < 0 || x >= n || y < 0 || y >= m)
			return false;
		if(dis[x][y] != -1)
			return (curDistance - dis[x][y] >= 4);
		if(board[x][y] != color)
			return false;
		dis[x][y] = curDistance;
		boolean result =  (dfs(color, x + 1, y, targetX, targetY, curDistance + 1)
				|| dfs(color, x - 1, y, targetX, targetY, curDistance + 1)
				|| dfs(color, x, y - 1, targetX, targetY, curDistance + 1)
				|| dfs(color, x, y + 1, targetX, targetY, curDistance + 1));
		dis[x][y]  = -1;
		return result;
	}
	public static void main(String[] args){
		Solution tool = new Solution();
		tool.init();
		tool.solve();
		
	}
}