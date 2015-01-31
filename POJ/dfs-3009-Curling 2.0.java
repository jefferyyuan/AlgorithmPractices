import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//	dfs practices
public class Main{
	int[][] board;
	Scanner scan;
	int row,column;
	public Main(){
		board = new int[20][20];
		scan = new Scanner(System.in);
	}

	public boolean solve(){
		column = scan.nextInt();
		row = scan.nextInt();
		if(column == 0 && row == 0)
			return false;
		int startX = -1;
		int startY = -1;
		for(int i = 0;i < row; i++){
			for(int j = 0; j < column; j++){
				board[i][j] = scan.nextInt();
				if(board[i][j] == 2){
					startX = i;
					startY = j;
				}
			}
		}
		int result =  dfs(startX, startY, 0, 10);
		result = result > 10 ? -1 : result;
		System.out.println(result);
		return true;
	}

	public int dfs(int x, int y, int count, int limit){
		if(count > limit)
			return limit + 1;
		count ++;
		int result = limit + 1;
		int[] addX = {0, 0, -1, 1};
		int[] addY = {1, -1, 0, 0};
		for(int i = 0; i < addX.length; i++){
			int tempX = x, tempY = y;
			while(tempX >= 0 && tempX < row && tempY >= 0 && tempY < column){
				if(board[tempX][tempY] == 3){
					return count;
				}
				// meet block
				if(board[tempX][tempY] == 1){
					//	can not move toward block in the first place
					if(tempX - x == addX[i] && tempY - y == addY[i])
						break;
					//	dfs and back tracing
					board[tempX][tempY] = 0;
					int tempResult = dfs(tempX - addX[i], tempY - addY[i], count, limit);
					result = Math.min(result, tempResult);
					board[tempX][tempY] = 1;
					break;
				} 
				tempX += addX[i];
				tempY += addY[i];
			}
		}
		return result;
	}
	public static void main(String[] args){
		Main solution = new Main();
		while(solution.solve());
		solution.scan.close();
	}
}