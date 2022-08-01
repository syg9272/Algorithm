import java.util.Scanner;

public class BJ10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n));
	}
	static int factorial(int n) {
		if(n > 1) {
			n *= factorial(n-1);
		}else {
			return 1;
		}
		return n;
	}
}
