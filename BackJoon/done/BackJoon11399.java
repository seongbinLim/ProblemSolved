package done;
import java.util.Arrays;
import java.util.Scanner;

public class BackJoon11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] people = new int[N];
		
		for(int i=0; i<N; i++) {
			people[i] = sc.nextInt();
		}
		
		Arrays.sort(people);
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				total += people[j];
			}
		}
		
		System.out.println(total);
	}

}
