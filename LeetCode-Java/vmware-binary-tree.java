import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	static public class Node {
		Node parent;
		Node left;
		Node right;
		int state;
		String val;
		public Node(String x) {
			val = x;
			parent = null;
			left = null;
			right = null;
			state = 0;
		}
	}
	static int heightOfTree(String enc) {
		String[] input = enc.split(" ");
		Node current = null;
		Node result = null;
		for (int i = 0; i < input.length; i++) {
			if (input[i].compareTo("*") == 0) {
				if(current == null)
					return -1;
				current.state++;
				if(current.state == 2) {
					while(current != null && current.state == 2) {
						current = current.parent;
					}
				}
			} else{
				Node tempNode = new Node(input[i]);
				tempNode.parent = current;
				if(result == null) {
					result = tempNode;
				} else if(current == null) {
					return -1;
				} else {
					if(current.state == 0) {
						current.left = tempNode;
					} else if(current.state == 1) {
						current.right = tempNode;
					} else {
						return -1;
					}
					current.state++; 
				}

				current = tempNode;
			}
		}
		return getDepth(result);

	}
	static int getDepth(Node root) {
		if(root == null)
			return 0;
		else 
			return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}

	public static void main(String[] args){	
		System.out.println(heightOfTree(new String("1 * *")));
	}
}