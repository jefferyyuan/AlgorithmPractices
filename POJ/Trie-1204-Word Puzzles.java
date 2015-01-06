//	Only use Trie tree basic implementation
//	It is said that using KMP can improve the performance
//	ref: http://www.xuebuyuan.com/1294530.html
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	static int charCount = 26;

	int[] addRow = {-1, -1, 0, 1, 1, 1, 0, -1};
	int[] addColumn = {0, 1, 1 ,1 ,0, -1, -1, -1};

 	public class TreeNode{
		int wordIndex;
		TreeNode[] children;
		public TreeNode(){
			wordIndex = -1;
			children = new TreeNode[charCount];
			Arrays.fill(children,null);
		}
	}

	public class ResultData{
		int row, column;
		int direction;
		public ResultData(int t_row, int t_column, int t_direction){
			row = t_row;
			column = t_column;
			direction = t_direction;
		}
	}
	TreeNode root;
	char[][] board;
	int rowCount, columnCount;
	List<String> words;

	public Main(int m, int n, List<String> t_words, char[][] t_board){
		rowCount = m;
		columnCount = n;
		words = t_words;
		board = t_board;
		build();
	}

	public void build(){
		root = new TreeNode();
		for(int i = 0;i < words.size();i ++){
			String input = words.get(i);
			TreeNode traverse = root;
			for(int j = 0;j < input.length();j ++){
				int index = input.charAt(j) - 'A';
				if(traverse.children.get(index) == null){
					TreeNode tempNode = new TreeNode();
					traverse.children.set(index, tempNode);
				}
				traverse = traverse.children.get(index);
			}
			traverse.wordIndex = i;
		}
	}

	public void solve(){
		ResultData[] result = new ResultData[words.size()];
		Arrays.fill(result, null);
		for(int i = 0;i < rowCount;i ++){
			for(int j = 0;j < columnCount;j ++){
				int x = i, y = j;
				for(int k = 0;k < 8;k ++){
					TreeNode traverse = root;
					while( x >= 0 && x < m && y >= 0 && y < n){
						int index = board[x][y] - 'A';
						if(traverse.children.get(index) == null)
							break;
						else if(traverse.children.get(index).wordIndex >= 0){
							ResultData tempResult = new ResultData(i, j, k);
							result[traverse.children.get(index).wordIndex] = tempResult;
						}
						x += addRow[k];
						y += addColumn[k];
						traverse = traverse.children.get(index);
					}
				}
			}
		}
		for(int i = 0;i < result.length; i ++){
			System.out.println(result[i].row + " " + result[i].column + " " + 'A' + result[i].direction);
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int wordCount = scan.nextInt();
		char[][] board = new char[m][n];
		for(int i = 0;i < m;i ++){
			String input = scan.next();
			for(int j = 0;j < n;j ++)
				board[i][j] = input.charAt(j);
		}
		List<String> words = new ArrayList<String>();
		for(int i = 0;i < wordCount;i ++){
			words.add(scan.next());
		}
		Main solution = new Main(m, n, words, board);
		solution.solve();
		scan.close;
	}
}