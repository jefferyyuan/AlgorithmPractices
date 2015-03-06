public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public ListNode reverse(ListNode root) {
	ListNode pre = null;
	ListNode current = root;
	while (current != null) {
		ListNode temp = current.next;
		current.next = pre;
		pre = current;
		current = temp;
	}
	return pre;
}

public ListNode create(int[] input) {
	ListNode result = null;
	ListNode pre = null;
	if(input == null) {
		return result;
	}
	for (int i = 0; i < input.length; i++) {
		ListNode tempNode = new ListNode(input[i]);
		if (pre != null) {
			pre.next = tempNode;
		}
		pre = tempNode;
		if (result == null) {
			result = tempNode;
		}
	}
	return result;
}

public void printList(ListNode root) {
	if (root == null) {
		return;
	}
	while (root != null) {
		System.out.print(root.val);
		if (root.next != null) {
			System.out.print("=>");
		}
		root = root.next;
	}
	System.out.println();
}