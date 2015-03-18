import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Your submission should *ONLY* use the following class name
public class Problem
{
	public void init() {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[][] maze = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = scan.nextInt();
			}
		}
		int[][] record = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int tempValue = maze[i][j];
				if (i - 1 >= 0) {
					tempValue = Math.max(tempValue, maze[i][j] + record[i - 1][j]);
				}
				if ( j - 1 >= 0) {
					tempValue = Math.max(tempValue, maze[i][j] + record[i][j - 1]);
				}
				record[i][j] = tempValue;
			}
		}
		System.out.println(record[m - 1][n - 1]);
		scan.close();
	}
    public static void main(String[] args)
    {
    	Problem tool = new Problem();
    	tool.init();

       
    }

}