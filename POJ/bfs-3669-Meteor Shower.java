import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//bfs practices
public class Main{
	int[][] record;
	boolean[][] used;
	Scanner scan;
	int MAX = 305;
	int TIME_MAX = 1001;
	public Main(){
		record = new int[MAX][MAX];
		used = new boolean[MAX][MAX];
		for(int i = 0;i < MAX; i++){
			Arrays.fill(record[i], TIME_MAX);
			Arrays.fill(used[i], false);
		}
		scan = new Scanner(System.in);
	}
	public int getTime(int x,int y){
		int result = record[x][y];
		int[] addX = {-1, 1, 0, 0};
		int[] addY = {0, 0, 1, -1};
		for(int j = 0; j < addX.length; j++){
			int tempX = x + addX[j];
			int tempY = y + addY[j];
			if(tempX < 0 || tempX >= MAX || tempY < 0 || tempY >= MAX)
				continue;
			result = Math.min(result,record[tempX][tempY]);
		}
		return result;
	}
	public void solve(){
		int hitCount = scan.nextInt();
		for(int i = 0;i < hitCount; i ++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			int time = scan.nextInt();
			record[x][y] = Math.min(time, record[x][y]);
		}
		int result = -1;
		if(getTime(0,0) > 0){
			int time = 0;
			ArrayList<Integer> xList = new ArrayList<Integer>();
			ArrayList<Integer> yList = new ArrayList<Integer>();
			xList.add(0);
			yList.add(0);
			while(xList.size() > 0){
				int originalCount = xList.size();
				for(int i = 0; i < originalCount; i++){
					int x = xList.get(i);
					int y = yList.get(i);
					if(used[x][y])
						continue;
					used[x][y] = true;
					if(getTime(x, y) == TIME_MAX){
						result = time;
						break;
					}
					int[] addX = {-1, 1, 0, 0};
					int[] addY = {0, 0, -1, 1};
					for(int j = 0; j < addX.length; j++){
						int tempX = x + addX[j];
						int tempY = y + addY[j];
						if(tempX < 0 || tempX >= MAX || tempY < 0 || tempY >= MAX)
							continue;
						if(getTime(tempX, tempY) > time + 1){
							xList.add(tempX);
							yList.add(tempY);
						}
					}
				}
				if(result != -1)
					break;
				time++;
				xList.subList(0, originalCount).clear();
				yList.subList(0, originalCount).clear();
			}	
		}
		System.out.println(result);
	}
	
	
	public static void main(String[] args){
		Main solution = new Main();
		solution.solve();
		solution.scan.close();
	}
}