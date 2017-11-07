
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
	/*
	 * This method performs the union set operation on the sorted lists l1 and l2
	 * returns the unioned list in the sorted order
	 */
	public static<T extends Comparable<? super T>> void union(List<T> l1, List<T> l2, List<T> outList) {
		Iterator<T> l1Iterator = l1.iterator();
    	Iterator<T> l2Iterator = l2.iterator();
		T tempL1 = next(l1Iterator);
		T tempL2 = next(l2Iterator);
		while(tempL1 != null || tempL2 != null){
			if(tempL1 == null){
				outList.add(tempL2);
				tempL2 = next(l2Iterator);
			}
			else if(tempL2 == null){
				outList.add(tempL1);
				tempL1 = next(l1Iterator);
			}
			else if(tempL1.compareTo(tempL2) == 0){
    			outList.add(tempL1);
    			tempL1 = next(l1Iterator);
    			tempL2 = next(l2Iterator);
    		}
    		else if(tempL1.compareTo(tempL2) > 0){
    			outList.add(tempL2);
    			tempL2 = next(l2Iterator);
    		}
    		else{
    			outList.add(tempL1);
    			tempL1 = next(l1Iterator);
    		}
		}
	}
	
	/*
	 * This method performs the difference set operation on the sorted lists l1 and l2
	 * returns the outList in the sorted order
	 */
	public static<T extends Comparable<? super T>> void difference(List<T> l1, List<T> l2, List<T> outList) {
		Iterator<T> l1Iterator = l1.iterator();
    	Iterator<T> l2Iterator = l2.iterator();
    	T l1Temp = next(l1Iterator);
    	T l2Temp = next(l2Iterator);
    	while(l1Temp != null){
    		if(l2Temp == null){
    			outList.add(l1Temp);
    			l1Temp = next(l1Iterator);
    		}
    		else if(l1Temp.compareTo(l2Temp) == 0){
    			l1Temp = next(l1Iterator);
    			l2Temp = next(l2Iterator);
    		}
    		else if(l1Temp.compareTo(l2Temp) > 0){
    			l2Temp = next(l2Iterator);
    		}
    		else{
    			outList.add(l1Temp);
    			l1Temp = next(l1Iterator);
    		}
    	}
    	
	}
	/*
	 * This method performs the intersection set operation on the sorted lists l1 and l2
	 * returns the intersected list in the sorted order
	 */
    public static<T extends Comparable<? super T>> void intersect(List<T> l1, List<T> l2, List<T> outList) {
    	Iterator<T> l1Iterator = l1.iterator();
    	Iterator<T> l2Iterator = l2.iterator();
    	T tempL1 = next(l1Iterator);
    	T tempL2 = next(l2Iterator);
    	while(tempL1 != null && tempL2 != null){
    		if(tempL1.compareTo(tempL2) == 0){
    			outList.add(tempL1);
    			tempL1 = next(l1Iterator);
    			tempL2 = next(l2Iterator);
    		}
    		else if(tempL1.compareTo(tempL2) > 0){
    			tempL2 = next(l2Iterator);
    		}
    		else{
    			tempL1 = next(l1Iterator);
    		}
    	}
    }
    public static <T> T next(Iterator<T> itr){
    	return itr.hasNext() ? itr.next() : null;
    }
	public static void main(String[] args) {
		LinkedList<Integer> outList= new LinkedList<>();
		//intersect(new LinkedList<Integer>(Arrays.asList(5, 6, 7)), new LinkedList<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)), outList);
		//union(new LinkedList<Integer>(Arrays.asList(5, 6, 7)), new LinkedList<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12)), outList);
		difference(new LinkedList<Integer>(Arrays.asList(7, 8, 9, 10, 11, 12, 13, 14, 17)), new LinkedList<Integer>(Arrays.asList(5, 6, 7, 12, 13, 16)), outList);

		System.out.println(outList);
	}
}
