package D3;
import java.util.Scanner;

public class D3_3809 {
	static boolean[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int[] digit = new int[N];
			boolean[] check = new boolean[1000];
			
			for(int i=0; i<N; i++) {
				digit[i] = sc.nextInt();
				check[digit[i]] = true;
				
			}

			for(int i=0; i<N-1; i++) {
				check[digit[i]*10 + digit[i+1]] = true;
			}
			
			for(int i=0; i<N-2; i++) {
				check[digit[i]*100 + digit[i+1]*10 +digit[i+2]] = true;
			}
			
			for(int i=0; i<1000; i++) {
				if(!check[i]) {
					System.out.println("#"+test+" " + i);
						break;
					}
				}
			}
	}
	


}
