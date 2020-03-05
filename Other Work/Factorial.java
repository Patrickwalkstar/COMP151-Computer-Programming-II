
public class Factorial {
	/* calculates n factorial
	*/
	public static int factorial(int n) {
		//try {
	     System.out.println("n is " + n);
	if (n <= 0)
	    return 1;
	else {
	    System.out.println("need factorial of " 
	                       + (n-1));
	    int answer = factorial(n-1);
	    System.out.println("factorial of " +(n-1) +
	                     " is " + answer);
	    return answer * n;
	}
		//}
		//catch(StackOverflowException ex) {
			//System.out.println(I"Invalid Number");
		}

	public static void main(String[] args) {
	System.out.println(factorial(-1));
	}

}
