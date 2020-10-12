package D4;

import java.util.Scanner;

public class D4_화섭이의미생물배양2 {
	static int E, S, T, A, B;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		E = sc.nextInt();
		for(int t=1; t<=E; t++) {
			S = sc.nextInt();
			T = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			min = Integer.MAX_VALUE;
			if(B==1) {//worst case 1*1*1... 방지
				if((T-S)%4==0) {
					min = (T-S)/A;
				} else {
					min = Integer.MAX_VALUE;
				}
			} else {
				dfs(T,0);
			}
			
			System.out.println("#"+t+" "+(min==Integer.MAX_VALUE?-1:min));
		}
	}

	private static void dfs(int t3, int cnt) {
		if(t3<S) return;
		if(t3==S) {
			min = Math.min(min, cnt);
			return;
		}
		if(t3%B==0) {
			dfs(t3/B, cnt+1);
			dfs(t3-A, cnt+1);
		} else {
			dfs(t3-A, cnt+1);
		}
	}

}
