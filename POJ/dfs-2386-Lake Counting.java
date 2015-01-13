//	dfs practices
// 	挑战程序设计竞赛 p32
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{

	public void dfs(int x, int y, boolean[][] record){
		int row = record.length;
		int column = record[0].length;
		record[x][y] = false;
		for (int i = Math.max(0, x - 1); i <= Math.min(row - 1, x + 1); i++){
			for (int j = Math.max(0, y - 1); j <= Math.min(column - 1, y + 1); j++){
				if(record[i][j])
					dfs(i, j, record);
			}
		}
		return;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Main solution = new Main();
		int row = scan.nextInt();
		int column = scan.nextInt();
		boolean[][] record = new boolean[row][column];
		for (int i = 0; i < row; i++){
			String tempLine = scan.nextLine();
			if(tempLine.length() != column){
				i --;
				continue;
			}
			for (int j = 0; j < column; j++){
				if(tempLine.charAt(j) == 'W')
					record[i][j] = true; 
				else
					record[i][j] = false;
			}
		}
		int result = 0;
		for (int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				if(record[i][j] == true){
					result ++;
					solution.dfs(i, j, record);
				}
			}
		}
		System.out.println(result);
	}
}