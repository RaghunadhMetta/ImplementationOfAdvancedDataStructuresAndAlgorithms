

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;


public class TreeMapProblems {
	//Method that finds the number of pairs in array A whose sum is equal to X
	static int howMany(int[] A, int X) {
		int i,numberOfPairs=0;
		//Taking a TreeMap to store the elements and their count
		TreeMap<Integer, Integer> tMap = new TreeMap<>();
		for(i=0;i<A.length;i++) {
			//For the first occurence of an element, making the count of it as 1
			if(tMap.get(A[i])==null) {
				tMap.put(A[i], 1);
			}
			//For the next occurence, taking the value(count) of the element into temp and incrementing the count 
			else {
				int tempCount=tMap.get(A[i]);
				tMap.put(A[i], ++tempCount);
			}
		}
		for(Integer j:tMap.keySet()) {
			int compliment = X-j;
			//When we get the count of an element in map as 0, we are coming out of the iteration
			//as we have all the compliments from then onwards
			if(tMap.get(j)==0) {
				break;
			}
			//If compliment is found, getting the count of pairs by multiplying the count of number
			//and it's compliment
			if(tMap.get(compliment)!=null) {
				//If the number and it's compliment are same, counting the number of pairs as n(n-1)/2
				if(compliment==j) {
					numberOfPairs+=(tMap.get(j)*(tMap.get(j)-1))/2;
				}
				//After taking the count, making the compliment's count as 0 to avoid recounting at compliment
				else {
				numberOfPairs+=tMap.get(compliment)*tMap.get(j);
				tMap.put(compliment, 0);
				}
			}
		}
		return numberOfPairs;
	   }
	
	//Method that returns the array of elements whose occurance in A is exactly once
	static<T extends Comparable<? super T>> ArrayList<T> exactlyOnce(T[] A) {
		int i, sizeOfA = A.length;
		//Taking a TreeSet to store the indices of elements whose occurence is once
		TreeSet<Integer> tSet = new TreeSet<>();
		//Taking a TreeMap to store the element and it's index
		TreeMap<T, Integer> tMap = new TreeMap<>();
		for(i=0;i<sizeOfA;i++) {
			//Adding the entries for the first occurence
			if(tMap.get(A[i])==null) {
				tMap.put(A[i], i);
				tSet.add(i);
			}
			//If the number is repeating, removing the index from TreeSet
			else {
				tSet.remove(tMap.get(A[i]));
			}
		}
		ArrayList<T> output = new ArrayList<>();
		Iterator<Integer> it = tSet.iterator();
		//Taking the output by indexing using TreeSet values
		while(it.hasNext()) {
				output.add(A[it.next()]);
		}
		return output;
	   }
	
	public static void main(String[] args) {
		int[] a = {3,3,4,5,3,5};
		Integer[] b = {6,3,4,5,3,5};
		System.out.println("Pairs:" +howMany(a, 8));
		ArrayList<Integer> output = exactlyOnce(b);
		for(int i=0;i<output.size();i++) {
			System.out.print(output.get(i)+" ");
		}
	}
}
