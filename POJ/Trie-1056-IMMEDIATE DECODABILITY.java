import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	static int sCharCount = 2;
	TreeNode root;
	public class TreeNode{
		int val;
		boolean isWord;
		List<TreeNode> children;
		public TreeNode(int t_val){
			val = t_val;
			isWord = false;
			children = new ArrayList<TreeNode>();
			for (int i = 0; i < sCharCount; i ++)
				children.add(null);
		}
	}
	public Main(){
		root = new TreeNode(-1);
	}
	
	public void reset(){
		root = new TreeNode(-1);
	}
	public  boolean insert(String input){
		TreeNode traverse = root;
		boolean meetWord = false;
		boolean newBranch = false;
		for (int i = 0; i <= input.length(); i++){
			if(traverse.isWord)
				meetWord = true;
			if(i == input.length()){
				traverse.isWord = true;
				break;
			}
			int index = input.charAt(i) - '0';
			if(traverse.children.get(index) == null){
				newBranch = true;
				TreeNode tempNode = new TreeNode(index);
				traverse.children.set(index, tempNode);
			}
			traverse = traverse.children.get(index);
		}
		return meetWord || (!newBranch);
	}

	public static void main(String[] args){
		String sign = "9";
		Scanner scan = new Scanner(System.in);
		boolean result = false;
		int count = 1;
		Main tempSolution = new Main();
		while(scan.hasNext()){
			String input = scan.next();
			if(input.compareTo(sign) == 0){
				if(!result)
					System.out.println("Set " + count + " is immediately decodable");
				else
					System.out.println("Set " + count + " is not immediately decodable");
				count ++;
				result = false;
				tempSolution.reset();
			} else{
				if(result)
					continue;
				result = tempSolution.insert(input);
			}
		}
		scan.close();
	}
}