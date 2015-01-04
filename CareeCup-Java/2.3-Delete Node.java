// 	given a node, delete it from the oringal Linkedlist
//	Notice that if this is the last node, there can't be a solution without giving its previous node
public void deleteNode(ListNode current){
	if(current == null)
		return;
	else if(current.next == null){
		// undefined operation here
		current.val = -1;
		return;
	}
	else{
		current.val = current.next.val;
		current.next = current.next.next;
		return;
	}
}