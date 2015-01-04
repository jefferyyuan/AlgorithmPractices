//	Change a LinkedList according to a value,
//	so that all nodes that have smaller values than it will come ahead of 
//	all nodes that have larger values than it.
//	Here we assume that in each part the relative orders will not change
//	O(n) time, O(1) space
public ListNode reorderByValue(ListNode head, int value){
	ListNode fakeHeadSmall = new ListNode(-1);
	ListNode fakeHeadLarge = new ListNode(-1);
	ListNode indexSmall = fakeHeadSmall, indexLarge = fakeHeadLarge;
	while(head != null){
		if(head.val < value){
			indexSmall.next = head;
			indexSmall = head;
		}
		else{
			indexLarge.next = head;
			indexLarge = head;
		}
		head = head.next;
	}
	indexSmall.next = fakeHeadLarge.next;
	indexLarge.next = null;
	return fakeHeadSmall.next;
}