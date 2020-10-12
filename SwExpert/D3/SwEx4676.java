package D3;

import java.util.Arrays;
import java.util.Scanner;

public class SwEx4676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			String input = sc.next();
			int N = sc.nextInt();
			
			int[] idx = new int[N];
			for(int i=0; i<N; i++) {
				idx[i] = sc.nextInt();
			}
			Arrays.sort(idx);
			String ans = "";
			int index = 0;
			int s_idx = 0;
			while(index < input.length() || s_idx < N) {
				//System.out.println(ans);
				if(s_idx < N && index == idx[s_idx]) {
					ans+="-";
					s_idx++;
				} else {
					ans += input.charAt(index++);
				}
			}
			
			System.out.println("#" + test + " " + ans);
		}

	}

}
