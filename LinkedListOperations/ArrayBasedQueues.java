

public class ArrayBasedQueues<T>
{
	T[] arr;
	int index;
	int size;
	public ArrayBasedQueues()
	{
		arr = (T[]) new Object[16];
		index = 0;	
		size = arr.length;
	}
	//Method that calls resize method to check if it is 90% full and then pushes element into array based queue
	public void offer(T element)
	{
		resize();
		arr[index] = element;
		index++;
	}
	//Method that pulls the element from the queue and calls resize method to check if it is mostly empty
	public T poll()
	{
		T temp = null;
		if(index!=0)
		{
			temp = arr[0];
			for(int i=0; i<index-1; i++)
				arr[i] = arr[i+1];
			arr[index-1] = null;
			index--;
			resize();
			return temp;	
		}
		return null;
	}
	//Method that returns the head of the queue
	public T peek()
	{
		if(size!=0)
		{
			return arr[0];
		}
		return null;
	}
	public boolean isEmpty()
	{
		return (index == 0);
	}
	//Method that checks the size of the queue and resizes if it is 90% full or less than 25% occupied
	public void resize()
	{
		T[] temp;
		if(((index) > 0.9*size) && size >= 16)
		{
			temp = (T[]) new Object[2*size]; 
			for(int i=0; i<index;i++)
				temp[i] = arr[i];
			arr = temp;
		}
		else if(((index) < 0.25*size) && size>16)
		{
			temp = (T[]) new Object[size/2];
			for(int i=0; i<index; i++)
				temp[i] = arr[i];
			arr = temp;
		}
		size = arr.length;
	}
	public static void main(String[] args)
	{
		ArrayBasedQueues<Integer> abq = new ArrayBasedQueues<>();
		abq.offer(68);
		abq.offer(8);
		abq.offer(143);
		abq.offer(3);
		abq.offer(108);
		abq.offer(8);
		abq.offer(100);
		abq.offer(109);
		System.out.println(abq.peek());
		System.out.println(abq.poll());
		System.out.println(abq.poll());
		System.out.println(abq.poll());
		System.out.println(abq.poll());
	}

}
