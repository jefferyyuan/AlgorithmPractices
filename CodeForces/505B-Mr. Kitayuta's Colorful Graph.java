import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public class Vertex{
		int id;
		List<Edge> edges;
		public Vertex(int t_id){
			id = t_id;
			edges = new ArrayList<Edge>();
		}
	}

	public class Edge{
		int des;
		int color;
		public Edge(int t_des, int t_color){
			des = t_des;
			color = t_color;
		}
	}

	int n, m;
	Vertex[] vList;

	public Solution(int t_n, int t_m){
		n = t_n;
		m = t_m;
		vList = new Vertex[n];
		for(int i = 0; i < n; i++){
			vList[i] = new Vertex(i);
		}
	}

	public int solve(int v1, int v2){
		int result = 0;
		boolean[] record = new boolean[n];
		for(int i = 1;i <= m; i++){
			Arrays.fill(record, true);
			if(solveByColor(v1, v2, i, record))
				result ++;
		}
		return result;
	}

	public boolean solveByColor(int v1, int v2, int color, boolean[] record){
		if(v1 == v2)
			return true;
		if(! record[v1])
			return false;
		record[v1] = false;
		for(int i = 0; i < vList[v1].edges.size(); i++){
			Edge tempEdge = vList[v1].edges.get(i);
			if(tempEdge.color != color)
				continue;
			boolean tempResult = solveByColor(tempEdge.des, v2, color, record);
			if(tempResult)
				return true;
		}
		record[v1] = true;
		return false;
	}
	public void addEdge(int v1, int v2, int color){
		vList[v1].edges.add(new Edge(v2, color));
		vList[v2].edges.add(new Edge(v1, color));
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		Solution solution = new Solution(n, m);
		for(int i = 0; i < m; i++){
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			int color = scan.nextInt();
			solution.addEdge(v1 - 1, v2 - 1, color);
		}
		int qCount = scan.nextInt();
		for(int i = 0; i < qCount; i++){
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			System.out.println(solution.solve(v1 - 1, v2 - 1));
		}
		scan.close();
	}
}