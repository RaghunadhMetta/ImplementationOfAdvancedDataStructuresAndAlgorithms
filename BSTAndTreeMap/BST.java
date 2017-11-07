


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class BST<T extends Comparable<? super T>> implements Iterable<T> {
    static class Entry<T> {
        T element;
        Entry<T> left, right;

        Entry(T x, Entry<T> left, Entry<T> right) {
            this.element = x;
	    			this.left = left;
	    			this.right = right;
        }
    }
    Entry<T> root;
    int size;
    public BST() {
			root = null;
			size = 0;
    }


    
    // Checks is the tree contains the element x
    public boolean contains(T x) {
      Entry<T> temp=root;
      while(temp!=null){
        if(temp.element.compareTo(x)==0)
        { 
         	return true;
        }
        else if(temp.element.compareTo(x)==1){
          
          
           if(temp.left==null)
           { 
             return false;
           }
           else
             temp=temp.left;
        }
        
        else{
          if(temp.right==null)
            { 
            	return false;
            }
          else{
             temp=temp.right;
          }
        }
      
    }
      return false;
    }

  /*Checks if  there is an element that is equal to x in the tree and
       Element in tree that is equal to x is returned, null otherwise.*/
       
     
    public T get(T x) {
      Entry<T> temp=root;
      while(temp!=null){
        if(temp.element.compareTo(x)==0)
        { 
        	return x;
        }
        else if(temp.element.compareTo(x)==1){
           if(temp.left==null)
           { 
             return null;
           }
          else{
             temp=temp.left;
          }
        }
        
        else{
           if(temp.right==null)
            { 
             return null;
            }
          else{
             temp=temp.right;
          }
        }
			
    }
      return null;
    }
  /* Add x to tree. 
       If tree contains a node with same key, replaces element by x.
       Returns true if x is a new element added to tree.*/
     
    public boolean add(T x) {
    	
      Entry<T> temp=root;
      while(temp!=null){
        if(temp.element.compareTo(x)==0)
        { 
          temp.element=x;
         	return true;
        }
        else if(temp.element.compareTo(x)==1){
           if(temp.left==null)
           { 
            temp.left=new Entry<>(x,null,null);
            size++;
            return true;
           }
          else{
             temp=temp.left;
          }
        }
        else{
            if(temp.right==null)
            { 
            	temp.right=new Entry<>(x,null,null);
             	size++;
             	return true;
            }
          else{
             temp=temp.right;
          }
        }
      }
        
      root= new Entry(x,null,null);
      return true;
    }
    
    /*  Removes x from tree. 
       Return x if found, otherwise return null*/
     
    
    public T remove(T x) {
      if(!contains(x)){
      	return null;
      }
      else{
        Entry<T> temp = root;
        Entry<T> parent = null;
        while(temp != null){
          if(temp.element.compareTo(x) == 0){
            if(temp.left == null && temp.right == null){
              if(temp == root){
              	root =null;
              }
              else{
            	  if(parent.left==null){
                  	parent.right = null;
                  }
            	  else if(parent.right==null){
            		  parent.left = null;
            	  }
            	  
            	  else if(parent.left.element.compareTo(x) == 0){
                	parent.left = null;
                }
                else{																																
                	parent.right = null;																						
                }
                
              }
            }																																									
            else if(temp.right == null){
            	
            	if(parent.left==null){
                  	parent.right = parent.right.left;;
                  }
            	else if(parent.right==null){
            		parent.left=parent.left.left;
            	}
            	
            	else if(parent.left.element.compareTo(x)==0){
              	parent.left = parent.left.left;
              }
              else{
              	parent.right = parent.right.left;
              }
            }
            else{
            	T value = getSuccessor(temp);
              temp.element = value;
            }
            size--;
            return x;
          }
          else if(temp.element.compareTo(x) == 1){
          	parent = temp;
            temp = temp.left; 
          }
          else{
            parent = temp;
          	temp = temp.right;
          }
        }
      }
      return null;
    }
      
    //return the inorder successor of the tree and deletes that node
      public T getSuccessor(Entry<T> node)
      {
        Entry<T> parent=node;
        node=node.right;
        if(node.left==null)
        {
          parent.right=node.right;
          return node.element;
          
        }
        
        while(node.left!=null)
          {
            parent=node;
            node=node.left;
        }
        
          parent.left=node.right;
      
        
        return node.element;
        
      }
      
    /* Iterates elements in sorted order of keys*/
     
    public Iterator<T> iterator() {
			return new InOrderIterator<T>(root);
    }
    
    public static void main(String[] args) {
				BST<Integer> t = new BST<>();
        Scanner in = new Scanner(System.in);
        /*while(in.hasNext()) {
            int x = in.nextInt();
            if(x > 0) {
                System.out.print("Add " + x + " : ");
                t.add(x);
                t.printTree();
            } else if(x < 0) {
                System.out.print("Remove " + x + " : ");
                t.remove(-x);
                t.printTree();
            } else {
                Comparable[] arr = t.toArray();
                System.out.print("Final: ");
                for(int i=0; i<t.size; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                return;
                    */  
    
        ArrayList<Integer> a= new ArrayList<>(Arrays.asList(100,1,2,3,4,5,22,23,31,43,39,38,37,6,8,14,12));
        for(int x:a){
        	
        	t.add(x);
        }
        
       System.out.println(t.remove(43));
        
       Iterator<Integer> it=t.iterator();
        while(it.hasNext()){
        	System.out.println(it.next());
        	
        }
    }


    /* Creates an array with the elements using in-order traversal of tree*/
    public Comparable[] toArray() {
	Comparable[] arr = new Comparable[size];
	/* write code to place elements in array here */
	
	Iterator<T> it=iterator();
	int i=0;
    while(it.hasNext()){
    	arr[i]=it.next();
    	i++;
    	
    }
	
	
	return arr;
    }

    public void printTree() {
	System.out.print("[" + size + "]");
	printTree(root);
	System.out.println();
    }

    // Inorder traversal of tree
    void printTree(Entry<T> node) {
	if(node != null) {
	    printTree(node.left);
	    System.out.print(" " + node.element);
	    printTree(node.right);
	}
    }

}
/*
Sample input:
1 3 5 7 9 2 4 6 8 10 -3 -6 -3 0

Output:
Add 1 : [1] 1
Add 3 : [2] 1 3
Add 5 : [3] 1 3 5
Add 7 : [4] 1 3 5 7
Add 9 : [5] 1 3 5 7 9
Add 2 : [6] 1 2 3 5 7 9
Add 4 : [7] 1 2 3 4 5 7 9
Add 6 : [8] 1 2 3 4 5 6 7 9
Add 8 : [9] 1 2 3 4 5 6 7 8 9
Add 10 : [10] 1 2 3 4 5 6 7 8 9 10
Remove -3 : [9] 1 2 4 5 6 7 8 9 10
Remove -6 : [8] 1 2 4 5 7 8 9 10
Remove -3 : [8] 1 2 4 5 7 8 9 10
Final: 1 2 4 5 7 8 9 10 

*/

