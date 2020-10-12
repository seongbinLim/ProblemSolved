package done;
import java.util.Scanner;

public class BackJoon1592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] receive = new int[N];
		int count = 0;
		int idx = 0;
		receive[idx]++;
		
		while(receive[idx] < M) {
			if( receive[idx]%2 == 1 ) {
				idx = (idx+L)%N;
			} else {
				if(idx-L < 0) {
					idx = idx+N;
				}
				idx = idx-L;
			}
			
			receive[idx]++;
			count++;
		}
		
		System.out.println(count);
		
    
	}

}
