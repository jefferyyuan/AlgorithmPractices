//	dfs practices
//	挑战程序设计竞赛 p45
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int pointCount = scan.nextInt();
		while(!(r == -1 && pointCount == -1)){
			int count = 0;
			int[] position = new int[pointCount];
			for(int i = 0; i < pointCount; i++)
				position[i] = scan.nextInt();
			Arrays.sort(position);
			if(pointCount == 0)
				System.out.println(0);
			else{
				int index = 0;
				int pre = 0;
				while(index < position.length){
					count ++;
					pre = index;
					index ++;
					while(index < position.length && position[index] <= position[pre] + r)
						index ++;
					int targetIndex = index - 1;
					while(index < position.length && position[index] <= position[targetIndex] + r)
						index ++;
				}
				System.out.println(count);
			}
			r = scan.nextInt();
			pointCount = scan.nextInt();			
		}
	}
}