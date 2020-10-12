package D4;

import java.util.Scanner;

public class D4_다항식계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int test=1; test<=T; test++) {
			sb.append("#").append(test);
			int N = sc.nextInt();

			t = new int[100];
			a = new int[100];
			b = new int[100];
			
			for(int i=2; i<=N; i++) {
				t[i] = sc.nextInt();
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			
			int M = sc.nextInt();
			
			for(int i=0; i<M; i++) {
				long[] result = new long[100];
				result[0] = 1;
				result[1] = sc.nextLong();
				for (int j = 2; j <= N; j++) {
					if (t[j] == 1)
						result[j] = (result[a[j]] + result[b[j]]) % 998244353;
					else if (t[j] == 2)
						result[j] = (a[j] * result[b[j]]) % 998244353;
					else if (t[j] == 3)
						result[j] = (result[a[j]] * result[b[j]]) % 998244353;
				}
				//long ans = function(N, result[i])%998244353;
				sb.append(" " + result[N]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int[] t, a, b;
	static int function(int N, int x) {
		if(N==0) return 1;
		else if(N==1) return x;
		else { //if(N>2) {
			if(t[N]==1)
				return function(a[N], x) + function(b[N], x);
			else if(t[N]==2)
				return a[N] * function(b[N], x);
			else //(t[N]==3)
				return function(a[N], x) * function(b[N], x);
		}
	}
}
