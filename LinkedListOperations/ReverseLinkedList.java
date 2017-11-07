
/*ABHITEJ BOORLA
  RAGHUNADH METTA
  CHANDRIKA CHERUKURI
  MANDANAPU ANVESH*/

import java.util.ArrayDeque;

import SinglyLinkedList.Entry;

public class ReverseLinkedList {

	/*
     * Reverse the LinkedList without recursion
     */
    public static <E extends Comparable<? super E>> void reverseLinkedListWithOutRecursion(SinglyLinkedList<E> list){
    	Entry<E> ptr1, ptr2, ptr3;
    	if(list.head.next == null ){
    		return;
    	}
    	ptr1 = list.head;
    	ptr2 = ptr1.next;
    	ptr3 = ptr2.next;
    	ptr1 = null;
    	while(ptr3 != null){
    		ptr2.next = ptr1;
    		ptr1 = ptr2;
    		ptr2 = ptr3;
    		ptr3 = ptr3.next;
    	}
    	ptr2.next = ptr1;
    	ptr3 = new Entry<E>(null, null);
    	ptr3.next = ptr2;
    	list.head = ptr3;
    }
    
    
    
    /*
     * Print the LinkedList without recursion in reverse order
     */
    public static <E extends Comparable<? super E>> void printLinkedListReverseWithOutRecursion(SinglyLinkedList<E> list){
    	if(list.head.next == null){
    		return;
    	}
    	ArrayDeque<Entry<E>> stack= new ArrayDeque<Entry<E>>();
    	Entry<E> start = list.head.next;			
    	while(start != null){
    		stack.push(start);
    		start = start.next;
    	}
    	System.out.println("printing list in reverse order(iterative method)");
    	while(!stack.isEmpty()){
    		System.out.print(" "+stack.pop().element);
    	}
    }
    
    /*
     * Reverse the LinkedList using recursion
     */
    public static <E extends Comparable<? super E>> void reverseLinkedListRecursion(SinglyLinkedList<E> list){
    	if(list.head.next == null){
    		return;
    	}
    	list.head = reverseLinkedListRecursion(list.head.next);
    }
    
    public static <E extends Comparable<? super E>>  Entry<E> reverseLinkedListRecursion(Entry<E> start){
    	Entry<E> head = start;
     	Entry<E> tempElem1 = null;
    	Entry<E> tempElem2 = null;
    	Entry<E> newHead = new Entry<E>(null, null);
    	if(head != null){
    		tempElem1 = head;
    		head = head.next;
    	}
    	if(head != null){
    		tempElem2 = head;
    		head = head.next;
    	}
    	else{
    		newHead.next = tempElem1;
    		return newHead;
    	}
    	newHead = reverseLinkedListRecursion(tempElem2);
    	reverseLink(tempElem1, tempElem2);
		return newHead;
    }
    
    public static <E extends Comparable<? super E>> void reverseLink(Entry<E> tempElem1, Entry<E> tempElem2){
    	tempElem2.next = tempElem1;
    	tempElem1.next = null;
    }
    
    /*
     * print the LinkedList in inverse order using recursion
     */
    public static <E extends Comparable<? super E>> void printListReverseRecursion(SinglyLinkedList<E> list){
    	if(list.head.next == null){
    		return;
    	}
    	System.out.println("Printing List in reverse order using recursion: ");
    	printListReverseRecursion(list.head.next);
    }
    
    public static <E extends Comparable<? super E>> void printListReverseRecursion(Entry<E> start){
    	if(start != null){
    		printListReverseRecursion(start.next);
    		System.out.print(" "+start.element);
    	}
    }
    public static void main(String[] args) {
    	 int n = 5;
         if(args.length > 0) {
             n = Integer.parseInt(args[0]);
         }

         SinglyLinkedList<Integer> lst = new SinglyLinkedList<>();
         for(int i=1; i<=n; i++) {
             lst.add(new Integer(i));
         }
         lst.printList();
         //reverseLinkedListRecursion(lst);
          //reverseLinkedListWithOutRecursion(lst);
         //lst.printList();
         //printListReverseRecursion(lst);
         printLinkedListReverseWithOutRecursion(lst);
	}
	
}
