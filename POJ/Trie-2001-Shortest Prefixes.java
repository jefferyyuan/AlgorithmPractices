import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	static int charCount = 26;

	public class TreeNode{
		int count;
		TreeNode[] children;
		public TreeNode(){
			children = new TreeNode[charCount];
			count = 0;
			Arrays.fill(children, null);
		}
	}

	TreeNode root;

	public Main(){
		root = new TreeNode();
	}

	public void insert(String input){
		TreeNode traverse = root;
		for(int i = 0;i < input.length();i ++){
			int index = input.charAt(i) - 'a';
			if(traverse.children[index] == null){
				traverse.children[index] = new TreeNode();
			}
			traverse = traverse.children[index];
			traverse.count = traverse.count + 1;
		}
		return;
	}

	public String solve(String input){
		StringBuffer result = new StringBuffer(input);
		result.append(' ');
		TreeNode traverse = root;
		for(int i = 0;i < input.length();i ++){
			result.append(input.charAt(i));
			int index = input.charAt(i) - 'a';
			traverse = traverse.children[index];
			if(traverse.count <= 1){
				break;
			}
		}
		return result.toString();
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Main solution = new Main();
		List<String> record = new ArrayList<String>();
		while(scan.hasNext()){
			String input = scan.next();
			solution.insert(input);
			record.add(input);
		}
		for(int i = 0;i < record.size();i ++)
			System.out.println(solution.solve(record.get(i)));
		scan.close();
		return;
	}
}
