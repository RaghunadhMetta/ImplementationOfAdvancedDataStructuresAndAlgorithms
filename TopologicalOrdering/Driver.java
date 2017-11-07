/*
Authors : Abhitej Boorla
		: Mandanapu Anvesh
		: Chandrika Cherukuri
		: Raghunadh Metta
*/
public class Driver {

	public static void main(String[] args) {
		int[] sizes = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		for(int i = 0; i<=5; i++){
			int index = (int)(Math.random()*sizes.length);
			int numOfElements = sizes[index]* new Double(Math.pow(10,6)).intValue();
			Integer[] list = new Integer[numOfElements];
			int[] mergeSortInt = new int[numOfElements];
			for(int j=0; j<numOfElements; j++){
				list[j] = j ;
			}
			Shuffle.shuffle(list);
			for(int j=0 ; j<list.length; j++){
				mergeSortInt[j] = list[j];
			}
			Integer[] duplicateList = list.clone();
			Timer timer = new Timer();
			timer.start();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Size of the input array: "+sizes[index]+"M");
			Sorting.mergeSort(mergeSortInt, new int[mergeSortInt.length]);
			System.out.println("For Merge Sort with int arrays " + timer.end().toString());
			timer.start();
			Sorting.mergeSort(list, new Integer[list.length]);
			System.out.println("For Merge Sort with Generic arrays " + timer.end().toString());
			timer.start();
			Sorting.nSquareSort(duplicateList);
			System.out.println("For Insertion Sort " + timer.end().toString());
			System.out.println("After Sorting :");
		}
		
	}
}