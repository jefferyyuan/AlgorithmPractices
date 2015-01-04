
// 	use hashmap 
//	O(n) time, O(n) space
public ListNode removeDuplicates(ListNode head){
	if(head == null || head.next == null)
		return head;
	HashSet<Integer> record = new HashSet<Integer>();
	ListNode traverse = head;
	record.put(traverse.val);
	while(traverse.next != null){
		if(record.contains(traverse.next.val))
			traverse.next = traverse.next.next;
		else
			traverse = traverse.next;
	}
	return head;
}

//	without using HashSet
//	O(1) space, O(n^2) time
public ListNode removeDuplicates(ListNode head){
	ListNode fakeHead = new ListNode(-1);
	ListNode newHead = fakeHead;
	while(head != null){
		int checkValue = head.val;
		boolean isUnique = true;
		ListNode traverse = fakeHead.next;
		while(traverse != null){
			if(traverse.val == checkValue){
				isUnique = false;
				break;
			}
			else
				traverse = traverse.next;
		}
		if(isUnique){
			newHead.next = head;
			newHead = head;
			head = head.next;
			newHead.next = null;
		}
		else
			head = head.next;
	}
	return fakeHead.next;

}