import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//	not finished
public class Solution{

	public class Road{
		int des;
		boolean good;
	}
	int n, m;
	ArrayList<Road>[] roads;
	public Solution(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		roads = new ArrayList<Road>[n];
		for(int i = 0; i < n; i ++){
			roads[i] = new ArrayList<Road>();
		}
		for(int i = 0;i < m; i++){
			int start = scan.nextInt() - 1;
			int end = scan.nextInt() - 1;
			int condition = scan.nextInt();
			roads[start].add(new Road(end, condition == 1));
		}
	}

	public int bfs(){
		int[] record = new int[n];
		Arrays.fill(record, Integer.MAX_VALUE);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(0);
		int distance = 0;
		int count = 1;
		while(queue.size() > 0){
			int newCount = 0;
			while(count > 0){
				int tempPoint = queue.pollFirst();
				ArrayList<Road> tempRoads = roads[tempPoint];
			}
			distance ++;
		}
	}
	public static void main(String[] args){

	}
}