import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public int result = 0;
	public int globalIndex = 0;
	public class TrieTreeNode {
		int depth;
		int count;
		boolean isWord;
		int[] children;
		public TrieTreeNode(int t_depth) {
			depth = t_depth;
			isWord = false;
			count = 0;
			children = new int[26];
			Arrays.fill(children, -1);
		}
	}
	TrieTreeNode[] nodePool = new TrieTreeNode[1000005];

	public void addWord(TrieTreeNode root, String input){
		boolean hasAdd = false;
		for (int i = 0; i < input.length(); i++) {
			int index = input.charAt(i) - 'a';
			if(root.children[index] == -1) {
				root.children[index] = globalIndex;
				globalIndex++;
				clearNode(nodePool[root.children[index]], root.depth + 1);
				if (!hasAdd) {
					hasAdd = true;
					result += nodePool[root.children[index]].depth;
				}
			}
			root = nodePool[root.children[index]];
			root.count++;
			if (i == input.length() - 1) {
				root.isWord = true;
				if (!hasAdd) {
					result += input.length();
				}
			}
		}
	}

	public void clearNode(TrieTreeNode root, int depth) {
		root.depth = depth;
		root.isWord = false;
		root.count = 0;
		Arrays.fill(root.children, -1);
		return;
	}

	public void init(){
		MyScanner scan = new MyScanner();
      	out = new PrintWriter(new BufferedOutputStream(System.out));
		for (int i = 0; i < nodePool.length; i++) {
			nodePool[i] = new TrieTreeNode(0);
		}

		int testCount = Integer.valueOf(scan.nextLine());
		for (int i = 0; i < testCount; i++) {
			TrieTreeNode root = nodePool[0];
			globalIndex = 1;
			clearNode(root, 0);
			result = 0;
			int wordCount = Integer.valueOf(scan.nextLine());
			for (int j = 0; j < wordCount; j++) {
				addWord(root, scan.nextLine());
			}

			// traverse(root);
			out.println("Case #" + (i + 1) + ": " + result);
		}

		//scan.close();
		out.close();
	}
	
	//-----------PrintWriter for faster output---------------------------------
	   public static PrintWriter out;
	      
	   //-----------MyScanner class for faster input----------
	   public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
	}
}