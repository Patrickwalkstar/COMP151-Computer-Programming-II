import java.io.*;
public class RecursionExample {
  public static void main(String [] patrick){
   System.out.println(factorialNoneRecursive(5));
   System.out.println(factorialRecursive(5));
   System.out.println(recursiveSummation(5));
    int arr[] = {2,5, 15, 30, 35, 60, 70, 145};
    System.out.println(binarySearch(arr, 0, arr.length - 1, 60));
  }
  public static int binarySearch(int [] arr, int start, int end, int val){
    int mid = (start + end + 1)/2;
    if(arr[mid]==val)
      return mid; //Base Case
    else if(end <= start)
      return -1;//Base Case #2
    else if(arr[mid] > val)
      return binarySearch(arr, start, mid, val);
    else
      return binarySearch(arr, mid, end, val);
    
 }
 public static int factorialRecursive(int num){
   if(num ==1)
     return num; //Base Case
   else 
     return num* factorialRecursive(num - 1);
 }
 public static int factorialNoneRecursive(int num) {
   int f = 1;
   for(int i = 1; i <= num; i++)
     f = f*i; //f *=i;
   return f;
 }

 public static int recursiveSummation(int n) {
	if(n == 1)
		return 1;
	else if (n < 0)
		return -n;
		else { 
			int answer = recursiveSummation(n-1);
			return answer + n;	
		}
	}

    
}