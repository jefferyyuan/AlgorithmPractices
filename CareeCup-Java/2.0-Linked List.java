
/*
 * 	implementation of ListNode and LinkedList
 * 	single linked list
 *	add integer value instead of ListNode so that I will not hurt the original object
 */
public class ListNode{
	int val;
	ListNode next;
	public ListNode(int v){
		this.val = v;
		next = null;
	}
}

public class LinkedList{
	ListNode head;
	ListNode tail;
	public LinkedList(){
		head = null;
		tail = null;
	}

	public void addToLast(int value){
		ListNode tempNode = new ListNode(value);
		if(tail != null)
			tail.next = tempNode;
		tail = tempNode;
		if(head == null) head = tempNode;
	}

	public void removeLast(){
		if(tail == null)
			return;
		else if(head == tail){
			head = null;
			tail = null;
			return;
		}
		else{
			ListNode temp = head;
			while(temp.next != tail){
				temp = temp.next;
			}
			tail = temp;
			tail.next = null;
		}
	}
	public void addToFirst(int value){
		ListNode tempNode = new ListNode(value);
		tempNode.next = head;
		head = tempNode;
		if(tail == null)
			tail = tempNode;
	}

	public void removeFirst(){
		if(head == null)
			return;
		else if(head == tail){
			head = null;
			tail = null;
			return;
		}
		else{
			head = head.next;
		}
	}

	/*
	 * 	Delete a given node from this LinkedList if it exists
	 */
	public void deleteNode(ListNode tempNode){
		ListNode traverseNode = this.head;
		ListNode pre = null;
		while(traverseNode != null && traverseNode != tempNode){
			pre = traverseNode;
			traverseNode = traverseNode.next;
		}
		if(traverseNode == null)
			return;
		else{
			if(pre != null)
				pre.next = traverseNode.next;
			else
				head = head.next;

			return;
		}
	}
}

/*
 *	For a given LinkedList(head node given), reverse its connection, and return the new head
 */
public ListNode reverseLinkedList(ListNode head){
	if(head == null || head.next == null)
		return head;

	ListNode current = head, pre = null;
	while(current.next != null)
	{
		ListNode newNode = current.next;
		current.next = pre;
		pre = current;
		current = newNode;
	}
	current.next = pre;
	return current;
}

/*
 * test null LinkedList reverse
 */
public void test_1()
{
	int testNo = 1;
	int[] valueArray = {};
	ListNode head = null, result = null;
	for(int i = 0;i < valueArray.length;i ++){
		ListNode tempNode = new ListNode(valueArray[i]);
		if(head != null)
			head.next = tempNode;
		if(result == null)
			result = tempNode;
		head = tempNode;
	}
	result = this.reverseLinkedList(result);
	if(result != null)
		System.out.println("Test case " + testNo + " failed:\nExpected: null\nOutput: " + result.val);
	else
		System.out.println("Test case " + testNo + " passed.");
}

/*
 * 	test non-empty LinkedList reverse
 * 	the values of the array can be changed in order to test different input
 */
public void test_2()
{
	int testNo = 2;
	int[] valueArray = {1};
	ListNode head = null, result = null;
	for(int i = 0;i < valueArray.length;i ++){
		ListNode tempNode = new ListNode(valueArray[i]);
		if(head != null)
			head.next = tempNode;
		if(result == null)
			result = tempNode;
		head = tempNode;
	}
	result = this.reverseLinkedList(result);
	boolean isValid = true;
	int index = valueArray.length - 1;
	while(index >= 0){
		if(result == null || result.val != valueArray[index]){
			isValid = false;
			break;
		}
		result = result.next;
		index --;
	}
	if(result != null)
		isValid = false;
	if(!isValid)
		System.out.println("Test case " + testNo + " failed.");
	else
		System.out.println("Test case " + testNo + " passed.");
}