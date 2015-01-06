import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	static int charCount = 128;

	public class TreeNode{
		int wordCount;
		TreeNode[] children;
		public TreeNode(){
			wordCount = 0;
			children = new TreeNode[charCount];
			Arrays.fill(children, null);
		}
	}
	public class ResultData{
		String treeName;
		int count;
		public ResultData(String t_name, int t_count){
			treeName = t_name;
			count = t_count;
		}
	}
	TreeNode root;
	int totalCount;
	NumberFormat formatter = new DecimalFormat("#0.0000");
	
	public Main(){
		root = new TreeNode();
		totalCount = 0;
	}

	public void insert(String input){
		TreeNode traverse = root;
		for(int i = 0;i < input.length();i ++){
			int index = input.charAt(i) - ' ';
			if(traverse.children[index] == null){
				traverse.children[index] = new TreeNode();
			}
			traverse = traverse.children[index];
		}
		traverse.wordCount ++;
		totalCount ++;
	}

	public void solve(){
		StringBuffer record = new StringBuffer();
		dfs(root, record);
	}
	public void dfs(TreeNode current, StringBuffer record ){
		if(current == null)
			return;
		if(current.wordCount > 0){
			System.out.println(record.toString() + " " + formatter.format(current.wordCount * 100.0 / totalCount));
		}
		for(int i = 0;i < charCount;i ++){
			TreeNode tempNode = current.children[i];
			if(tempNode == null)
				continue;
			else{
				char c = (char) (' ' + i);
				record.append(c);
				dfs(current.children[i], record);
				record.deleteCharAt(record.length() - 1);
			}
		}
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Main solution = new Main();
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			solution.insert(input);
		}
		solution.solve();
		return;
	}
}
