/*
Authors : Abhitej Boorla
		: Mandanapu Anvesh
		: Chandrika Cherukuri
		: Raghunadh Metta
*/
public class Sorting 
{
  /*
   * Merge Sort for generic arrays
   */
  //Method that takes input and temporary generic arrays and calls the overloaded method for Merge Sorting 
  public static<T extends Comparable<? super T>> void mergeSort(T[] arr,T[] tmp)
  {
	  mergeSort(arr,0,arr.length-1,tmp);
  }
  //Overloading the method by passing start and end indexes of the recursive sub-arrays
  private static <T extends Comparable<? super T>> void mergeSort(T[] arr,int start, int end,T[] tmp)
  {
	  int mid=(start+end)/2;
	  if(start<end){
		  mergeSort(arr,start, mid,tmp);
		  mergeSort(arr,mid+1,end,tmp);
		  merge(arr,start,mid,end,tmp);
	  }  
  }
  //Method that merges the sorted sub-arrays into the tmp array 
  private static <T extends Comparable<? super T>>void merge(T[] arr,int start,int mid, int end,T[] tmp)
  {
	  int pointer1=start;
	  int pointer2=mid+1;
	  int i=start;
	  while(!(pointer1>mid||pointer2>end)){
	  if(arr[pointer1].compareTo(arr[pointer2])>0)
	  {
		  tmp[i]=arr[pointer2];
		  pointer2++;
		 
		  }
	  else
	  {
		  tmp[i]=arr[pointer1];
		  pointer1++; 
	  }
	  i++;
	  }
	  if(pointer1>mid){
		  for(;i<=end;i++){
			  tmp[i]=arr[pointer2];
			  pointer2++;
		  }
	  }
	  if(pointer2>end){
		  for(;i<=end;i++){
			  tmp[i]=arr[pointer1];
			  pointer1++;
		  }
	  }
	  for(int j=start;j<=end;j++){
		  arr[j]=tmp[j];
	  }
  }
  /*
   * Merge sort for int arrays
   */
  //Method that takes input and temporary int arrays and calls the overloaded method for Merge Sorting
  public static void mergeSort(int[] arr,int[] tmp) 
  {
	  mergeSort(arr,0,arr.length-1,tmp);
  }
  //Overloading the method by passing start and end indexes of the recursive sub-arrays
  private static void mergeSort(int[] arr,int start, int end,int[] tmp)
  {
	  int mid=(start+end)/2;
	  if(start<end){
		  mergeSort(arr,start, mid,tmp);
		  mergeSort(arr,mid+1,end,tmp);
		  merge(arr,start,mid,end,tmp);
	  }  
  }
  //Method that merges the sorted sub-arrays into the tmp array
  private static void merge(int[] arr,int start,int mid, int end,int[] tmp){
	  int pointer1=start;
	  int pointer2=mid+1;
	  int i=start;
	  while(!(pointer1>mid||pointer2>end)){
	  if(arr[pointer1] > (arr[pointer2])){
		  tmp[i]=arr[pointer2];
		  pointer2++;
		 
		  }
	  else
	  {
		  tmp[i]=arr[pointer1];
		  pointer1++; 
	  }
	  i++;
	  }
	  if(pointer1>mid){
		  for(;i<=end;i++){
			  tmp[i]=arr[pointer2];
			  pointer2++;
		  }
	  }
	  if(pointer2>end){
		  for(;i<=end;i++){
			  tmp[i]=arr[pointer1];
			  pointer1++;
		  }
	  }
	  for(int j=start;j<=end;j++){
		  arr[j]=tmp[j];
	  }
  }
  /*
   * Insertion sort
   */
  //Method that performs Insertion sort by taking input array and modifies the array
  public static<T extends Comparable<? super T>> void nSquareSort(T[] arr){
	  for(int i=1;i<arr.length;i++){
		  int k=i;
		  for(int j=k-1;j>=0;j--){
			  if(arr[k].compareTo(arr[j])==-1){
				  T temp=arr[j];
				  arr[j]=arr[k];
				  arr[k]=temp;
				  k--;
			  }
		  }
	  }
  }
}