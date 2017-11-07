/*ABHITEJ BOORLA
  RAGHUNADH METTA
  CHANDRIKA CHERUKURI
  MANDANAPU ANVESH*/ 

public class ArrayBasedStack <T> {
	int size;
	T [] array;
	int cursor;
	public ArrayBasedStack(int size){
		array =(T[]) new Object[size];
		this.size = size;
		cursor = -1;
	}
	public void push(T value){
		if(cursor == size-1){
			throw new RuntimeException("Stack is full!");
		}
		else{
			cursor += 1;
			array[cursor] = value;
		}
	}
	public T peek(){
		return array[cursor];
	}
	public T pop(){
		if(cursor >= 0){
			T value = array[cursor];
			cursor -= 1;
			return value;
		}
		return null;
	}
	public static void main(String[] args) {
		ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(5);
		/*stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		//stack.push(6);
		System.out.println("pop()"+stack.pop());
		System.out.println("pop()"+stack.pop());
		System.out.println("pop()"+stack.pop());
		System.out.println("pop()"+stack.pop());
		System.out.println("pop()"+stack.pop());
		System.out.println("pop()"+stack.pop());
		System.out.println("pop()"+stack.pop());
		stack.push(1);
		System.out.println("pop()"+stack.peek());*/
	}
}
