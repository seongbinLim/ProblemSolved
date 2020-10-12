package done;
import java.util.Scanner;

public class BackJoon13458 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] room = new int[N];
		
		for(int i=0; i<N; i++) {
			room[i] = sc.nextInt();
		}
		
		int teacher = sc.nextInt();
		int teacher2 = sc.nextInt();
		
		long count = N;
		
		for(int i=0; i<N; i++) {
			room[i] -= teacher;
			if(room[i] > 0) {
				if(room[i]%teacher2==0) {
					count += room[i]/teacher2;
				} else {
					count += room[i]/teacher2 + 1;
				}
			}
		}
		
		System.out.println(count);

	}

}
