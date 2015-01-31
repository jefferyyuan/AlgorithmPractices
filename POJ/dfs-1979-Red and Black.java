import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//	dfs practices
public class Main{
	char[][] boards;
	Scanner scan;
	public Main(){
		scan = new Scanner(System.in);
		boards = new char[22][22];
		for(int i = 0;i < 22; i++){
			Arrays.fill(boards[i],'#');
		}
	}
	public boolean solve(){
		int column = scan.nextInt();
		int row = scan.nextInt();
		if(column == 0 && row == 0)
			return false;
		int count = 0;
		int startX = -1, startY = -1;
		for(int i = 0; i <= column + 1; i++){
			boards[0][i] = '#';
			boards[row + 1][i] = '#';
		}
		for(int i = 0; i <= row + 1; i++){
			boards[i][0] = '#';
			boards[i][column + 1] = '#';
		}
		while(count < row){
			String line = scan.nextLine();
			if(line.length() != column)
				continue;
			count ++;
			for(int i = 0;i < column;i ++){
				char c = line.charAt(i);
				if(c == '@'){
					startX = count;
					startY = i + 1;
				}
				if(c != '#')
					boards[count][i + 1] = '.';
				else
					boards[count][i + 1] = '#';
			}
		}
		System.out.println(dfs(startX, startY));
		return true;
	}
	public int dfs(int x, int y){
		if(boards[x][y] == '#')
			return 0;
		int result = 1;
		boards[x][y] = '#';
		int[] addX = {-1, 0, 1, 0};
		int[] addY = {0, 1, 0, -1};
		for(int i = 0;i < addX.length; i ++){
			result += dfs(x + addX[i], y + addY[i]);
		}
		return result;
	}

	public void close(){
		scan.close();
	}
	public static void main(String[] args){
		Main solution = new Main();
		while(solution.solve());
		solution.close();
	}
}