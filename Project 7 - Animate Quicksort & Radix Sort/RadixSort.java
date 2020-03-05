import java.util.Arrays;

/*Name: RadixSort
 * Authors: Devon Stedronsky & Patrick Lee Walker
 * Date Last Modified: 12-20-2017
 * 
 * Description:
 * Main method generates 1M random integers and then uses the defined methods to apply radix sort.
 * countSort is applied iteratively to decimal place to gradually sort the array.
 */

public class RadixSort {

	//Get max number in the array to be used for limiting how many digits required to sort
	static int getMax(int[] arr, int size) {
		int mx = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > mx) {
				mx = arr[i];
			}
		}
			return mx;
	}
	
	
	/*Sort the array based on the digits in the place exp
	 * This is applied iteratively for each place up to the max required to sort the largest number
	 */
	static void countSort (int[] arr, int size, int exp) {
		int i;
		int[] output = new int[size];
		int[] count = new int[10];
		Arrays.fill(count,  0);
		
		//Counts the number of occurrences of each digit of the integer array
		for(i = 0; i < size; i++) {
			count[ (arr[i]/exp)%10 ]++;
		}
		
		//Count[i] now contains sorted position of digit in output
		for (i = 1; i < 10; i++) {
			count [i] += count[i - 1];
		}
		
		//Build the output array which is sorted based on the digit at place exp
		for (i = size - 1; i >= 0; i--) {
			output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
			count[ (arr[i]/exp)%10 ]--;
		}
		
		//Change the initial array to the new sorted output array
		for (i = 0; i < size; i++) {
			arr[i] = output[i];
		}	
	}
	
	
	//Perform radix sort by sorting at each place iteratively
	static void radixSort(int[] numbers, int size) {
		int m = getMax(numbers, size);
		
		for (int exp = 1; m/exp > 0; exp *= 10) {
			countSort(numbers, size, exp);
		}
	}
	
	
	//Print method for arrays (for testing small size arrays)
	static void print(int[] arr, int size) {
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + "   ");
		}
	}
	
	
	//Testing sorted
	static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		//Create array of 1M random integers between 0 and 2147483647
		int[] numbers = new int[1000000];
		double rando;
		int currNum;
		
		for (int i = 0; i < numbers.length; i++) {
			rando = Math.random();
			currNum = (int) (rando*2147483647);
			numbers[i] = currNum;
		}
		
		//Test if array is sorted before and after radix sort
		System.out.println(isSorted(numbers));
		int size = numbers.length;
		radixSort(numbers, size);
		System.out.print(isSorted(numbers));
	}
}
