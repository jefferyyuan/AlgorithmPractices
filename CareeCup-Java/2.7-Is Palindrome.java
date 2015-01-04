
//	Each time I find the head and the tail, then I compare their values
//	O(n^2) time, O(1) space
public boolean isPalindrome(ListNode head){
	if(head == null || head.next == null)
		return true;
	ListNode preTail = null;
	while(true){
		int count = 0;
		ListNode traverse = head;
		while(traverse.next != preTail){
			traverse = traverse.next;
			count ++;
		}
		if(traverse.val != head.val)
			return false;
		if(count <= 2)
			break;
		preTail = traverse;
		head = head.next;
	}
	return true;
}

//	store the value into an arraylist and the compare
//	O(n) time, O(n) space
public boolean isPalindrome(ListNode head){
	if(head == null || head.next == null)
		return true;
	ArrayList<Integer> record = new ArrayList<Integer>();
	while(head != null){
		record.add(head.val);
		head = head.next;
	}
	for(int i = 0, j = record.size() - 1; i < j; i ++, j --){
		if(record.get(i) != record.get(j))
			return false;
	}
	return true;
}

//	use stack to store the first half
//	use slow and fast node to split the whole linked List
public boolean isPalindrome(ListNode head){
	if(head == null || head.next == null)
		return true;
	ListNode slow = head;
	Stack<ListNode> record = new Stack<ListNode>();
	ListNode fast = head;
	while(fast != null && fast.next != null){
		record.push(slow);
		slow = slow.next;
		fast = fast.next.next;
	}
	if(fast != null)
		slow = slow.next;
	while(slow != null){
		ListNode tempNode = record.pop();
		if(tempNode.val != slow.val)
			return false;
		slow = slow.next;
	}
	return true;
}

//	use recursive solution
//	use wrapper to pass value from generation to generation
public class ValueWrapper{
	ListNode tailNode;
}
public int getLength(ListNode head){
	int count = 0;
	while(head != null){
		head = head.next;
		count ++;
	}
	return count;
}
public boolean isPalindrome(ListNode head){
	int length = getLength(head);
	if(length <= 1)
		return true;
	ValueWrapper value = new ValueWrapper();
	return isPalindromePart(head, value, length);
}

public boolean isPalindromePart(ListNode head, ValueWrapper value, int length){
	if(length == 0){
		return true;
	}
	else if(length == 1){
		value.tailNode = head.next;
		return true;
	}
	else if(length == 2){
		value.tailNode = head.next.next;
		return head.val == head.next.val;
	}
	else{
		boolean nextResult = isPalindromePart(head.next,value,length - 2);
		if(!nextResult)
			return false;
		ListNode tail = value.tailNode;
		value.tailNode = tail.next;
		return head.val == tail.val;
	}
}


//	test cases
public void test_1(){
	int[] valueArray = {1};
	ListNode head = this.createLinkedList(valueArray);
	System.out.println(this.isPalindrome(head));
}

public void test_2(){
	int[] valueArray = {1,2};
	ListNode head = this.createLinkedList(valueArray);
	System.out.println(this.isPalindrome(head));
}

public void test_3(){
	int[] valueArray = {1,2,1};
	ListNode head = this.createLinkedList(valueArray);
	System.out.println(this.isPalindrome(head));
}

public void test_4(){
	int[] valueArray = {1,2,2,1};
	ListNode head = this.createLinkedList(valueArray);
	System.out.println(this.isPalindrome(head));
}

public void test_5(){
	int[] valueArray = {1,2,2,2};
	ListNode head = this.createLinkedList(valueArray);
	System.out.println(this.isPalindrome(head));
}

public void test_6(){
	int[] valueArray = {1,2,3,2,1};
	ListNode head = this.createLinkedList(valueArray);
	System.out.println(this.isPalindrome(head));
}

public void test_7(){
	int[] valueArray = {2,2,2,2,2};
	ListNode head = this.createLinkedList(valueArray);
	System.out.println(this.isPalindrome(head));
}

public ListNode createLinkedList(int[] valueArray){
	ListNode head = null, result = null;
	for(int i = 0;i < valueArray.length;i ++){
		ListNode tempNode = new ListNode(valueArray[i]);
		if(head != null)
			head.next = tempNode;
		if(result == null)
			result = tempNode;
		head = tempNode;
	}	
	return result;
}