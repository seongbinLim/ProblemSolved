package D3;
import java.util.Scanner;

public class D3_3499 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int test = 1; test <= tc; test++) {
			int N = sc.nextInt();
			String[] input = new String[N];
			String[] shuffle = new String[N];
			
			for(int i=0; i<N; i++) {
				input[i] = sc.next();
			}
			String ans = "";
			int mid = (int) Math.round(N/2.0);
			int idx = 0;
			for(int i=0; i<mid; i++) {
				shuffle[idx] = input[i];
				ans += " " + shuffle[idx];
				if(i+mid < N) {
					shuffle[idx+1] = input[i+mid];
					ans += " " + shuffle[idx+1];
				}
				idx+=2;
			}
			
			System.out.println("#" + test + ans);
			
		}

	}

}
